package cpsc2150.MyQueue;

import java.util.*;

/**
 * Created by zelindl on 2/6/20.
 */
public class QueueApp {
    public static void main(String [] args){
        IQueue q;
        IQueue newQ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("List or Array? (L/A)");
        String option = scanner.nextLine();

        if(option.toLowerCase().equals("l")){
            q = new ListQueue();
        }
        else{
            q = new ArrayQueue();
        }

        Integer x = 42;
        q.add(x);
        x = 17;
        q.add(x);
        x = 37;
        q.add(x);
        x = 36;
        q.add(x);
        x = 12;
        q.add(x);

        int [] arr = new int[q.size()];

        if(option.toLowerCase().equals("l")){ newQ = new ListQueue(); }
         else { newQ = new ArrayQueue(); }

        int i=0;
        while(q.size() != 0){
            arr[i] = q.pop();
            System.out.println(arr[i]);
            newQ.add(arr[i]);
            i++;
        }

        while(newQ.size() != 0){ q.add(newQ.pop()); }
        // Add the code to print the queue. After the code is finished, the
        // queue should still contain all its values in order.

    }
}
