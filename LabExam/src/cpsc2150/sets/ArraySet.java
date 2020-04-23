package cpsc2150.sets;

import java.util.*;

public class ArraySet<T> extends SetAbs<T> implements ISet<T> {

    private T[] arraySet;
    private int depth;

    /**
     * @post: [set is empty]
     *
     */
    @SuppressWarnings("unchecked")
    public ArraySet(){
        arraySet = (T[]) new Object[MAX_SIZE];
        depth = 0;
    }

    public void add(T val){

        //if the depth is at the max size or more, then nothing can be added. Otherwise, tack 'val' onto the end.
        if(depth >= MAX_SIZE){
            System.out.println("ArraySet is full.");
            return;
        }
        arraySet[depth] = val;
        depth++;
    }

    public T remove(){

        //return the last value in the set and decrement the depth
        T temp = arraySet[depth-1];
        depth--;
        return temp;
    }

    public boolean contains(T val){

        //traverse the array and determine if 'val' exists
        for(int i=0; i<depth; i++){
            if(arraySet[i].equals(val)) return true;
        }
        return false;
    }

    public int getSize(){
        return depth;
    }
}
