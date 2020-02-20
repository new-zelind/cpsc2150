package cpsc2150.MyQueue;

import java.util.*;

/**
 * Created by zelindl on 2/6/20.
 *
 * @invariant 0 <= depth <= 100
 *
 * Correspondence size_of_queue = List.size();
 */
public class ListQueue implements IQueue{

    //this time store the queue in a list
    private List<Integer> myQ;

    /**
     * @post:   myQ = an empty list of ints
     */
    public ListQueue(){
        myQ = new ArrayList<Integer>();
    }

    /**
     * @param   x the number to be added to the queue
     * @pre     size of queue < MAX_DEPTH
     */
    public void add(Integer x){
        myQ.add(x);
    }

    /**
     * @return  the integer value at the front of the queue
     * @pre     size of queue > 0
     * @post    size of queue is 1 integer smaller
     */
    public Integer pop(){
        Integer valueToReturn = myQ.remove(0);
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
