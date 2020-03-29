package cpsc2150.listDec;

import java.util.*;

/**
 * Created by Zach Lindler and Paul Marcella on 3/26/20.
 */
public interface IShuffleList<T> extends List<T> {
    /**
     * @pre:    List.size() >= 2
     * @pre:    swaps > 0
     * @param swaps: the number of individual swaps that should take place
     * @post:   List.at(1) = #List.at(rand), List.at(2) = #List.at(rand), ... List.at(n) = #List.at(rand)
     */
    default void shuffle(int swaps){
        int rand1, rand2;
        int numShuffles = 0;
        Random rand = new Random();
        while(numShuffles < swaps){
            rand1 = rand.nextInt(size());
            rand2 = rand.nextInt(size());
            swap(rand1, rand2);
            numShuffles++;
        }
    }

    /**
     * @pre:    List.size() >= 2
     * @pre:    i != j
     * @pre:    0 <= i < List.size() && 0 <= j < List.size()
     * @param i: the index of the first element to be swapped
     * @param j: the index of the second element to be swapped
     * @post: List.at(i) = #List.at(j) && List.at(j) = #List.at(i)
     */
    default void swap(int i, int j){
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }
}
