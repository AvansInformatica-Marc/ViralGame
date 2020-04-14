package viral_game

import arrow.core.left
import mdlaf.utils.MaterialColors
import viral_game.board_generators.BoardGenerator
import viral_game.data.Paradigm
import viral_game.data.Player
import viral_game.grid.*
import viral_game.gui.GameGUI
import java.awt.Color

object Game {
    private fun isFinished(grid: Collection<ViralGameCell>) = grid.all { it.player != null }

    fun startGame(gui: GameGUI, grid: ViralGameGrid, players: Players) {
        players.forEachIndexed { index, (name, _) ->
            gui[Player[index]].playerName = name
        }

        updateGrid(gui::changeSquare, grid)

        gameLoop(gui, grid, players)
    }

    /** Runs at each turn */
    private tailrec fun gameLoop(gui: GameGUI, grid: ViralGameGrid, players: Players) {
        players.forEachIndexed { index, (_, function) ->
            val player = Player[index]
            val borderingCells = grid.getBorderingCellsForPlayer(player)

            if(borderingCells.isNotEmpty()) {
                val chosenParadigm = function { borderingCells.mapNotNull { it.paradigm } }

                gui[player][chosenParadigm].probability += 1.0

                val collection = borderingCells.filter {
                    it.paradigm == chosenParadigm
                }

                if(collection.isNotEmpty()) {
                    collection.random().player = player

                    updateGrid(gui::changeSquare, grid)
                }
            }
        }

        if (!isFinished(grid))
            gameLoop(gui, grid, players)
    }

    fun generateGrid(generator: BoardGenerator, size: Int): ViralGameGrid =
        Grid.createSquareGrid(size) { (x, y) ->
            generator(size to size)(x to y).left()
        }

    /** Updates the colors of the GUI grid to match their current values */
    private tailrec fun updateGrid(
        changeSquare: (x: Int, y: Int, color: Color) -> Unit,
        cells: Collection<ViralGameCell>
    ) {
        val (head, tail) = cells.destructured()

        val (x, y) = head.coordinates
        changeSquare(x, y, when {
            head.paradigm == Paradigm.FUNCTIONAL -> MaterialColors.ORANGE_500
            head.paradigm == Paradigm.OO -> MaterialColors.PURPLE_500
            head.paradigm == Paradigm.DECLARATIVE -> MaterialColors.GRAY_500
            head.player == Player.PLAYER1 -> MaterialColors.BLUE_500
            head.player == Player.PLAYER2 -> MaterialColors.YELLOW_500
            head.player == Player.PLAYER3 -> MaterialColors.RED_500
            head.player == Player.PLAYER4 -> MaterialColors.GREEN_500
            else -> MaterialColors.GRAY_900
        })

        if(tail != null)
            updateGrid(changeSquare, tail)
    }
}