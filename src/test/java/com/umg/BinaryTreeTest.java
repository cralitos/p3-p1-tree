package com.umg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinaryTreeTest {

    private BinaryTree bt;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Before
    public void init(){
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bt =new BinaryTree();
        bt.addNode(20);
        bt.addNode(15);
        bt.addNode(25);
        bt.addNode(10);
        bt.addNode(30);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void validatePreorder(){
        bt.printPreorder(bt.root());
        assert("20 15 10 25 30 ".equals(outContent.toString()));
    }

    @Test
    public void validatePosOrder(){
        bt.printPostorder(bt.root());
        assert("10 15 30 25 20 ".equals(outContent.toString()));
    }

    @Test
    public void validateInOrder(){
        bt.addNode(17);
        bt.printInOrder(bt.root());
        assert("10 15 17 20 25 30 ".equals(outContent.toString()));
    }

    @Test
    public void validateSize(){
        bt.addNode(17);
        int size = bt.size();
        assert(size == 6);
    }

    @Test
    public void validateDepth(){

        int depth = bt.getDepth(bt.root());
        assert(depth == 3);
    }

    @Test
    public void validateEmpty(){
        bt.addNode(17);
        assert(!bt.isEmpty());
    }
}
