import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    public  ArrayList<Integer> arrayPlayer1;
    public  ArrayList<Integer> arrayPlayer2;

    public Board() {
        this.arrayPlayer1 = new ArrayList<>();
        this.arrayPlayer2 = new ArrayList<>();
    }

    public void printGameBoard() {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private boolean checkBusyState(int pos){
        return  (!arrayPlayer1.contains(pos) && !arrayPlayer2.contains(pos));
    }

    public boolean placePiece(int pos, String user) {

        if(!checkBusyState(pos))
            return false;

        char symbol = ' ';

        if (user.equals("player1")) {
            symbol = 'X';
        }
        else if (user.equals("player2") || user.equals("cpu")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                return false;
        }

        return true;
    }

    public String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List downRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(downRow);
        winning.add(leftCol);
        winning.add(middleCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l :
                winning) {
            if (arrayPlayer1.containsAll(l)) {
                return "Player_1 won!";
            } else if (arrayPlayer2.containsAll(l)) {
                return "Player_2 won";
            } else if (arrayPlayer1.size() + arrayPlayer2.size() == 9) {
                return "CAT!";
            }
        }

        return "";
    }

    public boolean correctPosition(String playerPosString) {
        switch (playerPosString) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9":
                return true;
            default: return false;
        }
    }

    public int convertToInt(String playerPosString) {
        switch (playerPosString) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
        }
        return 0;
    }
}
