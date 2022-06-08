package minesweeper.view

import minesweeper.*
import minesweeper.CellData.*
import java.awt.*
import javax.swing.*


private const val GAP = 10
private const val rows = 9
private const val cols = 9
private const val mines = 4

class MineSweeperUI : JFrame("Mine sweeper"), ModelChangeListener {
    private var gameModel: Model = Model(rows, cols, mines)
    private val statusLabel = JLabel("Status", JLabel.CENTER)
    private val buttons = mutableListOf<MutableList<JButton>>()

    // val iconRestart:Icon= ImageIcon("C:\\Users\\dsgor\\IdeaProjects\\OOP\\src\\main\\resources\\images\\smail.png")
    val mine: Image =
        ImageIcon("src\\main\\resources\\images\\mine.png").image.getScaledInstance(60, 60, Image.SCALE_SMOOTH)

    //val restart: Icon = ImageIcon("src\\main\\resources\\images\\smile.png")
    val imageRestart: Image =
        ImageIcon("src\\main\\resources\\images\\smile.png").image.getScaledInstance(30, 30, Image.SCALE_SMOOTH)
    val imageFlag: Image =
        ImageIcon("src\\main\\resources\\images\\flag.png").image.getScaledInstance(30, 30, Image.SCALE_SMOOTH)
    val imageMine: Image =
        ImageIcon("src\\main\\resources\\images\\mine.png").image.getScaledInstance(30, 30, Image.SCALE_SMOOTH)
    val iconMine: Icon = ImageIcon("src\\main\\resources\\images\\mine.png")
    val imageBlank:Image=
        ImageIcon("src\\main\\resources\\images\\blank.png").image.getScaledInstance(30,30,Image.SCALE_SMOOTH)
    val imageExMine:Image=
        ImageIcon("src\\main\\resources\\images\\explodemine.png").image.getScaledInstance(30,30,Image.SCALE_SMOOTH)

    private fun createTopPanel(): JPanel {
        val topPanel = JPanel()
        topPanel.preferredSize = Dimension(600, 80)
        topPanel.layout = FlowLayout(FlowLayout.CENTER)
        return topPanel
    }

    init {

        setSize(500, 500)
        defaultCloseOperation = EXIT_ON_CLOSE
        updateFont(statusLabel, 20.0f)

        rootPane.contentPane = JPanel(BorderLayout(GAP, GAP)).apply {
            add(statusLabel, BorderLayout.SOUTH)
            add(createBoardPanel(), BorderLayout.CENTER)
            val restart = createRestartButton()
            val topPanel = createTopPanel()

            topPanel.add(createSwitchButton())
            topPanel.add(restart)
            topPanel.add(minesIndicator())
            //add(restart.add(JLabel(ImageIcon(textures.b))), BorderLayout.SOUTH)
            add(topPanel, BorderLayout.NORTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }

        resubscribe()
    }

    private fun createSwitchButton(): JButton {
        val switchButton = JButton().apply {
            icon = when (gameModel.clickMode) {
                ClickMode.OPENING -> ImageIcon(imageMine)
                ClickMode.FLAGGED -> ImageIcon(imageFlag)
            }
            addActionListener {
                gameModel.switchMode()
                icon = when (gameModel.clickMode) {
                    ClickMode.OPENING -> ImageIcon(imageMine)
                    ClickMode.FLAGGED -> ImageIcon(imageFlag)
                }
            }
            background = Color.LIGHT_GRAY
            preferredSize = Dimension(30, 30)
            minimumSize = Dimension(30, 30)
            maximumSize = Dimension(30, 30)
        }
        return switchButton
    }

    private fun createRestartButton(): Component {
        val restartButton = JButton().apply {
            icon = ImageIcon(imageRestart)
            //updateFont(restartButton, 40.0f)
            addActionListener {
                if (gameModel.state !in GameFinished) {
                    val dialogOption = JOptionPane.showConfirmDialog(
                        this,
                        "Game not finished",
                        "restart",
                        JOptionPane.OK_CANCEL_OPTION
                    )
                    if (dialogOption == JOptionPane.OK_OPTION) {
                        resubscribe()
                    }
                } else {
                    resubscribe()
                }
            }
            preferredSize = Dimension(30, 30)
            minimumSize = Dimension(30, 30)
            maximumSize = Dimension(30, 30)
        }
        return restartButton
    }

    private fun minesIndicator(): JLabel {
        val minesInd = JLabel().apply {
            updateFont(this, 20F)
            text = mines.toString()
            isOpaque = true
            foreground = Color.BLACK
            background = Color.LIGHT_GRAY
            preferredSize = Dimension(30, 30)
            minimumSize = Dimension(30, 30)
            maximumSize = Dimension(30, 30)
        }
        return minesInd
    }

    /* private fun createRestartButton():JButton
     {
         val restartButton=JButton().apply {
             icon=ImageIcon(restart.getScaledInstance(60,60,Image.SCALE_SMOOTH))
             background = Color.LIGHT_GRAY
         addActionListener {
             if(gameModel.movesLeft!=gameModel.size)
             {val dialog=JOptionPane.showConfirmDialog(this,"game not finished yet","restart",JOptionPane.OK_CANCEL_OPTION)
             if(dialog==JOptionPane.OK_OPTION){resubscribe()
             }
         }else {resubscribe()}
         }
     }
         updateFont(restartButton, 20.0f)
         return  restartButton
     }*/


    private fun resubscribe() {
        gameModel.removeModelChangeListener(this)
        gameModel = Model(rows, cols, mines)
        gameModel.addModelChangeListener(this)
        updateGameUI()
    }

    override fun onModelChanged() {
        updateGameUI()
    }

    private fun updateGameUi() {
        val state = gameModel.state
        statusLabel.text = state.textValue
        for ((i, buttonRow) in buttons.withIndex()) {
            for ((j, button) in buttonRow.withIndex()) {
                val cell = gameModel.board[i][j]
                //button.text = (gameModel.board[i][j] as OpenedCell).number.toString()
                button.isEnabled = cell.cell == CLOSEDC && state !in GameFinished

                button.foreground = when (cell.cell) {
                    MINE -> Color.RED
                    OPENEDC -> Color.WHITE
                    CLOSEDC -> Color.BLACK
                    FLAG -> Color.BLUE
                }
            }
        }
    }

    private fun updateGameUI() {
        val state = gameModel.state
        statusLabel.text = state.textValue
        for ((i, buttonRow) in buttons.withIndex()) {
            for ((j, button) in buttonRow.withIndex()) {
                val cell = gameModel.board[i][j]
                button.isEnabled = cell.cell == CLOSEDC && state !in GameFinished

                when (cell.cell) {
                    MINE -> {
                        button.apply { imageMine }
                    }
                    OPENEDC -> {
                        val open: OpenedCell = cell as OpenedCell
                        if (open.number == 0) {
                              imageBlank
                        } else {
                            button.apply {
                            text=open.number.toString()
                            }
                        }
                    }
                    CLOSEDC -> {}
                    FLAG -> {button.apply { imageFlag }}
                }

            }
        }
    }

    private fun createBoardPanel(): Component {
        val gamePanel = JPanel(GridLayout(rows, cols, GAP, GAP))
        for (i in 0 until rows) {
            val buttonsRow = mutableListOf<JButton>()
            for (j in 0 until cols) {
                val cellButton = JButton("")
//  val cellButton = JButton(gameModel.board[i][j].cell.toString())
                cellButton.addActionListener {
                    gameModel.doMove(
                        j,
                        i
                    )////////////////////////////////////////////////////////ход происходит, но не ихменяется визуалка
                    println("\nmove done on $i $j ")
                    gameModel.printBoard()
                    println()
                    gameModel.printDataBoard()
                }
                updateGameUI()
                buttonsRow.add(cellButton)
                gamePanel.add(cellButton)
                updateFont(cellButton, 30.0f)
            }
            buttons.add(buttonsRow)
        }
        resubscribe()
        return gamePanel
    }


    private fun updateFont(component: JComponent, newFrontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFrontSize)
        component.font = derivedFont
    }

}