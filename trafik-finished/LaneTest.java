import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LaneTest {

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
	public void testLane() {
		Lane testLane = new Lane(10);
		for(int i = 0; i < 10; i++){
		    assertNotNull(testLane.theLane[i]);
		}
		for (int i = (10-1); i > 0; i--) {
			assertSame(testLane.theLane[i].getForward(),testLane.theLane[i-1]);  
		}
	}

	@Test
	public void testIsEmpty() {
		Lane testLane = new Lane(10);
		for(int i = 0; i < testLane.getLength(); i++){
			testLane.theLane[i].setNull();
		}
		for(int i = 0; i < testLane.getLength(); i++){
		    assertNull(testLane.theLane[i].get());
		}
	}

	@Test
	public void testMatchEnd() {
		int n = 10;
		Lane testLane1 = new Lane(n);
		CarPosition testCarPos1 = testLane1.theLane[0];
		CarPosition testCarPos2 = testLane1.theLane[1];
		assertTrue(testLane1.matchEnd(testCarPos1));
		assertFalse(testLane1.matchEnd(testCarPos2));		
	}

	@Test
	public void testGetLength() {
		int n = 10;
		Lane testLane = new Lane(n);
		assertTrue(n == testLane.getLength());
	}

	@Test
	public void testStep() {
		
		Lane testLane1 = new Lane(5);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	

		testLane1.theLane[4].set(testCar1);
		testLane1.theLane[3].set(testCar2);
		testLane1.theLane[2].set(testCar3);
		testLane1.theLane[1].setNull();
		testLane1.theLane[0].setNull();


		
		testLane1.step();
		assertNull(testLane1.theLane[4].get());
		assertSame(testLane1.theLane[3].get(),testCar1);
		//First Step
		assertEquals(testLane1.theLane[3].get().getIntPosition(),3);
		assertSame(testLane1.theLane[2].get(),testCar2);
		
		assertEquals(testLane1.theLane[2].get().getIntPosition(),2);
		assertSame(testLane1.theLane[1].get(),testCar3);
		
		assertEquals(testLane1.theLane[1].get().getIntPosition(),1);
		assertNull(testLane1.theLane[0].get());
		
		//Second step
		testLane1.step();
		assertNull(testLane1.theLane[4].get());
		assertNull(testLane1.theLane[3].get());
		
		assertSame(testLane1.theLane[2].get(),testCar1);
		assertEquals(testLane1.theLane[2].get().getIntPosition(),2);
		
		assertSame(testLane1.theLane[1].get(),testCar2);
		assertEquals(testLane1.theLane[1].get().getIntPosition(),1);
		
		assertSame(testLane1.theLane[0].get(),testCar3);
		assertEquals(testLane1.theLane[0].get().getIntPosition(),0);
		
		//Third step
		testLane1.step();
		assertNull(testLane1.theLane[4].get());
		assertNull(testLane1.theLane[3].get());
		
		assertSame(testLane1.theLane[2].get(),testCar1);
		assertEquals(testLane1.theLane[2].get().getIntPosition(),2);
		assertEquals(testLane1.theLane[2].get().getWaitingTime(),1);

		
		assertSame(testLane1.theLane[1].get(),testCar2);
		assertEquals(testLane1.theLane[1].get().getIntPosition(),1);
		assertEquals(testLane1.theLane[1].get().getWaitingTime(),1);

		assertSame(testLane1.theLane[0].get(),testCar3);
		assertEquals(testLane1.theLane[0].get().getIntPosition(),0);
		assertEquals(testLane1.theLane[0].get().getWaitingTime(),0);

	}

	@Test
	public void testGetFirst() {
		Lane testLane1 = new Lane(5);

		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);

		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,1);
		
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar1);

		testLane1.step();
		assertSame(testLane1.getFirst(),testCar1);
		assertNull(testLane1.theLane[0].get());		
	}

	@Test
	public void testFirstCar() {
		Lane testLane1 = new Lane(5);

		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);

		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,1);
		
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar1);
		testLane1.step();
		assertSame(testLane1.getFirst(),testCar1);
	}

	@Test
	public void testLastFree() {
		Lane testLane1 = new Lane(3);

		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);

		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,1);

		testLane1.theLane[2].setNull();
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar1);
		
		//Free assertion
		assertTrue(testLane1.lastFree());
		
		//Not free assertion
		testLane1.theLane[2].set(testCar2);
		assertFalse(testLane1.lastFree());

	}

	@Test
	public void testPutLast() {
		
		Lane testLane1 = new Lane(5);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		CarPosition testCarPos4 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);
		Car testCar4 = new Car(0,testCarPos4,4);
		
		testLane1.theLane[4].set(testCar1);
		testLane1.theLane[3].set(testCar2);
		testLane1.theLane[2].set(testCar3);
		testLane1.theLane[1].setNull();
		testLane1.theLane[0].setNull();
		try {
			testLane1.putLast(testCar4);
			assertSame(testLane1.theLane[4].get(),testCar1);
			assertSame(testLane1.theLane[3].get(),testCar2);
			assertSame(testLane1.theLane[2].get(),testCar3);
			assertEquals(testCar4.getWaitingTime(),1);
			
		} catch (OverflowException e) {

		}

		
		testLane1.step();
		testLane1.putLast(testCar4);
		assertSame(testLane1.theLane[4].get(),testCar4);
		assertSame(testLane1.theLane[3].get(),testCar1);
		assertSame(testLane1.theLane[2].get(),testCar2);
		assertSame(testLane1.theLane[1].get(),testCar3);

	}

}
