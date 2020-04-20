package cpsc2150.connectX;

import java.util.*;
/**
 * The controller class will handle communication between our View and our Model (IGameBoard)
 *
 * This is where you will write code
 *
 * You will need to include your IGameBoard interface
 * and both of the IGameBoard implementations from Homework 3
 * If your code was correct you will not need to make any changes to your IGameBoard implementation class
 */

public class ConnectXController {
    //our current game that is being played
    private IGameBoard curGame;

    //The screen that provides our view
    private ConnectXView screen;

    //turn counter
    private int turns;

    //list of characters to use
    Character[] tokens = {'X','O','A','C','E','H','I','K','M','S'};

    //our play tokens are hard coded. We could make a screen to get those from the user, but
    public static final int MAX_PLAYERS = 10;

    //number of players
    private int numPlayers;

    //is the game a win or a tie
    private boolean gameOver = false;


    /**
     *
     * @param model the board implementation
     * @param view the screen that is shown
     * @post the controller will respond to actions on the view using the model.
     */
    ConnectXController(IGameBoard model, ConnectXView view, int np){
        this.curGame = model;
        this.screen = view;
        numPlayers = np;

    }

    /**
     *
     *
     * @param col the column of the activated button
     * @post will allow the player to place a token in the column if it is not full, otherwise it will display an error
     * and allow them to pick again. Will check for a win as well. If a player wins it will allow for them to play another
     * game hitting any button
     */
    public void processButtonClick(int col) {

        //Is this the reset click? If so, reset the board.
        if(gameOver){
            newGame();
            gameOver = false;
        }

        //Check to see if the current column is full. If so, tell the user.
        if(!curGame.checkIfFree(col)){
            screen.setMessage("Error: column " + col + " is full.");
            return;
        }

        //Get the current player's token.
        char currToken = tokens[(turns % numPlayers)];

        //Start at the bottom of the column and work up until the next available space.
        int row = 0;
        BoardPosition pos = new BoardPosition(row, col);
        while(curGame.whatsAtPos(pos) != ' '){
            row++;
            pos = new BoardPosition(row, col);
        }

        //Place the token in curGame.
        curGame.placeToken(currToken, col);

        //Place the token in the GUI and increment the turn counter.
        screen.setMarker(row, col, currToken);
        turns++;

        //check for a win and alert the player if true
        if(curGame.checkForWin(col)){
            screen.setMessage("Player" + currToken + " won! Click any button to start a new game.");
            gameOver = true;
            return;
        }

        //check for a tie and alert the player if true
        if(curGame.checkTie()){
            screen.setMessage("This game is a tie! Click any button to start a new game.");
            gameOver = true;
            return;
        }

        //display that it is the next player's turn.
        screen.setMessage("It is " + tokens[(turns % numPlayers)] + "'s turn.");
    }

    /**
     * This method will start a new game by returning to the setup screen and controller
     */
    private void newGame(){
        //close the current screen
        screen.dispose();
        //start back at the set up menu
        SetupView screen = new SetupView();
        SetupController controller = new SetupController(screen);
        screen.registerObserver(controller);
    }
}
