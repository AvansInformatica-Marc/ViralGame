package viral_game.ai

import viral_game.PlayerFunction

object RandomAIAI {
    fun createAI(): PlayerFunction {
        val listOfAI = arrayOf(
            RandomParadigmAI::doMove,
            RandomBorderingParadigmAI::doMove,
            DifferentMoveEachTurnAI.createAI(),
            TacticalAI::doMove
        )

        return { listOfAI.random()(it) }
    }
}