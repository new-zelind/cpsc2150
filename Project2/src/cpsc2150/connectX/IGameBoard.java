package cpsc2150.connectX;

/**
 * Created by zelindl on 2/25/20.
 *
 * @defines MAXROWS:  Z - the maximum number of rows in the game board
 *          MAXCOLS:  Z - the maximum number of columns in the game board
 *          NUMTOWIN: Z - the number of tokens in a row required to win
 *
 * @initialization  ensures the game board is full of blank characters and is size MAXROWS x MAXCOLS.
 *
 * @constraints MAXROWS > 0 && MAXCOLS >0
 *              0 < NUMTOWIN <= (MAXROWS || MAXCOLS)
 *
 */
public interface IGameBoard {

    public static final int MAXROWS = 6;
    public static final int MAXCOLS = 7;
    public static final int NUMTOWIN = 4;

    /**
     * @pre     the game board has been created
     * @return  an integer representing the number of rows in the game board.
     */
    public int getNumRows();

    /**
     * @pre     the game board has been created
     * @return  an integer representing the number of columns in the game board.
     */
    public int getNumColumns();

    /**
     *
     * @return  an integer representing the number of columns in the game board.
     * @post    numToWin <= numRows && numToWin <= numColumns
     */
    public int getNumToWin();

    /**
     * @pre     A player wants to place a token.
     * @param c The column the player wants to place a token in.
     * @post    The function will tell us if the column can be played in or not.
     * @return  true if the column has one or more empty spaces.
     *          false if the column is full of tokens.
     */
    public Boolean checkIfFree(int c);

    /**
     * @pre     The player has already placed their token for the turn.
     * @param c The column the player placed their token in.
     * @post    The player has either won, or not.
     * @return  true if the player has won horizontally, diagonally, or vertically
     *          false if the player has not won.
     */
    public Boolean checkForWin(int c);

    /**
     * @pre     The player has selected the column they want to place their token in.
     * @param p The token to be placed
     * @param c The column that the player chose
     * @post
     */
    public void placeToken(char p, int c);

    /**
     * @pre     The player has placed their token for the turn.
     * @param pos The board position that the token went into.
     * @param p   The token that was placed.
     * @post    There will either be a winner, or it will move to the next turn.
     * @return  true if the player won horizontally
     *          false if there is no winner.
     */
    public Boolean checkHorizWin(BoardPosition pos, char p);

    /**
     * @pre     The player has placed their token for the turn.
     * @param pos The board position that the token went into.
     * @param p   The token that was placed.
     * @post    There will either be a winner, or it will move to the next turn.
     * @return  true if the player won vertically
     *          false if there is no winner.
     */
    public Boolean checkVertWin(BoardPosition pos, char p);

    /**
     * @pre     The player has placed their token for the turn.
     * @param pos The board position that the token went into.
     * @param p   The token that was placed.
     * @post    There will either be a winner, or it will move to the next turn.
     * @return  true if the player won diagonally
     *          false if there is no winner.
     */
    public Boolean checkDiagWin(BoardPosition pos, char p);

    /**
     * @pre     The board position to be checked exists.
     * @param pos The gameboard position to be checked.
     * @return  "X" if an X is in the position.
     *          "O" if an O is in the position.
     *          " " if nothing is there.
     */
    public char whatsAtPos(BoardPosition pos);

    /**
     * @pre     The board position to be checked exists.
     * @param pos    The position to be checked.
     * @param player The player to be checked.
     * @return  true if the player has a piece at the specified position
     *          false if the player doesn't have a piece at the specified position
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player);

    /**
     * @pre     No winner has been declared yet.
     * @post    If there's a tie, the game is over.
     * @return  true if the game board is full of tokens with no winner
     *          false if there is an empty space in the game board.
     */
    public boolean checkTie();

}
