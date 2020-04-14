package viral_game.gui

import mdlaf.utils.MaterialColors
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JPanel

class BoardGUI(private val squareSize: Int, private val gridSize: Int) : JPanel() {
    private val defaultColor: Color = MaterialColors.GRAY_900
    private val grid = Array(squareSize) { Array(squareSize) { defaultColor } }

    fun changeSquare(x: Int, y: Int, color: Color) {
        grid[x][y] = color
        revalidate()
        repaint()
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)

        if(g != null) {
            for(x in 0 until gridSize) {
                for(y in 0 until gridSize) {
                    g.color = grid[x][y]
                    g.fillRect(x * squareSize, y * squareSize, squareSize, squareSize)
                    g.color = MaterialColors.GRAY_100
                    g.drawRect(x * squareSize, y * squareSize, squareSize, squareSize)
                }
            }
        }
    }

    override fun getPreferredSize() = Dimension(gridSize * squareSize, gridSize * squareSize)

    override fun getMinimumSize() = Dimension(gridSize * squareSize, gridSize * squareSize)
}