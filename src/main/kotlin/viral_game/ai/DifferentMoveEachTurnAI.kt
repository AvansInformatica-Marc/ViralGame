package viral_game.ai

import viral_game.PlayerFunction
import viral_game.data.Paradigm

object DifferentMoveEachTurnAI {
    fun createAI(): PlayerFunction {
        var lastChoice = Paradigm.DECLARATIVE

        fun doMove(@Suppress("UNUSED_PARAMETER") surroundingParadigmsFunction: () -> Collection<Paradigm>): Paradigm {
            val newParadigm = when(lastChoice) {
                Paradigm.DECLARATIVE -> Paradigm.OO
                Paradigm.OO -> Paradigm.FUNCTIONAL
                Paradigm.FUNCTIONAL -> Paradigm.DECLARATIVE
            }

            lastChoice = newParadigm

            return newParadigm
        }

        return ::doMove
    }
}