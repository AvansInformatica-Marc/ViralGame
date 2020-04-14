package viral_game.ai

import viral_game.data.Paradigm

object RandomBorderingParadigmAI {
    fun doMove(surroundingParadigmsFunction: () -> Collection<Paradigm>)
            = surroundingParadigmsFunction().random()
}