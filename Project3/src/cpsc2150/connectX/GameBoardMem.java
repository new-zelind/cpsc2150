package cpsc2150.connectX;

import java.util.*;

/**
 * Created by zelindl on 3/22/20.
 */
public class GameBoardMem extends AbsGameBoard {

    private int rows;
    private int cols;
    private int numToWin;
    private boolean isWinner;
    private boolean isTie;
    private Map<Character, List<BoardPosition>> board;

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
        /*for(int i=1; i<rows; i++){
            pos = new BoardPosition(i, c);
            if(whatsAtPos(pos).equals(pos)){ break; }
        }
        if(!board.containsKey(p)){
            board.put(p, new ArrayList<>());
            board.get(p).add(pos);
            return;
        }
        else{ board.get(p).add(pos); }*/

        BoardPosition pos;
        for(int i=1; i<=rows; i++){
            pos = new BoardPosition(i, c);
            if(whatsAtPos(pos) == ' '){
                if(!board.containsKey(p)){
                    board.put(p, new ArrayList<>());
                    board.get(p).add(pos);
                    return;
                }
            }
            else{ board.get(p).add(pos); }
        }
    }

    public char whatsAtPos(BoardPosition pos){
        for(Map.Entry<Character, List<BoardPosition>> m : board.entrySet()){
            for(int i = 0; i<m.getValue().size(); i++){
                if(m.getValue().equals(pos)){
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

        isTie = true;
        return true;
    }

}
