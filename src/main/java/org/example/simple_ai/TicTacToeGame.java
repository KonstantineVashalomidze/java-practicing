package org.example.simple_ai;

import java.util.Arrays;

public class TicTacToeGame
{
    boolean gameOver = false; // indicates if game is over or not
    char[][] playGround = new char[3][3]; // indicates playGround

    {
        // initialise play ground
        for (char[] a : playGround)
        {
            Arrays.fill(a, ' ');
        }
    }

    PlayerTurn state = new PlayerX(this);

    char winner = ' ';

    boolean isDraw = false;

    public TicTacToeGame()
    {


        while (!gameOver && winner == ' ' && !isDraw)
        {
            // make move
            state.makeMove();
            // print play ground
            printPlayGround();
            // check winner
            winner = checkWinner();
            // check if its draw
            isDraw = isDraw();
        }
        if (!isDraw)
        {
            System.out.println("Winner is: " + winner);
        }
        else
        {
            System.out.println("Draw");
        }

    }

    private void printPlayGround()
    {
        for (char[] row : playGround)
        {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean isOccupied(int x, int y)
    {
        return playGround[y][x] != ' ';
    }

    private boolean isDraw()
    {
        for (char[] row : playGround)
        {
            for (char ch : row)
            {
                if (ch == ' ')
                    return false;
            }
        }
        return true;
    }

    private char checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (playGround[i][0] == playGround[i][1] && playGround[i][1] == playGround[i][2] && playGround[i][0] != '0') {
                return playGround[i][0];
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (playGround[0][i] == playGround[1][i] && playGround[1][i] == playGround[2][i] && playGround[0][i] != '0') {
                return playGround[0][i];
            }
        }

        // Check diagonals
        if (playGround[0][0] == playGround[1][1] && playGround[1][1] == playGround[2][2] && playGround[0][0] != '0') {
            return playGround[0][0];
        }
        if (playGround[0][2] == playGround[1][1] && playGround[1][1] == playGround[2][0] && playGround[0][2] != '0') {
            return playGround[0][2];
        }

        return ' '; // No winner yet
    }

}





