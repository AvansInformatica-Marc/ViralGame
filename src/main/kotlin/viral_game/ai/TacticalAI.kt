package viral_game.ai

import viral_game.data.Paradigm

object TacticalAI {
    fun doMove(surroundingParadigmsFunction: () -> Collection<Paradigm>): Paradigm {
        val surroundingParadigms = surroundingParadigmsFunction()
        val ooCells = surroundingParadigms.count { it == Paradigm.OO }
        val fpCells = surroundingParadigms.count { it == Paradigm.FUNCTIONAL }
        val dclCells = surroundingParadigms.count { it == Paradigm.DECLARATIVE }

        return when {
            dclCells > ooCells && dclCells > fpCells -> Paradigm.DECLARATIVE
            fpCells > ooCells -> Paradigm.FUNCTIONAL
            else -> Paradigm.OO
        }
    }
}
