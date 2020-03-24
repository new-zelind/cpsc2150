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


}
