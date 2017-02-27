package com.courses.tasks.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by VSulevskiy on 19.07.2015.
 */
public class Game {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameRunnable());
    }

    private static class GameRunnable implements Runnable {
        @Override
        public void run() {
            GameLogic gameLogic = new GameLogic();

            JFrame frame = new JFrame("Tic tac toe");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 3, 2, 2));
            frame.setResizable(false);
            JButton[] buttons = new JButton[9];
            for (int i = 0; i < 9; i++) {
                JButton button = new JButton();
                buttons[i]=button;
                button.setPreferredSize(new Dimension(100, 100));
                button.setBackground(Color.DARK_GRAY);
                ActionListener listener = new ButtonActionListener(buttons, i, gameLogic);
                button.addActionListener(listener);
                frame.add(button);
            }
            frame.pack();
            frame.setVisible(true);

        }
    }

    private static class ButtonActionListener implements ActionListener {
        private JButton[] buttons;
        private int buttonNum;
        private GameLogic gameLogic;

        public ButtonActionListener(JButton[] buttons, int buttonNum, GameLogic gameLogic) {
            this.buttons = buttons;
            this.buttonNum = buttonNum;
            this.gameLogic = gameLogic;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            boolean turnResultPositive = gameLogic.makeTurn(buttonNum);
            if (turnResultPositive) {
                buttons[buttonNum].setForeground(Color.RED);
                buttons[buttonNum].setFont(new Font("SansSerif", Font.BOLD, 50));
                buttons[buttonNum].setText("X");
            }else{
                return;
            }
            boolean playerWin = gameLogic.checkPlayerWin();
            if(playerWin){
                JOptionPane.showMessageDialog(null, "You win");
                System.exit(0);
            }

            int aiPos = gameLogic.aIMakeTurn();
            boolean aiWin = gameLogic.checkAiWin();
            buttons[aiPos].setForeground(Color.WHITE);
            buttons[aiPos].setFont(new Font("SansSerif", Font.BOLD, 50));
            buttons[aiPos].setText("O");

            if(aiWin){
                JOptionPane.showMessageDialog(null, "AI win");
                System.exit(0);
            }

        }
    }
}
