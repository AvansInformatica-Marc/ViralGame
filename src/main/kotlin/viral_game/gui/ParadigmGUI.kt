package viral_game.gui

import viral_game.data.Paradigm
import java.awt.GridLayout
import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

class ParadigmGUI(val paradigm: Paradigm, probability: Double = 0.0, var onVideoChanged: ((Paradigm) -> Unit)? = null) : JPanel() {
    var probability = probability
        set(value) {
            field = value
            label.text = "${paradigm.code}: $value"
        }

    var interactable: Boolean
        get() = button.isEnabled
        set(value) {
            button.isEnabled = value
        }

    private val label = JLabel("${paradigm.code}: $probability", 0)

    private val button = JButton("Create video").apply {
        addActionListener {
            onVideoChanged?.invoke(paradigm)
        }
    }

    init {
        layout = GridLayout(1, 2)
        border = BorderFactory.createEmptyBorder(4, 4, 4, 4)

        add(label)
        add(button)
    }
}