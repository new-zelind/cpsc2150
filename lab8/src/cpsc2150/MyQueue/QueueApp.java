package cpsc2150.MyQueue;

import java.util.*;

/**
 * Created by Zach Lindler and Paul Marcella on 2/13/20.
 */
public class QueueApp {
    public static void main(String [] args){
        IQueue<Integer> q;
        String qOption;
        int menuOption = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"a\" for array implementation or \"l\" for List implementation.");
        qOption = scanner.nextLine();

        if(qOption.toLowerCase().equals("l")){
            q = new ListQueue<Integer>();
        }
        else{
            q = new ArrayQueue<Integer>();
        }

        while(menuOption != 8){

            //print the options menu and get the user's input.
            printOptions();
            menuOption = scanner.nextInt();


            switch(menuOption){

                //add to queue
                case 1:
                    System.out.println("What do you want to add to the Queue?");
                    Integer newNum = scanner.nextInt();
                    q.add(newNum);
                    System.out.println(q.toString());
                    break;

                //get next number
                case 2:
                    if(q.size() == 0){
                        System.out.println("Queue is empty.");
                    }
                    else {
                        Object popped = q.pop();
                        System.out.println("Next in Queue is " + popped);
                        System.out.println(q.toString());

                    }
                    break;

                //peek at front
                case 3:
                    if(q.size() == 0){
                        System.out.println("Queue is empty.");
                    }
                    else {
                        Object peeked = q.peek();
                        System.out.println("Peek: " + peeked);
                        System.out.println(q.toString());

                    }
                    break;

                //peek at back
                case 4:
                    if(q.size() == 0){
                        System.out.println("Queue is empty.");
                    }
                    else {
                        Object peekEnd = q.endOfQueue();
                        System.out.println("Peek at end: " + peekEnd);
                        System.out.println(q.toString());

                    }
                    break;

                //insert at position
                case 5:
                    boolean validPosition = false;
                    int newPosition;
                    System.out.println("What do you want to add to the queue?");
                    Integer numToInsert = scanner.nextInt();
                    System.out.println("What position to insert in?");
                    newPosition = scanner.nextInt();
                    while(!validPosition){
                        if(newPosition <= q.size() && newPosition > 0){validPosition = true;}
                        else{
                            System.out.println("Not a valid position in the Queue!");
                            System.out.println("What position to insert in?");
                            newPosition = scanner.nextInt();
                        }
                    }
                    q.insert(numToInsert, newPosition);
                    System.out.println(q.toString());
                    break;

                //get position
                case 6:
                    if(q.size() == 0){
                        System.out.println("Queue is empty.");
                    }
                    else {
                        boolean isValidPosition = false;
                        Integer positionToCheck;
                        System.out.println("What position to get from the queue?");
                        positionToCheck = scanner.nextInt();
                        while (!isValidPosition) {
                            if (positionToCheck <= q.size() && positionToCheck > 0) {
                                isValidPosition = true;
                            } else {
                                System.out.println("Not a valid position in the Queue!");
                                System.out.println("What position to get from the queue?");
                                positionToCheck = scanner.nextInt();
                            }

                        }
                        Object got = q.get(positionToCheck);
                        System.out.println(got + " is at position " + positionToCheck + " in the queue.");
                        System.out.println(q.toString());
                    }
                    break;

                //remove at position
                case 7:
                    if(q.size() == 0){
                        System.out.println("Queue is empty.");
                    }
                    else {
                        boolean isLegalPosition = false;
                        Integer positionToRemove;
                        System.out.println("What position to remove from the queue?");
                        positionToRemove = scanner.nextInt();
                        while (!isLegalPosition) {
                            if (positionToRemove <= q.size() && positionToRemove > 0) {
                                isLegalPosition = true;
                            } else {
                                System.out.println("Not a valid position in the Queue!");
                                System.out.println("What position to remove from the queue?");
                                positionToRemove = scanner.nextInt();
                            }
                        }
                        Object removed = q.remove(positionToRemove);
                        System.out.println(removed + " was at position " + positionToRemove + " in the queue.");
                        System.out.println(q.toString());
                    }
                    break;

                //done
                case 8:
                    return;

                //invalid input
                default:
                    System.out.println("Not a valid option!");
                    break;
            }

        }

    }

    public static void printOptions(){
        System.out.println("1.\tAdd to the queue.");
        System.out.println("2.\tGet the next value from the queue.");
        System.out.println("3.\tPeek at the first value in the queue.");
        System.out.println("4.\tPeek at the last value in the queue.");
        System.out.println("5.\tInsert into a position in the queue.");
        System.out.println("6.\tPeek at a value in any position in the queue.");
        System.out.println("7.\tRemove a value from any position in the queue and return it.");
        System.out.println("8.\tExit.");
    }
}
