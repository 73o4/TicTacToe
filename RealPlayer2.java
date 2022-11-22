import java.util.Scanner;

public class RealPlayer2 extends BasePlayer{

    public RealPlayer2 (Board board){
        super(board, "player2");
    }

    @Override
    public void makeStep() {
        Scanner scan;
        scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        String playerPosString = scan.nextLine();

        while (!board.correctPosition(playerPosString)) {
            System.out.println("Enter a correct position!");
            playerPosString = scan.nextLine();
        }
        int playerPos = board.convertToInt(playerPosString);

        while (!board.placePiece(playerPos, name)) {
            System.out.println("Enter a correct position!");
            playerPosString = scan.nextLine();
            while (!board.correctPosition(playerPosString)) {
                System.out.println("Enter a correct position!");
                playerPosString = scan.nextLine();
            }
            playerPos = board.convertToInt(playerPosString);
        }

        board.arrayPlayer2.add(playerPos);
    }
}
