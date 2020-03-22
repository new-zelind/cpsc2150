package cpsc2150.MyQueue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Zach Lindler and Paul Marcella on 3/5/20.
 */
public class TestListQueue {
    private IQueue<Integer> makeQueue(){ return new ListQueue<>(); }

    //testing add
    @Test
    public void testAdd_posInt(){
        Integer add1 = 10;
        Integer add2 = 1;
        Integer add3 = 25;

        IQueue<Integer> q = makeQueue();

        q.add(add1);
        q.add(add2);
        q.add(add3);

        assertTrue(q.get(1) == 10);
        assertTrue(q.get(2) == 1);
        assertTrue(q.get(3) == 25);
    }

    @Test
    public void testAdd_negInt(){
        Integer add1 = -10;
        Integer add2 = -1;
        Integer add3 = -25;

        IQueue<Integer> q = makeQueue();

        q.add(add1);
        q.add(add2);
        q.add(add3);

        assertTrue(q.get(1) == -10);
        assertTrue(q.get(2) == -1);
        assertTrue(q.get(3) == -25);
    }

    @Test
    public void testAdd_BigQueue(){

        IQueue<Integer> q = makeQueue();

        for(Integer i=0; i<100; i++){
            q.add(i);
        }

        for(Integer i = 0; i < 100; i++) {
            assertTrue(q.get(i).equals(i));

        }

    }

    //testing peek
    @Test
    public void testPeek_testPosInt(){
        Integer add1 = 10;
        Integer add2 = 1;
        Integer add3 = 25;

        IQueue<Integer> q = makeQueue();

        q.add(add1);
        q.add(add2);
        q.add(add3);

        Integer peeked = q.peek();

        assertTrue(peeked.equals(q.get(1)));
    }

    @Test
    public void testPeek_testNegInt(){
        Integer add1 = -10;
        Integer add2 = -1;
        Integer add3 = -25;

        IQueue<Integer> q = makeQueue();

        q.add(add1);
        q.add(add2);
        q.add(add3);

        Integer peeked = q.peek();

        assertTrue(peeked.equals(q.get(1)));
    }

    @Test
    public void testPeek_length(){
        Integer add1 = -10;

        IQueue<Integer> q = makeQueue();

        q.add(add1);

        Integer peeked = q.peek();

        assertTrue(peeked.equals(q.get(1)));
    }

    //testing endOfQueue
    @Test
    public void testEOQ_testPosInt(){
        Integer add1 = 10;
        Integer add2 = 1;
        Integer add3 = 25;

        IQueue<Integer> q = makeQueue();

        q.add(add1);
        q.add(add2);
        q.add(add3);

        Integer eoq = q.endOfQueue();

        assertTrue(eoq.equals(q.get(q.size())));
    }

    @Test
    public void testEOQ_smallQ(){
        Integer add1 = 10;

        IQueue<Integer> q = makeQueue();

        q.add(add1);

        Integer eoq = q.endOfQueue();

        assertTrue(eoq.equals(q.get(q.size())));
    }

    @Test
    public void testEOQ_BigQ(){

        IQueue<Integer> q = makeQueue();

        for(Integer i=0; i<100; i++){
            q.add(i);
        }

        Integer eoq = q.endOfQueue();

        assertTrue(eoq.equals(q.get(q.size())));

    }

    //testing insert
    @Test
    public void testInsert_testMaxSize(){
        IQueue<Integer> q = makeQueue();

        for(Integer i=0; i<30; i++){
            q.add(i);
        }

        Integer add1 = 10;
        Integer add2 = 1;
        Integer add3 = 25;
        int pos1 = 1;
        int pos2 = 20;
        int pos3 = 12;

        q.insert(add1, pos1);
        assertTrue(q.get(1) == 10);
        q.insert(add2, pos2);
        assertTrue(q.get(20) == 1);
        q.insert(add3, pos3);
        assertTrue(q.get(12) == 25);
    }

    @Test
    public void testInsert_testSmall(){
        IQueue<Integer> q = makeQueue();

        q.add(0);

        Integer add1 = 5;
        Integer add2 = -2;
        Integer add3 = 12;
        int pos1 = 1;
        int pos2 = 2;
        int pos3 = 3;

        q.insert(add1, pos1);
        q.insert(add2, pos2);
        q.insert(add3, pos3);

        assertTrue(q.get(1) == 5);
    }

    @Test
    public void testInsert_testBigQ(){
        IQueue<Integer> q = makeQueue();

        for(Integer i=1; i<=30; i++){
            q.add(i);
        }

        Integer add1 = 10;
        Integer add2 = 1;
        Integer add3 = -25;
        int pos1 = q.size();
        int pos2 = q.size();
        int pos3 = q.size();

        q.insert(add1, pos1);
        assertTrue(q.get(q.size()-1) == 10);

        q.insert(add2, pos2);
        assertTrue(q.get(q.size()-2) == 1);

        q.insert(add3, pos3);
        assertTrue(q.get(q.size()-3) == -25);

    }

    //testing remove
    @Test
    public void testRemove_general(){
        IQueue<Integer> q = makeQueue();

        for(Integer i=1; i<=30; i++){
            q.add(i);
        }

        int pos1 = 15;
        int pos2 = 10;
        int pos3 = 5;
        Integer rm1 = q.remove(pos1);
        Integer rm2 = q.remove(pos2);
        Integer rm3 = q.remove(pos3);

        assertTrue(rm1 == pos1);
        assertTrue(rm2 == pos2);
        assertTrue(rm3 == pos3);

    }

    @Test
    public void testRemove_qEnd(){
        IQueue<Integer> q = makeQueue();

        for(Integer i=1; i<=30; i++){
            q.add(i);
        }

        int pos1 = q.size();
        Integer rm1 = q.remove(pos1);
        assertTrue(rm1 == pos1);

        int pos2 = q.size();
        Integer rm2 = q.remove(pos2);
        assertTrue(rm2 == pos2);

        int pos3 = q.size();
        Integer rm3 = q.remove(pos3);
        assertTrue(rm3 == pos3);

    }

    @Test
    public void testRemove_qFront(){
        IQueue<Integer> q = makeQueue();

        for(Integer i=1; i<=30; i++){
            q.add(i);
        }

        int pos1 = 1;
        int pos2 = 1;
        int pos3 = 1;
        Integer rm1 = q.remove(pos1);
        Integer rm2 = q.remove(pos2);
        Integer rm3 = q.remove(pos3);

        assertTrue(rm1 == 1);
        assertTrue(rm2 == 2);
        assertTrue(rm3 == 3);

    }

    //testing get
    @Test
    public void testGet_testFront(){
        IQueue<Integer> q = makeQueue();

        q.add(12);
        q.add(10);
        q.add(-1);

        Integer got = q.get(1);

        assertTrue(got == 12);
    }

    @Test
    public void testGet_testBack(){
        IQueue<Integer> q = makeQueue();

        q.add(12);
        q.add(10);
        q.add(-1);

        Integer got = q.get(q.size());

        assertTrue(got == -1);
    }

    @Test
    public void testGet_testBigInt(){
        IQueue<Integer> q = makeQueue();

        q.add(12);
        q.add(10);
        q.add(-1);

        Integer got = q.get(2);

        assertTrue(got == 10);
    }



}
