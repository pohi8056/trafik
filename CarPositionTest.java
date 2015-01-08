/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pontushilding
 */
public class CarPositionTest {
    
    public CarPositionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEnd method, of class CarPosition.
     */
    @Test
    public void testIsEnd() {
        System.out.println("isEnd");
        CarPosition target = null;
        CarPosition instance = null;
        boolean expResult = false;
        boolean result = instance.isEnd(target);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveForward method, of class CarPosition.
     */
    @Test
    public void testMoveForward() {
        System.out.println("moveForward");
        CarPosition instance = null;
        boolean expResult = false;
        boolean result = instance.moveForward();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turn method, of class CarPosition.
     */
    @Test
    public void testTurn() {
        System.out.println("turn");
        CarPosition instance = null;
        boolean expResult = false;
        boolean result = instance.turn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class CarPosition.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        CarPosition instance = null;
        Car expResult = null;
        Car result = instance.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurn method, of class CarPosition.
     */
    @Test
    public void testSetTurn() {
        System.out.println("setTurn");
        CarPosition turn = null;
        CarPosition instance = null;
        instance.setTurn(turn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurn method, of class CarPosition.
     */
    @Test
    public void testGetTurn() {
        System.out.println("getTurn");
        CarPosition instance = null;
        CarPosition expResult = null;
        CarPosition result = instance.getTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getForward method, of class CarPosition.
     */
    @Test
    public void testGetForward() {
        System.out.println("getForward");
        CarPosition instance = null;
        CarPosition expResult = null;
        CarPosition result = instance.getForward();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateForward method, of class CarPosition.
     */
    @Test
    public void testUpdateForward() {
        System.out.println("updateForward");
        CarPosition newForward = null;
        CarPosition instance = null;
        instance.updateForward(newForward);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isThereACar method, of class CarPosition.
     */
    @Test
    public void testIsThereACar() {
        System.out.println("isThereACar");
        CarPosition instance = null;
        boolean expResult = false;
        boolean result = instance.isThereACar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class CarPosition.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Car c = null;
        CarPosition instance = null;
        instance.set(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNull method, of class CarPosition.
     */
    @Test
    public void testSetNull() {
        System.out.println("setNull");
        CarPosition instance = null;
        instance.setNull();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class CarPosition.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        CarPosition instance = null;
        int expResult = 0;
        int result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class CarPosition.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int pos = 0;
        CarPosition instance = null;
        instance.setPosition(pos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
