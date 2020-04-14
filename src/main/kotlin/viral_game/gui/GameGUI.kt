package viral_game.gui

import viral_game.data.Player
import java.awt.*
import javax.swing.JFrame
import javax.swing.JPanel

class GameGUI(gridSize: Int, squareSize: Int = 25) {
    private val player1GUI = PlayerGUI("Player 1")
    private val player2GUI = PlayerGUI("Player 2")
    private val player3GUI = PlayerGUI("Player 3")
    private val player4GUI = PlayerGUI("Player 4")

    private val boardUI = BoardGUI(squareSize, gridSize)
    private val centeredBoardUI = JPanel(FlowLayout(FlowLayout.CENTER)).apply {
        add(boardUI)
    }

    val frame = JFrame().apply {
        layout = GridBagLayout()

        add(player1GUI, GridBagConstraints().apply {
            gridx = 0
            gridy = 0
            weightx = 0.25
            weighty = 0.5
            insets = Insets(25, 25, 25, 25)
        })

        add(player2GUI, GridBagConstraints().apply {
            gridx = 3
            gridy = 0
            weightx = 0.25
            weighty = 0.5
            insets = Insets(25, 25, 25, 25)
        })

        add(centeredBoardUI, GridBagConstraints().apply {
            gridx = 1
            gridy = 0
            weightx = 0.5
            weighty = 1.0
            gridwidth = 2
            gridheight = 2
            minimumSize = boardUI.minimumSize
            insets = Insets(25, 25, 25, 25)
        })

        add(player3GUI, GridBagConstraints().apply {
            gridx = 0
            gridy = 1
            weightx = 0.25
            weighty = 0.5
            insets = Insets(25, 25, 25, 25)
        })

        add(player4GUI, GridBagConstraints().apply {
            gridx = 3
            gridy = 1
            weightx = 0.25
            weighty = 0.5
            insets = Insets(25, 25, 25, 25)
        })

        extendedState = Frame.MAXIMIZED_BOTH
        title = "Viral Game"

        defaultCloseOperation = 3
        pack()
        isLocationByPlatform = true
        isVisible = true
    }

    fun changeSquare(x: Int, y: Int, color: Color) {
        boardUI.changeSquare(x, y, color)
    }

    operator fun get(player: Player) = when(player) {
        Player.PLAYER1 -> player1GUI
        Player.PLAYER2 -> player2GUI
        Player.PLAYER3 -> player3GUI
        Player.PLAYER4 -> player4GUI
    }
}
