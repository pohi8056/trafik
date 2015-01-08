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
public class TrafficSystemTest {
    
    public TrafficSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readParameters method, of class TrafficSystem.
     */
    @Test
    public void testReadParameters() {
        System.out.println("readParameters");
        TrafficSystem instance = null;
        instance.readParameters();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCarsToStatGarage method, of class TrafficSystem.
     */
    @Test
    public void testAddCarsToStatGarage() {
        System.out.println("addCarsToStatGarage");
        Lane road = null;
        Light s = null;
        TrafficSystem instance = null;
        instance.addCarsToStatGarage(road, s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initCars method, of class TrafficSystem.
     */
    @Test
    public void testInitCars() {
        System.out.println("initCars");
        int carAmount = 0;
        TrafficSystem instance = null;
        instance.initCars(carAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLanesNull method, of class TrafficSystem.
     */
    @Test
    public void testCheckLanesNull() {
        System.out.println("checkLanesNull");
        TrafficSystem instance = null;
        boolean expResult = false;
        boolean result = instance.checkLanesNull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLastIfFree method, of class TrafficSystem.
     */
    @Test
    public void testToLastIfFree() {
        System.out.println("toLastIfFree");
        Lane road = null;
        Car newCar = null;
        TrafficSystem instance = null;
        instance.toLastIfFree(road, newCar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchLanes method, of class TrafficSystem.
     */
    @Test
    public void testSwitchLanes() {
        System.out.println("switchLanes");
        Car switcherCar = null;
        Lane l1 = null;
        Lane l2 = null;
        CarPosition d1 = null;
        CarPosition d2 = null;
        TrafficSystem instance = null;
        instance.switchLanes(switcherCar, l1, l2, d1, d2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of step method, of class TrafficSystem.
     */
    @Test
    public void testStep() {
        System.out.println("step");
        TrafficSystem instance = null;
        instance.step();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printStatistics method, of class TrafficSystem.
     */
    @Test
    public void testPrintStatistics() {
        System.out.println("printStatistics");
        TrafficSystem instance = null;
        instance.printStatistics();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printHighestWaitingTimes method, of class TrafficSystem.
     */
    @Test
    public void testPrintHighestWaitingTimes() {
        System.out.println("printHighestWaitingTimes");
        TrafficSystem instance = null;
        instance.printHighestWaitingTimes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class TrafficSystem.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        TrafficSystem instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
