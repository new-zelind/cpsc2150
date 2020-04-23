package cpsc2150.sets;

import java.util.*;

/**
 * Sets are an unordered collection that does not allow duplicate values.
 * Defines: size: Z - how many items are in the set
 * Initialization Ensures: the set is empty and size = 0
 * Constraints: [this contains no duplicate values]
 *
 */

public interface ISet<T> {
	int MAX_SIZE = 100;

    /**
     *
     * @param val the value to add to the set
     * @pre: !contains(val) and size < MAX_SIZE
     * @post: [val is added to the set]
     */
    void add(T val);

    /**
     *
     * @return the value removed from the set
	 * @pre size > 0
     * @post: remove = [a value from the set] and this = #this - remove
     */
    T remove();

    /**
     *
     * @param val a value to check
     * @return whether or not val is in the set
     * @pre: none needed
     * @post: contains iff [val is in this]
     */
    boolean contains(T val);

    /**
     *
     * @return the size of the set
     * @pre: none needed
     * @post: getSize = size
     */
    int getSize();

    /**
     *
     * @param unionWith the set to union with
     * @pre this.getSize() + unionWith.getSize() <= MAX_SIZE
     * @post this = #this U unionWith
     */
    default void union(ISet<T> unionWith){
        int size = unionWith.getSize();
        for(int i=0; i < size; i++){
            T newVal = unionWith.remove();
            if(!this.contains(newVal)) this.add(newVal);
        }
    }

    /**
     *
     * @param intersectWith the set to intersect with
     * @post this = [the intersection of #this and  intersectWith]
     */
    default void intersect(ISet<T> intersectWith){

        ArrayList<T> duplicates = new ArrayList<>();

        int tSize = this.getSize();
        for(int i=0; i<tSize; i++) duplicates.add(this.remove());

        for (T temp : duplicates) {
            if (intersectWith.contains(temp)) this.add(temp);
        }
    }


}
