package org.example.simple_ai;

public class PlayerO
    implements PlayerTurn
{

    TicTacToeGame ticTacToeGame;
    public PlayerO(TicTacToeGame ticTacToeGame)
    {
        this.ticTacToeGame = ticTacToeGame;
    }

    @Override
    public void makeMove()
    {
        System.out.println("O's turn");
        var x = scanner.nextInt();
        var y = scanner.nextInt();
        while (ticTacToeGame.isOccupied(x - 1, y - 1))
        {
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        ticTacToeGame.playGround[y - 1][x - 1] = 'O';
        ticTacToeGame.state = new PlayerX(ticTacToeGame);
    }


}
