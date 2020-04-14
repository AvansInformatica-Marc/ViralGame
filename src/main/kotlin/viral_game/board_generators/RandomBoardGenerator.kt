@file:Suppress("EXPERIMENTAL_API_USAGE", "EXPERIMENTAL_UNSIGNED_LITERALS")

package viral_game.board_generators

import viral_game.data.Paradigm
import viral_game.grid.Coordinates

object RandomBoardGenerator {
    val generator: BoardGenerator = { boardSize ->
        { coordinates ->
            randomBoardGenerator(coordinates, boardSize)
        }
    }

    private fun randomBoardGenerator(coordinates: Coordinates, boardSize: Pair<Int, Int>): Paradigm {
        val (x, y) = coordinates
        val (width, height) = boardSize

        val ooChance = when (x) {
            in 0 until width / 2 -> 8
            in 0 until width / 3 * 2 -> 4
            else -> 1
        }

        val dclChance = when {
            x in width / 3 * 2 until width && y in height / 3 * 2 until height -> 8
            x in width / 2 until width && y in height / 2 until height -> 4
            else -> 1
        }

        val fpChance = when {
            x in width / 3 * 2 until width && y in 0 until height / 2 -> 8
            x in width / 3 until width && y in 0 until height / 2 -> 4
            x in width / 2 until width && y in 0 until height / 3 * 2 -> 4
            else -> 1
        }

        return Array(ooChance + fpChance + dclChance) {
            when {
                it < ooChance -> Paradigm.OO
                it < ooChance + fpChance -> Paradigm.FUNCTIONAL
                else -> Paradigm.DECLARATIVE
            }
        }.random()
    }
}
