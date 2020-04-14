package viral_game.gui

import viral_game.data.Paradigm
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.BoxLayout
import javax.swing.JLabel
import javax.swing.JPanel

class PlayerGUI(playerName: String) : JPanel() {
    var playerName = playerName
        set(value) {
            field = value
            playerLabel.text = value
        }

    private val playerLabel = JLabel(playerName, 0).apply {
        font = font.deriveFont(Font.BOLD)
    }

    private val paradigms = arrayOf(
        Paradigm.FUNCTIONAL,
        Paradigm.OO,
        Paradigm.DECLARATIVE
    ).map {
        ParadigmGUI(it) { newParadigm ->
            chosenParadigm = newParadigm
        }
    }

    private var chosenParadigm: Paradigm? = null

    init {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)

        add(JPanel(FlowLayout(FlowLayout.CENTER)).apply {
            add(playerLabel)
        })

        for(paradigm in paradigms)
            add(paradigm)

        setInteractable(false)
    }

    operator fun get(paradigm: Paradigm) = paradigms.first { it.paradigm == paradigm }

    fun askInput(): Paradigm {
        chosenParadigm = null
        setInteractable(true)
        while (chosenParadigm == null)
            Thread.sleep(10)
        setInteractable(false)
        return chosenParadigm as Paradigm
    }

    private fun setInteractable(isInteractable: Boolean) {
        for(paradigm in paradigms)
            paradigm.interactable = isInteractable
    }
}