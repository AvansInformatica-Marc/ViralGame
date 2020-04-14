package viral_game.data

enum class Player {
    PLAYER1, PLAYER2, PLAYER3, PLAYER4;

    companion object {
        operator fun get(index: Int): Player = when(index) {
            0 -> PLAYER1
            1 -> PLAYER2
            2 -> PLAYER3
            3 -> PLAYER4
            else -> throw IndexOutOfBoundsException()
        }
    }
}