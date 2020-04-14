package viral_game

import viral_game.data.Paradigm

object PhysicalPlayer {
    fun createPlayer(guiAskForInput: () -> Paradigm): PlayerFunction = { guiAskForInput() }
}