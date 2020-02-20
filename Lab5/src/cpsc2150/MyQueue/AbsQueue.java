package cpsc2150.MyQueue;

/**
 * Created by Zach Lindler and Paul Marcella on 2/13/20.
 */
public abstract class AbsQueue implements IQueue {

    @Override
    public String toString(){
        String toPrint = "Queue is: ";
        Integer addToStringI;
        for(Integer i=0; i<size(); i++){
            addToStringI = pop();
            if(i == size()){
                toPrint += addToStringI;
            }
            else {
                toPrint += (addToStringI + ", ");
            }
            add(addToStringI);
        }

        return toPrint;
    }
}
