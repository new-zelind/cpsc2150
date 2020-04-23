package cpsc2150.sets;

import java.util.*;

public class ArraySet<T> extends SetAbs<T> implements ISet<T> {

    private ArrayList<T> arraySet;

    /**
     * @post: [set is empty]
     *
     */
    public ArraySet(){
        arraySet = new ArrayList<>();
    }

    public void add(T val){
        if(arraySet.size() == MAX_SIZE){
            System.out.println("ArraySet is full.");
            return;
        }
        arraySet.add(val);
    }

    public T remove(){
        return arraySet.remove(arraySet.size()-1);
    }

    public boolean contains(T val){
        return arraySet.contains(val);
    }

    public int getSize(){
        return arraySet.size();
    }
}
