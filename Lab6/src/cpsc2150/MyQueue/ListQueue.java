package cpsc2150.MyQueue;

import java.util.*;

/**
 * Created by Zach Lindler and Paul Marcella on 2/13/20.
 *
 * @invariant 0 <= depth <= 100
 *
 * Correspondence size_of_queue = List.size();
 */
public class ListQueue<T> extends AbsQueue<T>{

    //this time store the queue in a list
    private List<T> myQ;

    /**
     * @post:   myQ = an empty list of ints
     */
    public ListQueue(){
        myQ = new ArrayList<T>();
    }

    /**
     * @param   x the number to be added to the queue
     * @pre     size of queue < MAX_DEPTH
     */
    public void add(T x){
        if(myQ.size() == MAX_DEPTH){
            System.out.print("Queue is full.");
            return;
        }
        myQ.add(x);
    }

    /**
     * @return  the integer value at the front of the queue
     * @pre     size of queue > 0
     * @post    size of queue is 1 integer smaller
     */
    public T pop(){
        T valueToReturn = myQ.remove(0);
        return valueToReturn;
    }

    /**
     * @return  the number of Integers in the list
     * @post    0 <= size < MAX_DEPTH
     */
    public int size(){
        return myQ.size();
    }
}
