package cpsc2150.MyQueue;

/**
 * Created by zelindl on 2/6/20.
 *
 * A queue containing integers.
 * A queue is a data structure where the first item added to the
 * structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */
public interface IQueue {
    int MAX_DEPTH = 100;

    //Adds x to the end of the Queue
    public void add(Integer x);

    //removes and returns the integer at the front of the queue
    public Integer pop();


    //returns the number of Integers in the Queue
    public int size();
}
