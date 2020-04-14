package viral_game.board_generators

import viral_game.data.Paradigm
import viral_game.grid.Coordinates

typealias BoardGenerator = (boardSize: Pair<Int, Int>) -> (coordinates: Coordinates) -> Paradigm