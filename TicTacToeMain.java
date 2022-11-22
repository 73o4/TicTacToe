import java.util.*;

public class TicTacToeMain {
    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

    public static void main(String[] args) {

        int counter = 1;
        while (counter == 1) {
            Board board = new Board();
            BasePlayer player1, player2;

            player1 = new RealPlayer1(board);
            String opponent = chooseOpposite();
            if (opponent.equals("cpu")) {
                player2 = new CPU(board);
            } else {
                player2 = new RealPlayer2(board);
            }

            while (board.checkWinner().length() < 2) {
                board.printGameBoard();
                player1.makeStep();
                if (board.checkWinner().length() > 2) {
                    break;
                }
                if (opponent.equals("player2")){
                    board.printGameBoard();
                }
                player2.makeStep();
            }
            board.printGameBoard();
            System.out.println(board.checkWinner());
            counter = newPlay();
        }
    }

    public static String chooseOpposite() {
        System.out.println("If you want play with CPU, enter 1. If you want play with friend, enter 2.");
        Scanner scan = new Scanner(System.in);
        int opponent = scan.nextInt();
        if (opponent == 1) {
            return "cpu";
        } else return "player2";
    }
    public static int newPlay() {
        System.out.println("If you want play new game enter 1. Else enter any button.");
        Scanner scan = new Scanner(System.in);
        //int opponent = scan.nextInt();
        if (scan.nextLine() == "1") {
            return 1;
        } else return 0;
    }
}
