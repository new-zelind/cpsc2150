package cpsc2150.connectX;

/**
 * Created by zelindl on 3/22/20.
 *
 */
public abstract class AbsGameBoard implements IGameBoard {

    /**
     * @pre     A new turn has just begun.
     * @post    This will make a string ready to print to the terminal.
     * @return  A string representing the current board state.
     */
    @Override
    public String toString(){
        String boardString = "";
        for(int i=0; i<getNumColumns(); i++){
            String header = String.format("|%2d", i);
            boardString = boardString.concat(header);
        }
        boardString = boardString.concat("|\n");

        BoardPosition pos;
        for(int r = getNumRows()-1; r>=0; r--){
            for(int c = 0; c < getNumColumns(); c++){ //no, this is java
                pos = new BoardPosition(r, c);
                char toAdd = whatsAtPos(pos);
                String body = String.format("|%-2s", toAdd);
                boardString = boardString.concat(body);
            }
            boardString = boardString.concat("|\n");
        }
        boardString = boardString.concat("\n");

        return boardString;
    }


}
