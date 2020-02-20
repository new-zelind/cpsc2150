package cpsc2150.connectX;

import java.util.*;
import java.io.*;

/**
 * Created by zelindl on 2/6/20.
 */
public class GameScreen {

    /**
     * @invariant 0 <= number_of_turns < (rows * columns)
     * @invariant Player X starts first.
     * @invariant Players X and O will alternate turns.
     * @invariant Four tokens in a row is required to win.
     * @invariant Players will have the option to play more than one game.
     */

    private boolean isPlayerturn;
    private boolean playAgain;
    private boolean isLegalColumn;

    public static void main(){

    }

    /**
     * @post    Creates a GameScreen object.
     */
    public GameScreen(){

    }

    /**
     * @pre
     * @param gameBoard A string formatted as a game board.
     * @post    A fully formatted game board printed on the terminal interface.
     */
    public void printGameBoard(String gameBoard){

    }

    /**
     * @pre     The player has not entered a legal column choice.
     * @post    This function will get where the player wants to place their token.
     * @return  An integer representing the player's column choice.
     */
    public int getPlayersChoice(){

    }

    /**
     * @pre     A new turn has started.
     * @post    Check to see if it is Player X's turn.
     * @return  true if it is Player X's turn.
     *          false if it is Player O's turn.
     */
    public boolean getIsPlayerXTurn(){

    }

    /**
     * @pre     A turn has ended.
     * @param toSet The value to set isPlayerXTurn to.
     * @post    isPlayerXTurn will be set to the input boolean variable.
     */
    public void setIsPlayerXTurn(boolean toSet){

    }


}
