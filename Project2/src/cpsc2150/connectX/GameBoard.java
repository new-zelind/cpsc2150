package cpsc2150.connectX;

/**
 * Created by zelindl on 2/6/20.
 */
public class GameBoard implements IGameBoard {

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
        rows = MAXROWS;
        cols = MAXCOLS;
        numToWin = NUMTOWIN;
        isTie = isWinner = false;
        board = new char[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                board[i][j] = ' ';
            }
        }
    }

    public int getNumRows(){ return rows; }

    public int getNumColumns(){ return cols; }

    public int getNumToWin(){ return numToWin; }

    public Boolean checkIfFree(int c){
        int numTokens = 0;
        int i = 0;
        while(i < getNumRows()){
            if(board[i][c] != ' '){numTokens++;}
            i++;
        }

        return (numTokens == rows);
    }

    public Boolean checkForWin(int c){
        //get row number of latest position
        int rowNum = 0;
        while(board[rowNum][c] != ' '){
            rowNum++;
        }

        //get character
        char token = board[rowNum][c];
        BoardPosition currPos = new BoardPosition(rowNum, c);
        if(checkHorizWin(currPos, token)){return true;}
        else if(checkVertWin(currPos, token)){return true;}
        else if(checkDiagWin(currPos, token)){return true;}
        else {return false;}
    }

    public void placeToken(char p, int c){
        if(checkIfFree(c)){
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
        BoardPosition currPos = new BoardPosition(pos.getRow(), pos.getColumn());

        while(!traverseRight){
            if(currPos.getColumn()+1 < cols){
                currPos = new BoardPosition(currPos.getRow(), (currPos.getColumn()+1));
                if(whatsAtPos(currPos) == p){
                    count ++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else traverseRight = true;
        }

        currPos = pos;
        while(traverseRight){
            if(currPos.getColumn()-1 >= 0){
                currPos = new BoardPosition(currPos.getRow(), (currPos.getColumn()+1));
                if(whatsAtPos(currPos) == p){
                    count ++;
                    if(count == numToWin){
                        isWinner = true;
                        return true;
                    }
                } else break;
            } else break;
        }

        return false;
    }

    public Boolean checkVertWin(BoardPosition pos, char p){

        int count = 1;
        BoardPosition currPos = new BoardPosition(pos.getRow(), pos.getColumn());

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
        BoardPosition currPos = new BoardPosition(pos.getRow(), pos.getColumn());

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

        //reset
        currPos = new BoardPosition(pos.getRow(), pos.getColumn());
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

        return false;
    }

    public char whatsAtPos(BoardPosition pos){
        return board[pos.getRow()][pos.getColumn()];
    }

    public boolean isPlayerAtPos(BoardPosition pos, char player){
        char charAtPosition = whatsAtPos(pos);
        if(player == charAtPosition) return true;
        else return false;
    }

    public String toString(){
        //initialize first row
        String gameBoardString = "|";
        for(int i=0; i<cols; i++){ gameBoardString = gameBoardString.concat(i + "|"); }
        gameBoardString = gameBoardString.concat("\n");

        BoardPosition currPos;
        for(int r = rows-1; r >= 0; r--){
            gameBoardString = gameBoardString.concat("|");
            for(int c = 0; c <= cols; c++){
                currPos = new BoardPosition(r, c);
                gameBoardString = gameBoardString.concat(whatsAtPos(currPos) + "|");
            }
            gameBoardString = gameBoardString.concat("\n");
        }

        return gameBoardString;
    }

    public boolean checkTie(){

        BoardPosition currPos;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                currPos = new BoardPosition(i, j);
                if(whatsAtPos(currPos) == ' '){
                    return false;
                }
            }
        }

        isTie = true;
        return true;
    }
}
