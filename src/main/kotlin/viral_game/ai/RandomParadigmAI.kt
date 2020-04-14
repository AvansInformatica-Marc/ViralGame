package viral_game.ai

import viral_game.data.Paradigm

object RandomParadigmAI {
    fun doMove(@Suppress("UNUSED_PARAMETER") surroundingParadigmsFunction: () -> Collection<Paradigm>)
            = arrayOf(Paradigm.OO, Paradigm.FUNCTIONAL, Paradigm.DECLARATIVE).random()
}