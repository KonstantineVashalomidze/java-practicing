package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TypingPracticeGame extends JFrame {

    private JPanel gamePanel;
    private JLabel wordLabel;
    private JTextField inputField;
    private JButton startButton;
    private Timer timer;
    private int score = 0;
    private List<String> words = new ArrayList<>();
    private Random random = new Random();

    public TypingPracticeGame() {
        super("Typing Practice Game");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        gamePanel = new JPanel();
        gamePanel.setLayout(new FlowLayout());

        wordLabel = new JLabel();
        wordLabel.setFont(new Font("Arial", Font.BOLD, 20));

        inputField = new JTextField(20);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkWord();
            }
        });

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Add components to panel
        gamePanel.add(wordLabel);
        gamePanel.add(inputField);
        gamePanel.add(startButton);

        // Add panel to frame
        add(gamePanel);

        // Prepare words list
        words.add("apple");
        words.add("banana");
        words.add("computer");
        words.add("programming");
        words.add("java");
        // ... add more words

        setVisible(true);
    }

    private void startGame() {
        score = 0;
        displayNewWord();
        startTimer();
        inputField.requestFocus();
    }

    private void displayNewWord() {
        wordLabel.setText(words.get(random.nextInt(words.size())));
        inputField.setText("");
    }

    private void checkWord() {
        String typedWord = inputField.getText();
        if (typedWord.equals(wordLabel.getText())) {
            score++;
            displayNewWord();
        }
        inputField.setText("");
    }

    private void startTimer() {
        if (timer == null) {
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Game over logic
                    timer.stop();
                    JOptionPane.showMessageDialog(TypingPracticeGame.this, "Game Over! Your score: " + score);
                }
            });
        }
        timer.start();
    }

    public static void main(String[] args) {
        new TypingPracticeGame();
    }
}