package minesweeper.view

import minesweeper.CellData.*
import minesweeper.GameFinished
import minesweeper.Model
import minesweeper.ModelChangeListener
import java.awt.*
import javax.swing.*

private const val GAP = 10

class MineSweeperUI : JFrame("Mine sweeper"), ModelChangeListener {
    private var gameModel: Model = Model(9, 9, 10)
    private val statusLabel = JLabel("Status", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()
   // val iconRestart:Icon= ImageIcon("C:\\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\resources\\images\\smail.png")
    val mine: Image =ImageIcon("src\\main\\resources\\images\\mine.png").image
    val restart: Image =ImageIcon("src\\main\\resources\\images\\smile.png").image
    init {

        setSize(500, 500)
        defaultCloseOperation = EXIT_ON_CLOSE
        updateFont(statusLabel, 20.0f)
        rootPane.contentPane = JPanel(BorderLayout(GAP, GAP)).apply {
//        N.W   N   N.E
//          \   |   /
//           \  |  /
//        W----Cell----E
//            / | \
//          /   |  \
//        S.W    S   S.E

            add(statusLabel, BorderLayout.NORTH)
            add(createBoardPanel(), BorderLayout.CENTER)
            val restart = createRestartButton()
            //add(restart.add(JLabel(ImageIcon(textures.b))), BorderLayout.SOUTH)
            add(restart, BorderLayout.SOUTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }

        gameModel.addModelChangeListener(this)
        updateGameUI()
        resubscribe()
    }

/*    private fun createRestartButton(): Component {
        val restartButton = JButton("Restart"*//*iconRestart*//*)
        updateFont(restartButton, 20.0f)
        restartButton.addActionListener {
            if (gameModel.state in GameFinished) {
                val dialogOption = JOptionPane.showConfirmDialog(
                    this, "Game not finished", "restart", JOptionPane.OK_CANCEL_OPTION
                )
                if (dialogOption == JOptionPane.OK_OPTION) {
                    resubscribe()
                }
            } else {
                resubscribe()
            }
        }
        return restartButton
    }*/

    private fun createRestartButton():JButton
    {
        val restartButton=JButton().apply {
            icon=ImageIcon(restart.getScaledInstance(60,60,Image.SCALE_SMOOTH))
            background = Color.LIGHT_GRAY
        addActionListener {
            if(gameModel.movesLeft!=gameModel.size)
            {val dialog=JOptionPane.showConfirmDialog(this,"game not finished yet","restart",JOptionPane.OK_OPTION)
            if(dialog==JOptionPane.OK_OPTION){resubscribe()
            }
        }else {resubscribe()}
        }
    }
        updateFont(restartButton, 20.0f)
        return  restartButton
    }


    private fun resubscribe() {
        gameModel.removeModelChangeListener(this)
        gameModel = Model(9, 9, 10)
        gameModel.addModelChangeListener(this)
        updateGameUI()
    }

    override fun onModelChanged() {
        updateGameUI()
    }

    private fun updateGameUI() {
        val state = gameModel.state
        statusLabel.text = state.textValue
        for ((i, buttonRow) in buttons.withIndex()) {
            for ((j, button) in buttonRow.withIndex()) {
                val cell = gameModel.dataBoard[i][j]
                button.text = cell.toString()
                button.isEnabled = cell.cell == CLOSEDC && state in GameFinished
                button.foreground = when (cell.cell) {
                    MINE -> Color.RED
                    OPENEDC -> Color.WHITE
                    CLOSEDC -> Color.BLACK
                    FLAG -> Color.BLUE
                }

            }
        }
    }

    private fun createBoardPanel(): Component {
        val gamePanel = JPanel(GridLayout(9, 9, GAP, GAP))
        for (i in 0 until 9) {
            val buttonsRow = mutableListOf<JButton>()
            for (j in 0 until 9) {
                val cellButton = JButton("")
                cellButton.addActionListener { gameModel.doMove(j, i) }
                buttonsRow.add(cellButton)
                gamePanel.add(cellButton)
                updateFont(cellButton, 30.0f)
            }
            buttons.add(buttonsRow)
        }
        return gamePanel
    }


    private fun updateFont(component: JComponent, newFrontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFrontSize)
        component.font = derivedFont
    }

}