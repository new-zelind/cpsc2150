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

    private static boolean isPlayerXturn;
    private static boolean playAgain;
    private static boolean isLegalColumn;
    private static GameBoard gameBoard;

    public static void main(){
        while(getPlayAgain()){
            printGameBoard(gameBoard);

        }

    }

    /**
     * @post    Creates a GameScreen object.
     */
    public GameScreen(){
        board = new GameBoard();
        isPlayerXturn = true;
        playAgain = true;
        isLegalColumn = false;
    }

    /**
     * @pre
     * @param gameBoard A string formatted as a game board.
     * @post    A fully formatted game board printed on the terminal interface.
     */
    public static void printGameBoard(String gameBoard){
        System.out.print(gameBoard.toString());
    }

    /**
     * @pre     The player has not entered a legal column choice.
     * @post    This function will get where the player wants to place their token.
     * @return  An integer representing the player's column choice.
     */
    public static int getPlayersChoice(){
        String toPrint = ("Player ");
        if(isPlayerXturn){
            toPrint = toPrint.concat("X, ");
        } else {
            toPrint = toPrint.concat("O, ");
        }
        toPrint = toPrint.concat("what column do you want to place your marker in?");
        System.out.println(toPrint);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * @pre     A new turn has started.
     * @post    Check to see if it is Player X's turn.
     * @return  true if it is Player X's turn.
     *          false if it is Player O's turn.
     */
    public static boolean getIsPlayerXTurn(){
        return isPlayerXturn;
    }

    /**
     * @pre     A turn has ended.
     * @param toSet The value to set isPlayerXTurn to.
     * @post    isPlayerXTurn will be set to the input boolean variable.
     */
    public static void setIsPlayerXTurn(boolean toSet){
        isPlayerXturn = toSet;
    }

    public static boolean getPlayAgain(){
        return playAgain;
    }

    public static void setPlayAgain(boolean toSet){
        playAgain = toSet;
    }


}
