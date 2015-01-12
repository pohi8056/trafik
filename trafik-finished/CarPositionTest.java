import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CarPositionTest {

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
	public void testCarPosition() {
		Lane testLane1 = new Lane(5);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		
		assertSame(testCarPos1.owner,testLane1);
	}

	@Test
	public void testIsEnd() {
		int n = 10;
		Lane testLane1 = new Lane(n);
		Lane testLane2 = new Lane(n);
		CarPosition testCarPos1 = new CarPosition(testLane1);
		testLane1.theLane[0] = testCarPos1;
		CarPosition testCarPos2 = testLane2.theLane[0];
		assertTrue(testCarPos1.isEnd(testCarPos1));
		assertFalse(testCarPos1.isEnd(testCarPos2));
		assertTrue(testCarPos2.isEnd(testCarPos2));
		testCarPos2 = testLane2.theLane[1];
		assertFalse(testCarPos2.isEnd(testCarPos2));
	}

	@Test
	public void testMoveForward() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		
		testLane1.theLane[0].updateForward(testCarPos3);
		
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertTrue(testLane1.theLane[0].moveForward());

		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		testLane1.theLane[0].updateForward(testCarPos1);
		
		assertFalse(testLane1.theLane[0].moveForward());
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar3);
		testLane1.theLane[0].set(testCar2);
		
		testLane1.theLane[0].updateForward(testCarPos3);
		
		assertFalse(testLane1.theLane[1].moveForward());

	}

	@Test
	public void testTurn() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		
		testLane1.theLane[0].setTurn(testCarPos3);
		
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertTrue(testLane1.theLane[0].turn());

		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		testLane1.theLane[0].setTurn(testCarPos1);
		
		assertFalse(testLane1.theLane[0].turn());
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar3);
		testLane1.theLane[0].set(testCar2);
		
		testLane1.theLane[0].setTurn(testCarPos3);
		
		assertFalse(testLane1.theLane[1].turn());
	}

	@Test
	public void testGet() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		testCarPos1.set(testCar1);
		testCarPos2.set(testCar2);
		testCarPos3.set(testCar3);
		
		assertSame(testCar1,testCarPos1.get());
		assertNotSame(testCar2,testCarPos1.get());
		assertSame(testCar2,testCarPos2.get());
		
		testCarPos3.set(testCar1);
		assertSame(testCar1,testCarPos3.get());

	}

	@Test
	public void testSetTurn() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		
		testLane1.theLane[0].setTurn(testCarPos3);
		
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertTrue(testLane1.theLane[0].turn());
		
		testLane1.theLane[0].setTurn(testCarPos2);
		
		assertFalse(testLane1.theLane[0].turn());
	
	}

	@Test
	public void testGetTurn() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		
		testLane1.theLane[0].setTurn(testCarPos3);
		
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertSame(testCarPos3,testLane1.theLane[0].getTurn());
		
		testLane1.theLane[0].setTurn(testCarPos2);
		
		assertNotSame(testCarPos3,testLane1.theLane[0].getTurn());
		}

	@Test
	public void testGetForward() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		testLane1.theLane[0].updateForward(testCarPos3);
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertSame(testCarPos3,testLane1.theLane[0].getForward());
		
		testLane1.theLane[0].updateForward(testCarPos2);
		
		assertNotSame(testCarPos3,testLane1.theLane[0].getForward());
	}

	@Test
	public void testUpdateForward() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		testLane1.theLane[0].updateForward(testCarPos3);
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertSame(testCarPos3,testLane1.theLane[0].getForward());
		
		testLane1.theLane[0].updateForward(testCarPos2);
		
		assertNotSame(testCarPos3,testLane1.theLane[0].getForward());
	}

	@Test
	public void testIsThereACar() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertFalse(testLane1.theLane[4].isThereACar());
		assertFalse(testLane1.theLane[3].isThereACar());
		assertTrue(testLane1.theLane[2].isThereACar());
		assertTrue(testLane1.theLane[1].isThereACar());
		assertTrue(testLane1.theLane[0].isThereACar());
		
		}

	@Test
	public void testSet() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		CarPosition testCarPos3 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		Car testCar3 = new Car(0,testCarPos3,3);	
		
		testLane1.theLane[2].set(testCar1);
		testLane1.theLane[1].set(testCar2);
		testLane1.theLane[0].set(testCar3);
		
		assertSame(testCar1,testLane1.theLane[2].get());
		assertSame(testCar2,testLane1.theLane[1].get());
		assertSame(testCar3,testLane1.theLane[0].get());

		assertTrue(testLane1.theLane[2].isThereACar());
		assertTrue(testLane1.theLane[1].isThereACar());
		assertTrue(testLane1.theLane[0].isThereACar());
	}

	@Test
	public void testSetNull() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);
		
		Car testCar1 = new Car(0,testCarPos1,1);
		Car testCar2 = new Car(0,testCarPos2,2);
		
		testLane1.theLane[4].set(testCar1);
		testLane1.theLane[3].set(testCar2);
		
		testLane1.theLane[4].setNull();
		testLane1.theLane[3].setNull();
		
		assertFalse(testLane1.theLane[4].isThereACar());
		assertFalse(testLane1.theLane[3].isThereACar());
		
	}

	@Test
	public void testGetPosition() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);		
		
		testCarPos1.setPosition(2);
		testCarPos2.setPosition(3);
		
		assertEquals(2,testCarPos1.getPosition());
		assertEquals(3,testCarPos2.getPosition());
	}

	@Test
	public void testSetPosition() {
		int n = 5;
		Lane testLane1 = new Lane(n);
		
		CarPosition testCarPos1 = new CarPosition(testLane1);
		CarPosition testCarPos2 = new CarPosition(testLane1);		
		
		testCarPos1.setPosition(10);
		testCarPos2.setPosition(122);
	
		
		assertEquals(10,testCarPos1.getPosition());
		assertEquals(122,testCarPos2.getPosition());
	}
}
