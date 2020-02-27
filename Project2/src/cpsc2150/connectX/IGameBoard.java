package cpsc2150.connectX;

/**
 * Created by zelindl on 2/25/20.
 *
 *
 */
public interface IGameBoard {

    public static final int MAXROWS = 7;
    public static final int MAXCOLS = 7;
    public static final int NUMTOWIN = 4;

    public int getNumRows();

    public int getNumColumns();

    public int getNumToWin();

    public Boolean checkIfFree(int c);

    public Boolean checkForWin(int c);

    public void placeToken(char p, int c);

    public Boolean checkHorizWin(BoardPosition pos, char p);

    public Boolean checkVertWin(BoardPosition pos, char p);

    public Boolean checkDiagWin(BoardPosition pos, char p);

    public char whatsAtPos(BoardPosition pos);

    public boolean isPlayerAtPos(BoardPosition pos, char player);

    @Override
    public String toString();

    public boolean checkTie();

}
