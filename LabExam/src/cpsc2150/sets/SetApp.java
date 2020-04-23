package cpsc2150.sets;

import java.util.*;
public class SetApp {
    private static final int EXIT_CHOICE = 3;

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);


        //Print a menu of options
        printMenu();
        int input = Integer.parseInt(in.nextLine());
        while(input != EXIT_CHOICE)
        {
            if(input == 1){
                //option 1 is find the union of 2 sets
                //Make each set
                System.out.println("Make set 1");
                ISet<Integer> set1 = getSet(in);
                System.out.println("Make set 2");
                ISet<Integer> set2 = getSet(in);

                //print the sets
                System.out.println("Set 1 is:");
                System.out.println(set1.toString());
                System.out.println("Set 2 is:");
                System.out.println(set2.toString());

                //union the sets together
                if(set1.getSize() + set2.getSize() > set1.MAX_SIZE){
                    System.out.println("Error: the two sets cannot be unioned - too large.");
                    continue;
                }
                else {
                    set1.union(set2);

                    //print the union
                    System.out.println("The union is:");
                    System.out.println(set1.toString());
                }


            }
            else if(input == 2){
                //Option 2 is find the intersection of 2 sets
                //Make the sets
                System.out.println("Make set 1");
                ISet<Integer> set1 = getSet(in);
                System.out.println("Make set 2");
                ISet<Integer> set2 = getSet(in);

                //print the sets
                System.out.println("Set 1 is:");
                System.out.println(set1.toString());
                System.out.println("Set 2 is:");
                System.out.println(set2.toString());

                //get the intersection
                set1.intersect(set2);

                //print the intersection
                System.out.println("The intersection is:");
                System.out.println(set1.toString());
            }
            else
            {
                System.out.println("That was not an option");
            }


            //print the menu and get the next option
            printMenu();
            input = Integer.parseInt(in.nextLine());
        }


    }

    /**
     * @pre: none
     * @post: [menu will be displayed to user]
     */
    private static void printMenu(){
        System.out.println("\n Make a selection");
        System.out.println("1. Find the Union of Two Sets");
        System.out.println("2. Find the intersection of Two Sets");
        System.out.println(EXIT_CHOICE + ". Exit");

    }

    /**
     * This method will get the values from a user and build a set
     * @param in a scanner object to use to get data from the user
     * @return a set that the user built
     * @pre in is open and connected to the user
     * @post none
     */
    private static ISet<Integer> getSet(Scanner in){

        ISet<Integer> s;

        //prompt user for set type
        System.out.println("List set or Array set? (L/A)");
        String input = in.nextLine();
        while(!input.toLowerCase().equals("l") && !input.toLowerCase().equals("a")){
            System.out.println("Please enter L or A.");
            System.out.println("List set or Array set? (L/A)");
            input = in.next();
        }

        //create the sets
        if(input.toLowerCase().equals("a")) s = new ArraySet<>();
        else s = new ListSet<>();

        // add values to the set user enters q to stop entering values
        System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
        String val = in.nextLine();
        while(!val.equals("q") ){
            //we can assume if they did not enter a Q they did enter a number
            int addVal = Integer.parseInt(val);
            if(s.contains(addVal)){
                System.out.println("Error: set already contains " + addVal);
            }
            else if(s.getSize() >= s.MAX_SIZE){
                System.out.println("Error: set is at or above the max size allowed.");
            }
            else{
                s.add(addVal);
            }
            //get the next value before looping
            System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
            val = in.nextLine();
        }

        //we have filled our set, so we can return it
        return s;


    }
}
