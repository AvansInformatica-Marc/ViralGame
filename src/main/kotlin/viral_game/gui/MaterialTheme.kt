package viral_game.gui

import mdlaf.MaterialLookAndFeel
import mdlaf.themes.MaterialLiteTheme
import javax.swing.JDialog
import javax.swing.UIManager
import javax.swing.UnsupportedLookAndFeelException

object MaterialTheme {
    fun enableMaterialTheme() {
        try {
            JDialog.setDefaultLookAndFeelDecorated(true)
            UIManager.setLookAndFeel(MaterialLookAndFeel(MaterialLiteTheme()))
        } catch (e: UnsupportedLookAndFeelException) {
            e.printStackTrace()
        }
    }
}