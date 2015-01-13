import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TrafficSystemTest {

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
	public void testTrafficSystem() {
		int roadlen1 = 7;
		int roadlen2 = 5;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);
		
		assertNotNull(ts);
		assertEquals(true, ts.checkLanesNull());
	}

	@Test
	public void testAddCarsToStatGarage() {
		int roadlen1 = 7;
		int roadlen2 = 3;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);
		ts.initCars(1);
		Car car1 = new Car(0, 1);
		Car car2 = new Car(0, 2);

		ts.statisticsGarage = new Car[] {};
		Lane road = new Lane(1);
		road.temporaryParkingSpot = car2;
		Light s = new Light(4, 2);
		try{
			ts.initCars(2);
			ts.addCarsToStatGarage(road, s);

		}catch(OverflowException e){
			System.out.println("Error");
		}
		
		assertNotNull(ts);
		assertEquals(false, ts.checkLanesNull());
		assertNotNull(ts.statisticsGarage);
		
	}

	@Test
	public void testInitCars() {
		
		int roadlen1 = 7;
		int roadlen2 = 5;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);
		ts.initCars(5);
		
		boolean isNull = ts.checkLanesNull();
		assertEquals(false, isNull);
		assertEquals(ts.carAmount, 5);
		assertNotNull(ts.garage[0]);
		assertNotNull(ts.garage[1]);
		assertNotNull(ts.garage[2]);
		assertNotNull(ts.garage[3]);
		assertNotNull(ts.garage[4]);

	}

	@Test
	public void testCheckLanesNull() {
		int roadlen1 = 7;
		int roadlen2 = 5;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);
		Lane r0 = new Lane(5);
		Lane r1 = new Lane(3);
		Lane r2 = new Lane(3);
		assertEquals(true, ts.checkLanesNull());
		ts.initCars(1);

		boolean isNull = ts.checkLanesNull();
		assertEquals(false, ts.checkLanesNull());
	}

	@Test
	public void testToLastIfFree() {
		int roadlen1 = 7;
		int roadlen2 = 5;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);

		ts.initCars(3);

		Lane road = new Lane(4);
		Car newCar = new Car(0, 3);

		ts.toLastIfFree(road, newCar);

		assertEquals(2, ts.carIndex);
		assertEquals(road.getLength(), 4);
		assertNotNull(road);
	}

	@Test
	public void testSwitchLanes() {
		int roadlen1 = 7;
		int roadlen2 = 5;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);
		ts.initCars(1);
		Car switcherCar = new Car(0, new CarPosition(new Lane(3)), 2);
		Lane l1 = new Lane(3);
		Lane l2 = new Lane(2);
		CarPosition d1 = new CarPosition(new Lane(3));
		CarPosition d2 = new CarPosition(new Lane(3));
		switcherCar.setDestination(d1);
		try{
			ts.switchLanes(switcherCar, l1, l2, d1, d2);

		}catch(NullPointerException e){
			
		}
		assertEquals(l1.getLength(), 3);
		assertEquals(l2.getLength(), 2);

		assertNotNull(l1);
		assertNotNull(l2);
	}

	@Test
	public void testStep() {
		int roadlen1 = 7;
		int roadlen2 = 5;
		int forwardPeriod = 4;
		int forwardGreen = 2;
		int turnPeriod = 4;
		int turnGreen = 2;
		TrafficSystem ts = new TrafficSystem(roadlen1, roadlen2, forwardPeriod, forwardGreen, turnPeriod, turnGreen);
		ts.initCars(5);
		ts.statisticsGarage = new Car[] {};

		ts.step();
		
		assertNotNull(ts.statisticsGarage);
		assertNotNull(ts.switcher);
		
	}

}
