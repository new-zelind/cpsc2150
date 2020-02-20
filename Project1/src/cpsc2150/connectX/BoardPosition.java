package cpsc2150.connectX;

/**
 * Created by zelindl on 2/6/20.
 */
public class BoardPosition {

    private int rowNum;
    private int colNum;

    /**
     * @pre     A game has been started, and a game board has been created.
     * @param row    the row number of the position to be created.
     * @param column the column number of the position to be created.
     * @post    A fully made BoardPosition class instance.
     */
    public BoardPosition(int row, int column){

    }

    /**
     * @post    Get the row number of the position.
     * @return  Returns an integer representing the row number of the position.
     */
    public int getRow(){

    }

    /**
     * @post    Get the column number of the position.
     * @return  Returns an integer representing the column number of the position.
     */
    public int getColumn(){

    }

    /**
     * @param position An instance of the BoardPosition class.
     * @post    Check to see whether two board positions are equal.
     * @return  true if the two positions have the same row and column.
     *          false if the two positions have different rows or columns.
     */
    @Override
    public boolean equals(Object position){

    }

    /**
     * @post    the BoardPosition class will be formatted as a string.
     * @return  a fully formatted BoardPosition as "Row, Column".
     */
    @Override
    public String toString(){

    }


}
