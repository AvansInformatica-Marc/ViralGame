package viral_game.grid

import viral_game.ParadigmOrPlayer
import viral_game.data.Player

typealias ViralGameGrid = Grid.RectGrid<ParadigmOrPlayer>

fun ViralGameGrid.getBorderingCellsForPlayer(player: Player): Collection<ViralGameCell> {
    val borderingCells = filter { cell ->
        cell.player == null && cell.surroundingCells.any { it.player == player }
    }

    val startCell by lazy {
        when(player) {
            Player.PLAYER1 -> upperLeft
            Player.PLAYER2 -> upperRight
            Player.PLAYER3 -> lowerLeft
            Player.PLAYER4 -> lowerRight
        }
    }

    return when {
        borderingCells.isNotEmpty() -> borderingCells
        startCell.player == null -> listOf(startCell)
        else -> emptyList()
    }
}
