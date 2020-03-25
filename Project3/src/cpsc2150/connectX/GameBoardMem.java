package cpsc2150.connectX;

import java.util.*;

/**
 * Created by zelindl on 3/22/20.
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
 * Correspondence this = Map<Character, List<BoardPosition>> board
 */
public class GameBoardMem extends AbsGameBoard {

    private int rows;
    private int cols;
    private int numToWin;
    private Map<Character, List<BoardPosition>> board;

    /**
     *
     * @param _rows     the number of rows in the board
     * @param _cols     the number of columns in the board
     * @param _numToWin the number of tokens in a row required to win
     * @pre     MINROWS <= rows <= MAXROWS && MINCOLS <= cols MAXCOLS && MINNUMTOWIN <= numToWin <= MAXNUMTOWIN
     * @post    a new board represented by a hash table is created
     */

    public GameBoardMem(int _rows, int _cols, int _numToWin){
        rows = _rows;
        cols = _cols;
        numToWin = _numToWin;
        board = new HashMap<>();
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
        /*BoardPosition pos;
        for(int i=0; i<rows; i++){
            pos = new BoardPosition(i, c);
            if(whatsAtPos(pos) == ' '){
                if(!board.containsKey(p)){
                    board.putIfAbsent(p, new ArrayList<>());
                    board.get(p).add(pos);
                    return;
                }
            }
            else{ board.get(p).add(pos); }
        }*/

        board.putIfAbsent(p, new ArrayList<>());
        BoardPosition insertPos = new BoardPosition(0, c);
        int i = 0;
        while(whatsAtPos(insertPos) != ' '){
            insertPos = new BoardPosition(i, c);
            i++;
        }
        /*for(int i=0; whatsAtPos(insertPos) != ' '; i++){
            insertPos = new BoardPosition(i, c);
        }*/
        board.get(p).add(insertPos);
    }

    public char whatsAtPos(BoardPosition pos){
        for(Map.Entry<Character, List<BoardPosition>> m : board.entrySet()){
            for(int i = 0; i<m.getValue().size(); i++){
                if(m.getValue().get(i).equals(pos)){
                    return m.getKey();
                }
            }
        }
        return ' ';
    }

    public boolean checkTie(){

        BoardPosition currPos;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                currPos = new BoardPosition(i, j);
                if(whatsAtPos(currPos) == ' '){ return false; }
            }
        }

        return true;
    }

}
