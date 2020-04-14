package viral_game

import arrow.syntax.function.andThen
import viral_game.ai.RandomAIAI
import viral_game.ai.RandomBorderingParadigmAI
import viral_game.ai.TacticalAI
import viral_game.board_generators.RandomBoardGenerator
import viral_game.board_generators.StaticBoardGenerator
import viral_game.data.Paradigm
import viral_game.data.Player.PLAYER2
import viral_game.gui.GameGUI
import viral_game.gui.MaterialTheme

fun aiSleep(surroundingParadigmsFunction: () -> Collection<Paradigm>): () -> Collection<Paradigm> {
    Thread.sleep(500)
    return surroundingParadigmsFunction
}

fun main() {
    MaterialTheme.enableMaterialTheme()

    val gridSize = 10

    val gameGUI = GameGUI(gridSize)

    val generator = arrayOf(
        StaticBoardGenerator::generate,
        RandomBoardGenerator.generator
    ).random()

    Game.startGame(
        gameGUI,
        Game.generateGrid(generator, gridSize),
        listOf(
            "SquarusTechTips" to (::aiSleep andThen TacticalAI::doMove),
            "KwebbelCube" to PhysicalPlayer.createPlayer { gameGUI[PLAYER2].askInput() },
            "SquareDieSquat" to (::aiSleep andThen RandomBorderingParadigmAI::doMove),
            "GridMeneer" to (::aiSleep andThen RandomAIAI.createAI())
        )
    )
}
