package cpsc2150.connectX;

/**
 * Created by zelindl on 2/6/20.
 * 
 * @invariant 0 < rows
 * @invariant 0 < cols
 * @invariant 0 < numToWin
 *
 * Correspondence rows = MAXROWS
 * Correspondence cols - MAXCOLS
 * Correspondence numToWin = NUMTOWIN
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
    private boolean isWinner;
    private boolean isTie;

    /**
     * @pre     A new game has started.
     * @post    A new game board is created.
     */
    public GameBoard(int _rows, int _cols, int _numToWin){
        rows = _rows;
        cols = _cols;
        numToWin = _numToWin;
        isTie = isWinner = false;
        board = new char[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                board[i][j] = ' ';
            }
        }
    }

    public void setRows(int rowsInput){
        rows = rowsInput;
        NUMROWS = rowsInput;
    }

    public void setCols(int colsInput){
        cols = colsInput;
        NUMCOLS = colsInput;
    }

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

        //is the column full?
        if(checkIfFree(c)){

            //if not, move up to the first open slot and place the token.
            int i = 0;
            while(board[i][c] != ' '){
                i++;
            }
            board[i][c] = p;
        }
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
        isTie = true;
        return true;
    }
}
