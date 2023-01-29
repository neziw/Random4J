package xyz.neziw.random4j

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.GridLayout
import java.util.*
import javax.swing.*

class Random4J : JFrame() {

    private val display = JTextField()
    private val generateButton = JButton("Generate Random Number")

    init {
        title = "Random Number Generator"
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 150)
        setLocationRelativeTo(null)
        isResizable = false
        layout = BorderLayout()

        val inputPanel = JPanel()
        inputPanel.layout = GridLayout(2, 2, 5, 5)
        inputPanel.add(JLabel("Minimum number:"))
        val fromField = JTextField()
        inputPanel.add(fromField)
        inputPanel.add(JLabel("Maximum number:"))
        val toField = JTextField()
        inputPanel.add(toField)
        add(inputPanel, BorderLayout.NORTH)

        display.isEditable = false
        display.horizontalAlignment = SwingConstants.RIGHT
        display.preferredSize = Dimension(150, 50)
        add(display, BorderLayout.CENTER)

        generateButton.addActionListener {
            val from = fromField.text.toInt()
            val to = toField.text.toInt()
            val random = Random().nextInt(to - from + 1) + from
            display.text = random.toString()
        }
        add(generateButton, BorderLayout.SOUTH)
    }
}

fun main() {
    EventQueue.invokeLater { Random4J().isVisible = true }
}