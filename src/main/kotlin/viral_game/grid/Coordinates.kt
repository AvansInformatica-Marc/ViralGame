package viral_game.grid

typealias Coordinates = Pair<Int, Int>

val Coordinates.x
    get() = first

val Coordinates.y
    get() = second