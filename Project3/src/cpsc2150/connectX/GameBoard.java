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
public class GameBoard implements IGameBoard extends AbsGameBoard {

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
    public GameBoard(){
        rows = MINROWS;
        cols = MINCOLS;
        numToWin = MINNUMTOWIN;
        isTie = isWinner = false;
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

    public int getMaxRows(){ return MAXROWS; }

    public int getMaxCols(){ return MAXCOLS; }

    public int getMaxNumToWin(){ return MAXNUMTOWIN; }

    public int getMinRows(){ return MINROWS; }

    public int getMinNumToWin(){ return MINNUMTOWIN; }

    public int getNumRows(){ return NUMROWS; }

    public int getNumColumns(){ return NUMCOLS; }

    public int getNumToWin(){ return NUMTOWIN; }

    public Boolean checkIfFree(int c){
        //if the top space is blank, then the column isn't empty.
        if(board[rows-1][c] == ' ') return true;
        else return false;
    }

    public Boolean checkForWin(int c){
        //get row number of latest position
        int rowNum = rows-1;
        while(board[rowNum][c] == ' '){
            rowNum--;
        }

        //get character
        char token = board[rowNum][c];
        BoardPosition currPos = new BoardPosition(rowNum, c);

        //check horizontal, vertical, and diagonal wins.
        if(checkHorizWin(currPos, token)){return true;}
        if(checkVertWin(currPos, token)){return true;}
        if(checkDiagWin(currPos, token)){return true;}
        else {return false;}
    }

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

    public Boolean checkHorizWin(BoardPosition pos, char p){

        //initialize variables
        boolean traverseRight = false;
        int count = 1;
        BoardPosition currPos = pos;

        //while we haven't traversed right
        while(!traverseRight){

            //see if we can move to the right. If so, move right.
            if(currPos.getColumn()+1 < MAXCOLS){
                currPos = new BoardPosition(currPos.getRow(), (currPos.getColumn()+1));

                //if the token is the same as p, increase the consecutive count. If not, move back to the original spot.
                if(whatsAtPos(currPos) == p){
                    count ++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else traverseRight = true;
            } else traverseRight = true;
        }

        //reset the position.
        //repeat this process for moving left
        currPos = pos;
        while(traverseRight){
            if(currPos.getColumn()-1 >= 0){
                currPos = new BoardPosition(currPos.getRow(), (currPos.getColumn()-1));
                if(whatsAtPos(currPos) == p){
                    count ++;

                    //if we reached the number to win, return true
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else break;
        }

        //otherwise return false
        return false;
    }

    public Boolean checkVertWin(BoardPosition pos, char p){

        //repeat the process for checkHorizWin for checkVertWin, except we only move down.
        int count = 1;
        BoardPosition currPos = pos;

        while(count < numToWin){
            if(currPos.getRow()-1 >= 0){
                currPos = new BoardPosition((currPos.getRow()-1), currPos.getColumn());
                if(whatsAtPos(currPos) == p){
                    count++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else break;
        }

        return false;

    }

    public Boolean checkDiagWin(BoardPosition pos, char p){

        //initialize
        int count = 1;
        BoardPosition currPos = pos;

        //Repeat the process in checkHorizWin for checkDiagWin, except for moving Southeast/Northwest, and southwest/northeast.
        //move southeast
        while(count < numToWin){
            if(currPos.getRow()-1 >= 0 && currPos.getColumn()+1 < cols){
                currPos = new BoardPosition((currPos.getRow()-1), (currPos.getColumn()+1));
                if(whatsAtPos(currPos) == p){
                    count++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else break;
        }

        //reset the position
        currPos = pos;

        //move northwest
        while(count < numToWin){
            if(currPos.getRow()+1 < rows && currPos.getColumn()-1 >= 0){
                currPos = new BoardPosition((currPos.getRow()+1), (currPos.getColumn()-1));
                if(whatsAtPos(currPos) == p){
                    count++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else break;
        }

        //reset the position and consecutive token counter
        currPos = pos;
        count = 1;

        //move southwest
        while(count < numToWin){
            if(currPos.getRow()-1 >= 0 && currPos.getColumn()-1 >= 0){
                currPos = new BoardPosition((currPos.getRow()-1), (currPos.getColumn()-1));
                if(whatsAtPos(currPos) == p){
                    count++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else break;
        }

        currPos = pos;

        //move northeast
        while(count < numToWin){
            if(currPos.getRow()+1 < rows && currPos.getColumn()+1 < cols){
                currPos = new BoardPosition((currPos.getRow()+1), (currPos.getColumn()+1));
                if(whatsAtPos(currPos) == p){
                    count++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else return false;
            } else return false;
        }

        //no winner
        return false;
    }

    public char whatsAtPos(BoardPosition pos){
        //Return the character at position pos
        return board[pos.getRow()][pos.getColumn()];
    }

    public boolean isPlayerAtPos(BoardPosition pos, char player){
        //check to see if the player at pos matches the player passed in.
        char charAtPosition = whatsAtPos(pos);
        if(player == charAtPosition) return true;
        else return false;
    }

    /**
     * @pre     A new turn has just begun.
     * @post    This will make a string ready to print to the terminal.
     * @return  A string representing the current board state.
     */
    @Override
    public String toString(){
        //initialize first row
        String gameBoardString = "";
        for(int i=0; i<cols; i++){
            gameBoardString = gameBoardString.concat("|" + i); }
        gameBoardString = gameBoardString.concat("|\n");

        //fill in the rest of the game board
        for(int r = rows-1; r >= 0; r--){
            for(int c = 0; c < cols; c++){
                gameBoardString = gameBoardString.concat("|" + board[r][c]);
            }
            gameBoardString = gameBoardString.concat("|\n");
        }

        //return the string
        return gameBoardString;
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
