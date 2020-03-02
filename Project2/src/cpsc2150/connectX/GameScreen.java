package cpsc2150.connectX;

import java.util.*;

/**
 * Created by zelindl on 2/6/20.
 *
 * @invariant 0 <= number_of_turns < (rows * columns)
 * @invariant Player X starts first.
 * @invariant Players X and O will alternate turns.
 * @invariant Four tokens in a row is required to win.
 * @invariant Players will have the option to play more than one game.
 *
 */
public class GameScreen {

    private static boolean isPlayerXturn;
    private static boolean playAgain;
    private static GameBoard gameBoard = new GameBoard();

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int choice;
        String playAgainChoice;

        //while the player wants to play again
        while(!playAgain){

            //print the gameboard
            System.out.print(gameBoard.toString() + "\n");

            //get the players choice and perform bounds checking
            choice = getPlayersChoice();
            while(choice >= gameBoard.getNumColumns() || choice < 0){
                if(choice >= gameBoard.getNumColumns()) {System.out.println("Column cannot be greater than " + (gameBoard.getNumColumns()-1));}
                else { System.out.println("Column cannot be less than 0"); }
                choice = getPlayersChoice();
            }

            //check to see if the column is free
            while(!gameBoard.checkIfFree(choice)){

                //if not, ask the user for another entry and perform bounds checking
                System.out.println("Column is full");
                choice = getPlayersChoice();
                while(choice >= gameBoard.getNumColumns() || choice < 0){
                    if(choice >= gameBoard.getNumColumns()) {System.out.println("Column cannot be greater than " + (gameBoard.getNumColumns()-1));}
                    else { System.out.println("Column cannot be less than 0"); }
                    choice = getPlayersChoice();
                }
            }

            //place the appropriate token in the board
            if(!isPlayerXturn) { gameBoard.placeToken('X', choice); }
            else{ gameBoard.placeToken('O', choice); }

            //check to see if the player won
            if(gameBoard.checkForWin(choice)){

                //print the winning message
                System.out.print(gameBoard.toString() + "\n");
                if(!isPlayerXturn){ System.out.println("Player X won!"); }
                else { System.out.println("Player O won!"); }

                //see if the player wants to play again and perform bounds checking
                System.out.println("Would you like to play again?");
                playAgainChoice = scanner.next();
                while(!playAgainChoice.toLowerCase().equals("y") && !playAgainChoice.toLowerCase().equals("n")){
                    System.out.println("Would you like to play again?");
                    playAgainChoice = scanner.next();
                }

                //if not, end the game
                if(playAgainChoice.toLowerCase().equals("n")) {return;}

                //reset the player and gameboard
                isPlayerXturn = true;
                gameBoard = new GameBoard();
            }

            if(gameBoard.checkTie()){

                //Tell the users the game is a tie
                System.out.print(gameBoard.toString() + "\n");
                System.out.println("This game is a tie!");

                //ask the users if they want to play again and perform bounds checking
                System.out.println("Would you like to play again?");
                playAgainChoice = scanner.next();
                while(!playAgainChoice.toLowerCase().equals("y") && !playAgainChoice.toLowerCase().equals("n")){
                    System.out.println("Would you like to play again?");
                    playAgainChoice = scanner.next();
                }

                //if not, end the game
                if(playAgainChoice.toLowerCase().equals("n")) {return;}

                //reset the player and gameboard
                isPlayerXturn = true;
                gameBoard = new GameBoard();
            }

            //alternate turns
            isPlayerXturn = !isPlayerXturn;
        }

    }

    /**
     * @post    Creates a GameScreen object.
     */
    public GameScreen(){

        //create a new gameboard and initialize variables
        gameBoard = new GameBoard();
        isPlayerXturn = true;
        playAgain = true;
    }

    /**
     * @pre     The player has not entered a legal column choice.
     * @post    This function will get where the player wants to place their token.
     * @return  The player's chosen column.
     */
    public static int getPlayersChoice(){

        //initialize the string and add the correct player
        String toPrint = ("Player ");
        if(!isPlayerXturn){
            toPrint = toPrint.concat("X, ");
        } else {
            toPrint = toPrint.concat("O, ");
        }

        //finish the string and print
        toPrint = toPrint.concat("what column do you want to place your marker in?");
        System.out.println(toPrint);

        //get the player's input
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
