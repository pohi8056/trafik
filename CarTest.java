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
public class CarTest {
    
    public CarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of step method, of class Car.
     */
    @Test
    public void testStep() {
        System.out.println("step");
        Car instance = null;
        instance.step();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stepWaitingTime method, of class Car.
     */
    @Test
    public void testStepWaitingTime() {
        System.out.println("stepWaitingTime");
        Car instance = null;
        instance.stepWaitingTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class Car.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        Car instance = null;
        Car expResult = null;
        Car result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone2 method, of class Car.
     */
    @Test
    public void testClone2() {
        System.out.println("clone2");
        Car instance = null;
        Car expResult = null;
        Car result = instance.clone2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinished method, of class Car.
     */
    @Test
    public void testSetFinished() {
        System.out.println("setFinished");
        Car instance = null;
        instance.setFinished();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFinished method, of class Car.
     */
    @Test
    public void testIsFinished() {
        System.out.println("isFinished");
        Car instance = null;
        boolean expResult = false;
        boolean result = instance.isFinished();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randomDestination method, of class Car.
     */
    @Test
    public void testRandomDestination() {
        System.out.println("randomDestination");
        CarPosition s1 = null;
        CarPosition s2 = null;
        Car instance = null;
        instance.randomDestination(s1, s2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Car.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        CarPosition currentPosition = null;
        Car instance = null;
        instance.setPosition(currentPosition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Car.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Car instance = null;
        CarPosition expResult = null;
        CarPosition result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarNr method, of class Car.
     */
    @Test
    public void testGetCarNr() {
        System.out.println("getCarNr");
        Car instance = null;
        int expResult = 0;
        int result = instance.getCarNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestination method, of class Car.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        CarPosition destination = null;
        Car instance = null;
        instance.setDestination(destination);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestination method, of class Car.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Car instance = null;
        CarPosition expResult = null;
        CarPosition result = instance.getDestination();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIntPosition method, of class Car.
     */
    @Test
    public void testSetIntPosition() {
        System.out.println("setIntPosition");
        int i = 0;
        Car instance = null;
        instance.setIntPosition(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntPosition method, of class Car.
     */
    @Test
    public void testGetIntPosition() {
        System.out.println("getIntPosition");
        Car instance = null;
        int expResult = 0;
        int result = instance.getIntPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWaitingTime method, of class Car.
     */
    @Test
    public void testGetWaitingTime() {
        System.out.println("getWaitingTime");
        Car instance = null;
        int expResult = 0;
        int result = instance.getWaitingTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringCar method, of class Car.
     */
    @Test
    public void testToStringCar() {
        System.out.println("toStringCar");
        Car instance = null;
        String expResult = "";
        String result = instance.toStringCar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
