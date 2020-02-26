package cpsc2150.connectX;

/**
 * Created by zelindl on 2/25/20.
 *
 *
 */
public interface IGameBoard {

    public abstract int getNumRows();

    public abstract int getNumColumns();

    public abstract int getNumToWin();

    public abstract Boolean checkIfFree(int c);

    public abstract Boolean checkForWin(int c);

    public abstract void placeToken(char p, int c);

    public abstract Boolean checkHorizWin(BoardPosition pos, char p);

    public abstract Boolean checkVertWin(BoardPosition pos, char p);

    public abstract Boolean checkDiagWin(BoardPosition pos, char p);

    public abstract char whatsAtPos(BoardPosition pos);

    public abstract boolean isPlayerAtPos(BoardPosition pos, char player);

    @Override
    public abstract String toString();

    public abstract boolean checkTie();

}
