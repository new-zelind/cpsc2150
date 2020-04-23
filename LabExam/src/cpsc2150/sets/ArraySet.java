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
        if(depth >= MAX_SIZE){
            System.out.println("ArraySet is full.");
            return;
        }
        arraySet[depth] = val;
        depth++;
    }

    public T remove(){
        T temp = arraySet[depth-1];
        depth--;
        return temp;
    }

    public boolean contains(T val){
        for(int i=0; i<depth; i++){
            if(arraySet[depth].equals(val)) return true;
        }
        return false;
    }

    public int getSize(){
        return depth;
    }
}
