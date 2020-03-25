package cpsc2150.connectX;

/**
 * Created by zelindl on 2/6/20.
 *
 * @invariant   A piece cannot be placed in a full stack
 * @invariant   Each placed piece stacks on top of the one below it
 * @invariant   There can be no spaces between vertical tokens
 * @invariant   The board is of size rows x cols
 * @invariant   The bottom left of the gameboard is (0, 0)
 * @invariant   A piece cannot be placed out of bounds
 *
 * Correspondence MINROWS <= rows <= MAXROWS
 * Correspondence MINCOLS <= cols <= MAXCOLS
 * Correspondence MINNUMTOWIN <= numToWin <= MAXNUMTOWIN
 * Correspondence this = board[0...MAXROWS-1][0...MAXCOLS]
 */
public class GameBoard extends AbsGameBoard {

    /**
     * @invariant   No tokens can be placed outside of the game board.
     * @invariant   No tokens can be placed in a column that is already full.
     */

    private int rows;
    private int cols;
    private int numToWin;
    private char[][] board;

    /**
     * @param _rows     the number of rows in the board
     * @param _cols     the number of columns in the board
     * @param _numToWin the number of tokens in a row required to win
     * @pre     MINROWS <= rows <= MAXROWS && MINCOLS <= cols MAXCOLS && MINNUMTOWIN <= numToWin <= MAXNUMTOWIN
     * @post    a new board represented by a 2d array of blank characters is created
     */
    public GameBoard(int _rows, int _cols, int _numToWin){
        rows = _rows;
        cols = _cols;
        numToWin = _numToWin;
        board = new char[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void setRows(int rowsInput){ rows = rowsInput; }

    public void setCols(int colsInput){ cols = colsInput; }

    public void setNumToWin(int numToWinInput){ numToWin = numToWinInput; }

    public int getNumRows(){ return rows; }

    public int getNumColumns(){ return cols; }

    public int getNumToWin(){ return numToWin; }

    public int getMaxRows(){ return MAXROWS; }

    public int getMaxCols(){ return MAXCOLS; }

    public int getMaxNumToWin(){ return MAXNUMTOWIN; }

    public int getMinRows(){ return MINROWS; }

    public int getMinCols(){ return MINCOLS; }

    public int getMinNumToWin(){ return MINNUMTOWIN; }

    public void placeToken(char p, int c){
        //if not, move up to the first open slot and place the token.
        int i = 0;
        while(board[i][c] != ' '){
            i++;
        }
        board[i][c] = p;
    }

    public char whatsAtPos(BoardPosition pos){
        //Return the character at position pos
        return board[pos.getRow()][pos.getColumn()];
    }

    public boolean checkTie(){

        //check and see if the board has an empty space
        BoardPosition currPos;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                currPos = new BoardPosition(i, j);
                if(whatsAtPos(currPos) == ' '){
                    //if we find a space, then there's not a tie.
                    return false;
                }
            }
        }

        //otherwise, the game is a draw.
        return true;
    }
}
