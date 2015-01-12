import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CarTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStep() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(-1,testCarPos1,2);
		Car testCar3 = new Car(22,testCarPos1,3);
		
		testCar1.step();
		testCar2.step();
		testCar3.step();

		assertEquals(1,testCar1.lifetime);
		assertEquals(0,testCar2.lifetime);
		assertEquals(23,testCar3.lifetime);

	}

	@Test
	public void testStepWaitingTime() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(-1,testCarPos1,2);
		Car testCar3 = new Car(22,testCarPos1,3);
		
		testCar1.stepWaitingTime();

		testCar2.stepWaitingTime();
		testCar2.stepWaitingTime();

		
		testCar3.stepWaitingTime();
		testCar3.stepWaitingTime();
		testCar3.stepWaitingTime();

		assertEquals(1,testCar1.getWaitingTime());
		assertEquals(2,testCar2.getWaitingTime());
		assertEquals(3,testCar3.getWaitingTime());
		
	}

	@Test
	public void testCar1() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		
		assertEquals(0,testCar1.lifetime);
		assertEquals(1,testCar1.carNr);
		assertSame(testCarPos1,testCar1.destination);
	}

	@Test
	public void testCar2() {
		
		Car testCar1 = new Car(0,1);
		
		assertEquals(0,testCar1.lifetime);
		assertEquals(1,testCar1.carNr);
	}


	@Test
	public void testSetFinished() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);
		testCar1.setFinished();
		assertTrue(testCar1.routeFinished);
		assertFalse(testCar2.routeFinished);

	}

	@Test
	public void testIsFinished() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);
		testCar1.setFinished();
		assertTrue(testCar1.isFinished());
		assertFalse(testCar2.isFinished());
	}

	@Test
	public void testRandomDestination() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);
		Car testCar3 = new Car(0,testCarPos1,1);
		Car testCar4 = new Car(0,testCarPos1,1);

		testCar1.randomDestination(testCarPos1, testCarPos2);
		testCar2.randomDestination(testCarPos1, testCarPos2);
		testCar3.randomDestination(testCarPos1, testCarPos1);
		testCar4.randomDestination(testCarPos2, testCarPos2);

		
		assertTrue(testCar1.getDestination() == testCarPos1 || testCar1.getDestination() == testCarPos2);
		assertTrue(testCar2.getDestination() == testCarPos1 || testCar2.getDestination() == testCarPos2);
		assertTrue(testCar3.getDestination() == testCarPos1 || testCar3.getDestination() == testCarPos2);
		assertSame(testCar4.getDestination(),testCarPos2);
		assertTrue(testCar4.stringDestination == "Forward" || testCar4.stringDestination == "Turn");
		
	}

	@Test
	public void testSetPosition() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);
		Car testCar3 = new Car(0,testCarPos1,1);
		Car testCar4 = new Car(0,testCarPos1,1);

		testCar1.setPosition(testCarPos1);
		testCar2.setPosition(testCarPos1);
		testCar3.setPosition(testCarPos2);
		testCar4.setPosition(testCarPos2);

		assertSame(testCar1.currentPosition,testCarPos1);
		assertSame(testCar2.currentPosition,testCarPos1);
		assertSame(testCar3.currentPosition,testCarPos2);
		assertSame(testCar4.currentPosition,testCarPos2);

	}

	@Test
	public void testGetPosition() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);
		Car testCar3 = new Car(0,testCarPos1,1);
		Car testCar4 = new Car(0,testCarPos1,1);

		testCar1.setPosition(testCarPos1);
		testCar2.setPosition(testCarPos1);
		testCar3.setPosition(testCarPos2);
		testCar4.setPosition(testCarPos2);

		assertSame(testCar1.getPosition(),testCarPos1);
		assertSame(testCar2.getPosition(),testCarPos1);
		assertSame(testCar3.getPosition(),testCarPos2);
		assertSame(testCar4.getPosition(),testCarPos2);
	
	}

	@Test
	public void testGetCarNr() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(1,testCarPos1,2);
		Car testCar3 = new Car(22,testCarPos2,3);
		Car testCar4 = new Car(32,testCarPos2,4);

		assertEquals(1,testCar1.carNr);
		assertEquals(2,testCar2.carNr);
		assertEquals(3,testCar3.carNr);
		assertEquals(4,testCar4.carNr);
		
		assertEquals(1,testCar1.getCarNr());
		assertEquals(2,testCar2.getCarNr());
		assertEquals(3,testCar3.getCarNr());
		assertEquals(4,testCar4.getCarNr());

		}

	@Test
	public void testSetDestination() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);

		testCar1.setDestination(testCarPos1);
		testCar2.setDestination(testCarPos2);

		assertSame(testCar1.destination,testCarPos1);
		assertSame(testCar2.destination,testCarPos2);
		assertNotSame(testCar1.destination,testCarPos2);
		assertNotSame(testCar2.destination,testCarPos1);

	}

	@Test
	public void testGetDestination() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);

		testCar1.setDestination(testCarPos1);
		testCar2.setDestination(testCarPos2);

		assertSame(testCar1.getDestination(),testCarPos1);
		assertSame(testCar2.getDestination(),testCarPos2);
		assertNotSame(testCar1.getDestination(),testCarPos2);
		assertNotSame(testCar2.getDestination(),testCarPos1);
	}

	@Test
	public void testSetIntPosition() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);

		testCar1.setIntPosition(1);
		testCar2.setIntPosition(2);

		assertEquals(1,testCar1.intPosition);
		assertEquals(2,testCar2.intPosition);
		
		testCar1.setIntPosition(3);
		testCar2.setIntPosition(4);
		
		assertNotEquals(1,testCar1.intPosition);
		assertNotEquals(2,testCar2.intPosition);
		
		}

	@Test
	public void testGetIntPosition() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);

		testCar1.setIntPosition(1);
		testCar2.setIntPosition(2);

		assertEquals(1,testCar1.intPosition);
		assertEquals(2,testCar2.intPosition);
		
		testCar1.setIntPosition(3);
		testCar2.setIntPosition(4);
		
		assertNotEquals(1,testCar1.getIntPosition());
		assertNotEquals(2,testCar2.getIntPosition());	
		}

	@Test
	public void testGetWaitingTime() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos1,1);
		Car testCar3 = new Car(0,testCarPos1,1);		
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		testLane1.step();

		assertEquals(1,testCar1.waitingTime);
		assertEquals(1,testCar2.waitingTime);
	
		testLane1.step();
		testLane1.step();

		assertEquals(3,testCar1.waitingTime);
		assertEquals(3,testCar2.waitingTime);
		
		testLane1.theLane[0].setNull();
		
		testLane1.step();

		assertEquals(3,testCar1.waitingTime);
		assertEquals(3,testCar2.waitingTime);

	}


}
