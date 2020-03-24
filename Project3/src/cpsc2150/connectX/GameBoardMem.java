package cpsc2150.connectX;

/**
 * Created by zelindl on 3/22/20.
 */
public class GameBoardMem extends AbsGameBoard {

    private int rows;
    private int cols;
    private int numToWin;
    private boolean isWinner;
    private boolean isTie;
    private Map<char, List<BoardPosition>> board;

    public GameBoardMem(int _rows, int _cols, int _numToWin){
        rows = _rows;
        cols = _cols;
        numToWin = _numToWin;
        board = new HashMap<>();
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

        BoardPosition placePos;
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
        for(Map.Entry<char, List<BoardPosition>> m : board.entrySet()){
            while(m.hasNext()){
                if(m.getValue().equals(pos)){
                    return m.getKey();
                }
            }
        }
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
