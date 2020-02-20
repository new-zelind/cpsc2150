package cpsc2150.MyQueue;

/**
 * Created by Zach Lindler and Paul Marcella on 2/13/20.
 */
public abstract class AbsQueue<T> implements IQueue<T> {

    @Override
    public String toString(){
        String toPrint = "Queue is: ";
        T addToString;
        for(int i=0; i<size(); i++){
            addToString = pop();
            if(i == size()){
                toPrint += addToString;
            }
            else {
                toPrint += (addToString + ", ");
            }
            add(addToString);
        }

        return toPrint;
    }
}
