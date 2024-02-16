package org.example.simple_ai;

public class PlayerX
    implements PlayerTurn
{
    TicTacToeGame ticTacToeGame;
    public PlayerX(TicTacToeGame ticTacToeGame)
    {
        this.ticTacToeGame = ticTacToeGame;
    }

    @Override
    public void makeMove()
    {
        System.out.println("X's turn:");
        var x = scanner.nextInt();
        var y = scanner.nextInt();
        while (ticTacToeGame.isOccupied(x - 1, y - 1))
        {
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        ticTacToeGame.playGround[y - 1][x - 1] = 'X';
        ticTacToeGame.state = new PlayerO(ticTacToeGame);
    }
}
