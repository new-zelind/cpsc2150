package cpsc2150.connectX;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by zelindl on 4/10/2020
 * Remember, Testing is the future, and the future starts with you! -Cave Johnson
 */
public class TestGameBoard {
    private IGameBoard GameBoardFactory(int r, int c, int ntw){
        return new GameBoard(r, c, ntw);
    }

    /*
     TESTING CONSTRUCTOR
     */
    @Test
    public void testGameBoardMemMinVals(){
        IGameBoard gb = GameBoardFactory(3, 3, 3);
        assertEquals(gb.getNumRows(), 3);
        assertEquals(gb.getNumColumns(), 3);
        assertEquals(gb.getNumToWin(), 3);
    }

    @Test
    public void testGameBoardMemMaxVals(){
        IGameBoard gb = GameBoardFactory(100, 100, 25);
        assertEquals(gb.getNumRows(), 100);
        assertEquals(gb.getNumColumns(), 100);
        assertEquals(gb.getNumToWin(), 25);
    }

    @Test
    public void testGameBoardMemUnevenVals(){
        IGameBoard gb = GameBoardFactory(5, 7, 4);
        assertEquals(gb.getNumRows(), 5);
        assertEquals(gb.getNumColumns(), 7);
        assertEquals(gb.getNumToWin(), 4);
    }

    /*
     TESTING PLACETOKEN
     */
    @Test
    public void testPlaceTokenFirstTokenOnBoard(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        BoardPosition testPos = new BoardPosition(0, 0);
        assertEquals(gb.whatsAtPos(testPos), 'X');

    }

    @Test
    public void testPlaceTokenFirstTokenInFarColumn(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        BoardPosition testPos = new BoardPosition(0, 4);
        assertEquals(gb.whatsAtPos(testPos), 'O');
    }

    @Test
    public void testPlaceTokenFinalTokenInFirstColumn(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        BoardPosition testPos = new BoardPosition(4, 0);
        assertEquals(gb.whatsAtPos(testPos), 'O');
    }

    @Test
    public void testPlaceTokenFinalTokenInFarColumn(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        BoardPosition testPos = new BoardPosition(4, 4);
        assertEquals(gb.whatsAtPos(testPos), 'O');
    }

    @Test
    public void testPlaceTokenFinalTokenInBoard(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);

        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);

        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);

        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);

        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        BoardPosition testPos = new BoardPosition(4, 2);
        assertEquals(gb.whatsAtPos(testPos), 'X');
    }

    /*
     TESTING WHATSATPOS
     */

    @Test
    public void testWhatAtPosBlankBoard(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        BoardPosition toTest = new BoardPosition(2, 2);
        assertEquals(gb.whatsAtPos(toTest), ' ');
    }

    @Test
    public void testWhatsAtPosOneChar(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        BoardPosition toTest = new BoardPosition(0, 0);
        assertEquals(gb.whatsAtPos(toTest), 'X');
    }

    @Test
    public void testWhatsAtPosFarChar(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        BoardPosition toTest = new BoardPosition(0, 4);
        assertEquals(gb.whatsAtPos(toTest), 'O');
    }

    @Test
    public void testWhatsAtPosTopOfFirstCol(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        BoardPosition toTest = new BoardPosition(4, 0);
        assertEquals(gb.whatsAtPos(toTest), 'O');
    }

    @Test
    public void testWhatsAtPosFarColumnFull(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        BoardPosition toTest = new BoardPosition(4, 0);
        assertEquals(gb.whatsAtPos(toTest), 'O');
    }

    /*
     TESTING ISPLAYERATPOS
     */

    @Test
    public void testIsPlayerAtPosEmptyBoard(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        BoardPosition toTest = new BoardPosition(0, 0);
        assertEquals(gb.isPlayerAtPos(toTest, 'X'), false);
    }

    @Test
    public void testIsPlayerAtPosOneToken(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        BoardPosition toTest = new BoardPosition(0, 0);
        assertEquals(gb.isPlayerAtPos(toTest, 'X'), true);
    }

    @Test
    public void testIsPlayerAtPosOneFullColumnFalse(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('A', 0);
        gb.placeToken('B', 0);
        gb.placeToken('C', 0);
        gb.placeToken('D', 0);
        BoardPosition toTest = new BoardPosition(4, 0);
        assertEquals(gb.isPlayerAtPos(toTest, 'X'), false);
    }

    @Test
    public void testIsPlayerAtPosOneFullColumnTrue(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('A', 0);
        gb.placeToken('B', 0);
        gb.placeToken('C', 0);
        gb.placeToken('D', 0);
        BoardPosition toTest = new BoardPosition(4, 0);
        assertEquals(gb.isPlayerAtPos(toTest, 'D'), true);
    }

    @Test
    public void testIsPlayerAtPosMiddleOfBoard(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('A', 0);
        gb.placeToken('B', 1);
        gb.placeToken('C', 2);
        gb.placeToken('D', 3);
        gb.placeToken('D', 4);
        gb.placeToken('A', 1);
        gb.placeToken('B', 2);
        gb.placeToken('C', 3);
        gb.placeToken('E', 2);
        gb.placeToken('D', 1);
        BoardPosition toTest = new BoardPosition(2, 2);
        assertEquals(gb.isPlayerAtPos(toTest, 'X'), false);
    }

    /*
     TESTING CHECKIFFREE
     */

    @Test
    public void testCheckIfFreeEmpty(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        assertEquals(gb.checkIfFree(4), true);
    }

    @Test
    public void testCheckIFFreeAlmostFull(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        assertEquals(gb.checkIfFree(0), true);
    }

    @Test
    public void testCheckIfFreeFull(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        assertEquals(gb.checkIfFree(0), false);
    }

    /*
     TESTING CHECKHORIZWIN
     */

    @Test
    public void testHorizLastTokenOnLeft(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 1);
        BoardPosition winner = new BoardPosition(0, 1);
        assertEquals(gb.checkHorizWin(winner, 'X'), true);
    }

    @Test
    public void testHorizLastTokenOnRight(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        BoardPosition winner = new BoardPosition(0, 4);
        assertEquals(gb.checkHorizWin(winner, 'X'), true);
    }

    @Test
    public void testHorizLastTokenInMiddle(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 1);
        BoardPosition winner = new BoardPosition(0, 1);
        assertEquals(gb.checkHorizWin(winner, 'X'), true);
    }

    @Test
    public void testHorizNonWinner(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        BoardPosition winner = new BoardPosition(0, 2);
        assertEquals(gb.checkHorizWin(winner, 'X'), false);
    }

    /*
     TESTING CHECKVERTWIN
     */

    @Test
    public void testVertBottomOfCol(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        BoardPosition winner = new BoardPosition(3, 3);
        assertEquals(gb.checkVertWin(winner, 'X'), true);
    }

    @Test
    public void testVertTopOfCol(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        BoardPosition winner = new BoardPosition(4, 3);
        assertEquals(gb.checkVertWin(winner, 'X'), true);
    }

    @Test
    public void testVertNonWinnerSplit(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        BoardPosition winner = new BoardPosition(4, 4);
        assertEquals(gb.checkVertWin(winner, 'X'), false);
    }

    @Test
    public void testVertNonWinnerTooShort(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 0);
        BoardPosition winner = new BoardPosition(2, 0);
        assertEquals(gb.checkVertWin(winner, 'X'), false);
    }

    /*
     TESTING CHECKDIAGWIN
     */
    @Test
    public void testDiagEndNW_SE(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 0);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        BoardPosition winner = new BoardPosition(3, 3);
        assertEquals(gb.checkDiagWin(winner, 'X'), true);
    }

    @Test
    public void testDiagEndNE_SW(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 3);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 4);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        BoardPosition winner = new BoardPosition(1, 3);
        assertEquals(gb.checkDiagWin(winner, 'X'), true);
    }

    @Test
    public void testDiagMidNW_SE(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 1);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        BoardPosition winner = new BoardPosition(2, 2);
        assertEquals(gb.checkDiagWin(winner, 'X'), true);
    }

    @Test
    public void testDiagMidNE_SW(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 0);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        BoardPosition winner = new BoardPosition(2, 2);
        assertEquals(gb.checkDiagWin(winner, 'X'), true);
    }

    @Test
    public void testDiagIntersectNE_SW(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 2);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        BoardPosition winner = new BoardPosition(1, 3);
        assertEquals(gb.checkDiagWin(winner, 'X'), true);
    }

    @Test
    public void testDiagIntersectNW_SE(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        BoardPosition winner = new BoardPosition(2, 2);
        assertEquals(gb.checkDiagWin(winner, 'X'), true);
    }

    @Test
    public void testDiagNoWinner(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 1);
        gb.placeToken('O', 0);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        BoardPosition winner = new BoardPosition(2, 2);
        assertEquals(gb.checkDiagWin(winner, 'X'), false);
    }

    /*
     TESTING CHECKTIE
     */

    @Test
    public void testCheckTieOneColEmpty(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);

        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);

        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        assertEquals(gb.checkTie(), false);
    }

    @Test
    public void testCheckTieOneRowEmpty(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);

        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        assertEquals(gb.checkTie(), false);
    }

    @Test
    public void testcheckTieOneSpaceEmpty(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);

        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        assertEquals(gb.checkTie(), false);
    }

    @Test
    public void checkTieFullBoard(){
        IGameBoard gb = GameBoardFactory(5, 5, 4);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);

        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);

        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        assertEquals(gb.checkTie(), false);
    }

}
