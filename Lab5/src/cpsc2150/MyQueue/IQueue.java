package cpsc2150.MyQueue;

/**
 * Created by Zach Lindler and Paul Marcella on 2/13/20.
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

    /**
     * @pre     size > 0
     * @return  The Integer at the beginning of the queue.
     */
    default Integer peek(){
        Integer temp = 0;
        Integer valToReturn = 0;
        int sizeVar = size();
        for(int i=0; i<sizeVar; i++){
            temp = pop();
            if (i == 0) {
                valToReturn = temp;
            }

            add(temp);
        }
        return valToReturn;
    }

    /**
     * @pre     size > 0
     * @return  the Integer at the end of the Queue.
     */
    default Integer endOfQueue(){
        Integer temp = 0;
        Integer valToReturn = 0;
        int sizeVar = size();
        for(int i=0; i<sizeVar; i++){
            temp = pop();
            if (i == size()) {
                valToReturn = temp;
            }
            add(temp);
        }
        return valToReturn;
    }

    /**
     * @pre       size > 0
     * @pre       0 < pos <= size
     * @param x   the Integer to be inserted
     * @param pos the position to insert the Integer into
     */
    //inserts X at position pos in the Queue.
    //Beginning of queue is at position 1.
    default void insert(Integer x, int pos){
        pos = pos - 1;
        Integer temp = 0;
        for(int i = 0; i < size(); i++){
            if(i == pos){
               add(x);
            }

            else{
                add(pop());
            }
        }
    }

    /**
     * @pre       size > 0
     * @pre       0 < pos <= size
     * @param pos the specified position to remove the integer from
     * @return    the Integer removed from position 'pos'
     */
    default Integer remove(int pos){
        pos = pos - 1;
        Integer temp = 0;
        for(int i=0; i<size(); i++){
            if(i == pos){
               temp = pop();
            }
            else{
                add(pop());
            }
        }
        return temp;
    }

    /**
     * @pre       size > 0
     * @pre       0 < pos <= size
     * @param pos the specified position to look up
     * @return    the integer in position 'pos' of the queue
     */
    //returns whatever Integer was in position 'pos' in the queue.
    default Integer get(int pos){
        pos = pos - 1;
        Integer temp;
        for(int i=0; i<pos; i++){
            add(pop());
        }
        temp = peek();
        for(int j=0; j<(size()-pos); j++) {
            add(pop());
        }
        return temp;
    }


}
