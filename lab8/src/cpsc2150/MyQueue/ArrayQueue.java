package cpsc2150.MyQueue;

/**
 * Created by Zach Lindler and Paul Marcella on 2/13/20.
 *
 * @invariant 0 <= depth <= 100
 *
 * Correspondence size_of_queue = depth;
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<T> extends AbsQueue<T>{

    //where the data is stored. myQ[0] is the front of the queue
    private T[] myQ;

    //tracks how many items in the queue
    //also used to find the end of the queue
    private int depth;

    /**
     * @post:   myQ = an array of ints of size 100
     */
    public ArrayQueue(){
        myQ = (T[]) new Object[MAX_DEPTH];
        depth = 0;
    }

    /**
     * @param   x the number to be added to the end of the queue
     * @pre     size of queue < MAX_DEPTH
     */
    public void add(T x){
        if(depth == MAX_DEPTH){
            System.out.printf("Queue is full.");
            return;
        }
        myQ[depth] = x;
        depth++;
    }

    /**
     * @return  the integer value at the front of the queue
     * @pre     size of queue > 0
     * @post    size of queue is 1 integer smaller
     */
    public T pop(){
        T valueToReturn = myQ[0];
        for(int i=0; i< depth-1; i++){
            myQ[i]=myQ[i+1];
        }
        depth--;
        return valueToReturn;
    }

    /**
     * @return  the number of Integers in the Queue
     * @post    0 <= size < MAX_DEPTH
     */
    public int size(){ return depth; }
}
