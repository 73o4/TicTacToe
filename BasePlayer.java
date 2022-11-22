import java.util.ArrayList;

public abstract class BasePlayer {
    protected Board board;
    protected String name;

    public BasePlayer(Board board, String name) {
        this.board = board;
        this.name = name;
    }

    public abstract void makeStep();
}
