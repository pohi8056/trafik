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
public class LaneTest {
    
    public LaneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isEmpty method, of class Lane.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Lane instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matchEnd method, of class Lane.
     */
    @Test
    public void testMatchEnd() {
        System.out.println("matchEnd");
        CarPosition target = null;
        Lane instance = null;
        boolean expResult = false;
        boolean result = instance.matchEnd(target);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Lane.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Lane instance = null;
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParallel method, of class Lane.
     */
    @Test
    public void testSetParallel() {
        System.out.println("setParallel");
        Lane sideLane = null;
        Lane instance = null;
        instance.setParallel(sideLane);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of step method, of class Lane.
     */
    @Test
    public void testStep() {
        System.out.println("step");
        Lane instance = null;
        instance.step();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirst method, of class Lane.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Lane instance = null;
        Car expResult = null;
        Car result = instance.getFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of firstCar method, of class Lane.
     */
    @Test
    public void testFirstCar() {
        System.out.println("firstCar");
        Lane instance = null;
        Car expResult = null;
        Car result = instance.firstCar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastFree method, of class Lane.
     */
    @Test
    public void testLastFree() {
        System.out.println("lastFree");
        Lane instance = null;
        boolean expResult = false;
        boolean result = instance.lastFree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of putLast method, of class Lane.
     */
    @Test
    public void testPutLast() {
        System.out.println("putLast");
        Car c = null;
        Lane instance = null;
        instance.putLast(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringLane method, of class Lane.
     */
    @Test
    public void testToStringLane() {
        System.out.println("toStringLane");
        Lane instance = null;
        instance.toStringLane();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
