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

    private static int numPlayers = 0;
    private static int minPlayers = 2;
    private static int maxPlayers = 10;
    private static int turn = 0;
    private static boolean onTurns = true;
    private static char currPlayer;
    private static boolean playAgain = true;
    private static IGameBoard gameBoard;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int choice;
        String playAgainChoice;
        List<Character> tokens = new ArrayList<>();
        gameBoard = new GameBoard(5, 5, 5);

        //while the player wants to play again
        while(playAgain){

            turn = 0;
            onTurns = true;

            //get number of players + input validation
            System.out.println("How many players?");
            numPlayers = scanner.nextInt();
            while(numPlayers < minPlayers || numPlayers > maxPlayers){
                if(numPlayers < minPlayers){ System.out.println("Must be at least " + minPlayers + " players"); }
                else {System.out.println("Must be " + maxPlayers + " players or fewer"); }
                System.out.println("How many players?");
                numPlayers = scanner.nextInt();
            }

            //get players' tokens
            char tokenInput;
            Character newToken;
            for(int i=1; i <= numPlayers; i++){
                System.out.println("Enter the character to represent player " + i);
                tokenInput = scanner.next().charAt(0);
                newToken = Character.toUpperCase(tokenInput);
                while(tokens.contains(newToken)){
                    System.out.println(newToken + " is already taken as a player token!");
                    tokenInput = scanner.next().charAt(0);
                    newToken = Character.toUpperCase(tokenInput);
                }
                tokens.add(newToken);
            }

            //get number of rows + input validation
            System.out.println("How many rows should be on the board?");
            int rowInput = scanner.nextInt();
            while(rowInput < gameBoard.getMinRows() || rowInput > gameBoard.getMaxRows()){
                if(rowInput < gameBoard.getMinRows()){ System.out.println("Board cannot be less than 3 rows."); }
                else { System.out.println("Board cannot be greater than 100 rows."); }
                System.out.println("How many rows should be on the board?");
                rowInput = scanner.nextInt();
            }

            //get number of columns + input validation
            System.out.println("How many columns should be on the board?");
            int colInput = scanner.nextInt();
            while(colInput < gameBoard.getMinCols() || colInput > gameBoard.getMaxCols()) {
                if (colInput < gameBoard.getMinCols()) {
                    System.out.println("Board cannot be less than 3 columns.");
                } else {
                    System.out.println("Board cannot be greater than 100 columns.");
                }
                System.out.println("How many columns should be on the board?");
                colInput = scanner.nextInt();
            }

            //get num to win + input validation
            System.out.println("How many in a row to win?");
            int ntwInput = scanner.nextInt();
            while(ntwInput < gameBoard.getMinNumToWin() || ntwInput > gameBoard.getMaxNumToWin()){
                if(ntwInput > gameBoard.getMinNumToWin()){ System.out.println("Number in a row to win cannot be greater than 25."); }
                else { System.out.println("Number in a row to win cannot be less than 3."); }
                System.out.println("How many in a row to win?");
                ntwInput = scanner.nextInt();
            }

            //choose gameboard type
            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
            Character gameChoice = scanner.next().charAt(0);
            while(gameChoice.equals("f") || gameChoice.equals('n')){
                System.out.println("Please enter F or M");
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                gameChoice = scanner.next().charAt(0);
            }
            if(gameChoice.equals('f')){ gameBoard = new GameBoard(rowInput, colInput, ntwInput); }
            else { gameBoard = new GameBoardMem(rowInput, colInput, ntwInput); }

            //initialize gameboard rows and cols
            gameBoard.setRows(rowInput);
            gameBoard.setCols(colInput);
            gameBoard.setNumToWin(ntwInput);

            //play through the turns
            while(onTurns) {

                //print the gameboard, increment the turn counter, and get the current character
                System.out.print(gameBoard.toString());
                currPlayer = tokens.get(turn % numPlayers);

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
                gameBoard.placeToken(currPlayer, choice);

                turn++;

                //check to see if the player won
                if(gameBoard.checkForWin(choice)){

                    //print the winning message
                    System.out.print(gameBoard.toString() + "\n");

                    System.out.println("Player " + currPlayer + " won!");

                    //see if the player wants to play again and perform bounds checking
                    System.out.println("Would you like to play again?");
                    playAgainChoice = scanner.next();
                    while(playAgainChoice.toLowerCase().equals('y') && playAgainChoice.toLowerCase().equals('n')){
                        System.out.println("Would you like to play again?");
                        playAgainChoice = scanner.next();
                    }

                    turn = 0;
                    onTurns = false;
                    tokens.clear();

                    //if not, end the game
                    if(playAgainChoice.toLowerCase().equals('n')) {return;}
                }

                if(gameBoard.checkTie()){

                    //Tell the users the game is a tie
                    System.out.print(gameBoard.toString() + "\n");
                    System.out.println("This game is a tie!");

                    //ask the users if they want to play again and perform bounds checking
                    System.out.println("Would you like to play again?");
                    playAgainChoice = scanner.next();
                    while(!playAgainChoice.toLowerCase().equals('y') && !playAgainChoice.toLowerCase().equals('n')){
                        System.out.println("Would you like to play again?");
                        playAgainChoice = scanner.next();
                    }

                    turn = 0;
                    onTurns = false;
                    tokens.clear();

                    //if not, end the game
                    if(playAgainChoice.toLowerCase().equals('n')) {return;}
                }
            }
        }

    }

    /**
     * @post    Creates a GameScreen object.
     */
    public GameScreen(){

        //initialize variables
        numPlayers = 0;
        minPlayers = 2;
        maxPlayers = 10;
        turn = 0;
        onTurns = true;
        playAgain = true;
    }

    /**
     * @pre     The player has not entered a legal column choice.
     * @return  The player's chosen column.
     */
    private static int getPlayersChoice(){

        //initialize the string and add the correct player
        String toPrint = ("Player " + currPlayer);

        //finish the string and print
        toPrint = toPrint.concat(", what column do you want to place your marker in?");
        System.out.println(toPrint);

        //get the player's input
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
