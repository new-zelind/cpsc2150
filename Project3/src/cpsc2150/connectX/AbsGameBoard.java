package cpsc2150.connectX;

/**
 * Created by zelindl on 3/22/20.
 */
public abstract class AbsGameBoard implements IGameBoard {

    /**
     * @pre     A new turn has just begun.
     * @post    This will make a string ready to print to the terminal.
     * @return  A string representing the current board state.
     */
    @Override
    public String toString(){
        /*//initialize first row
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
        return gameBoardString;*/

        String boardString = "";
        for(int i=0; i<NUMCOLS; i++){
            String header = String.format("|%2d", i);
            boardString = boardString.concat(header);
        }
        boardString = boardString.concat("|\n");

        BoardPosition pos;
        for(int r = NUMROWS-1; r>=0; r--){
            for(int c = 0; c < NUMCOLS; c++){ //no, this is java
                pos = new BoardPosition(r, c);
                String toAdd = whatsAtPos(pos);
                String body = String.format("|%-2", toAdd);
                boardString = boardString.concat(body);
            }
            boardString = boardString.concat("|\n");
        }
        boardString = boardString.concat("\n");
    }


}
