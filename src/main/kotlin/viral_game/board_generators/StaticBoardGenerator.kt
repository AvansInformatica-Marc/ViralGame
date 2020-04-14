package viral_game.board_generators

import viral_game.data.Paradigm
import viral_game.grid.Coordinates

object StaticBoardGenerator {
    fun generate(boardSize: Pair<Int, Int>): (Coordinates) -> Paradigm = when (boardSize) {
        10 to 10 -> { (x, y) ->
            when {
                x in 0..1 && (y in 0..2 || y in 6..9) -> Paradigm.OO
                x in 4..6 && y in 0..1 -> Paradigm.OO
                x in 2..3 && (y == 0 || y in 8..9) -> Paradigm.OO
                x == 7 && (y in 1..2 || y in 4..7) -> Paradigm.OO
                x == 3 && y in 6..7 -> Paradigm.OO
                x in 4..5 && y == 8 -> Paradigm.OO

                x in 8..9 && y in 0..6 -> Paradigm.FUNCTIONAL
                x in 4..6 && y in 5..7 -> Paradigm.FUNCTIONAL
                x != 4 && y == 3 -> Paradigm.FUNCTIONAL
                x == 2 && y in 1..2 -> Paradigm.FUNCTIONAL
                x in 5..6 && y == 2 -> Paradigm.FUNCTIONAL
                x == 0 && y in 4..5 -> Paradigm.FUNCTIONAL
                x == 4 && y == 4 -> Paradigm.FUNCTIONAL
                x == 7 && y == 0 -> Paradigm.FUNCTIONAL

                else -> Paradigm.DECLARATIVE
            }
        }
        else -> throw UnsupportedOperationException()
    }
}
