import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CPU extends BasePlayer{
    public CPU(Board board){
        super(board, "cpu");
    }
    @Override
    public void makeStep() {
        Random rand = new Random();
        int cpuPos;
        if (attackingPositions() != 0) {
            cpuPos = attackingPositions();
        }else if(winnersPosition() != 0){
            cpuPos = winnersPosition();
        }else {
            cpuPos = rand.nextInt(9) + 1;
        }
        while (!board.placePiece(cpuPos, name)) {
            cpuPos = rand.nextInt(9) + 1;
        }

        board.arrayPlayer2.add(cpuPos);
    }
    public int attackingPositions() {
        ArrayList<Integer> supportingAttackingPosition = new ArrayList<Integer>();;
        for(int l : board.arrayPlayer2) {
            supportingAttackingPosition.add(l);
        }

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

        for(List l : winning) {
            for(int i = 1; i<=9; i++) {
                supportingAttackingPosition.add(i);
                if (supportingAttackingPosition.containsAll(l)) {
                    supportingAttackingPosition.remove((Object)i);
                    return i;
                }
                else
                    supportingAttackingPosition.remove((Object)i);
            }
        }
        return 0;
    }
    public int winnersPosition() {

        ArrayList<Integer> supportingPosition = new ArrayList<Integer>();;
        for(int l : board.arrayPlayer1) {
            supportingPosition.add(l);
        }

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

        for(List l : winning) {
            for(int i = 1; i<=9; i++) {
                supportingPosition.add(i);
                if (supportingPosition.containsAll(l)) {
                    supportingPosition.remove((Object)i);
                    return i;
                }
                else
                    supportingPosition.remove((Object)i);
            }
        }
        return 0;
    }

}
