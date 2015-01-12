import java.util.*;

/** Description of TrafficSystem 
 *
 * @author Pontus Hilding
 * @author Lukas Hamberg
 * @version 1.0
 * @since   2014-10-31 
 */
public class TrafficSystem {
    // Definierar de vagar och signaler som ingar i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver bestandsdelarna i systemet
    /** First part of main road */
    private Lane  r0;

    /** Continutation of main road */
    private Lane  r1;

    /** turn lane */
    private Lane  r2;

    /** Trafficlights belonging to continuation of main road */
    private Light s1;

    /** Trafficlights belonging to turn lane */
    private Light s2;

    /** List of cars to be inserted on main road */
    private Car[] garage;

    /** Car waiting to be inserted on continuation of main road or turn lane */
    private Car switcher;

    /** List of cars that have finished stepping through the roads*/
    private Car[] statisticsGarage;

    /** Used for green terminal text */
    public static final String ANSI_GREEN = "\u001B[32m";

    /** Used for resetting terminal text */
    public static final String ANSI_RESET = "\u001B[0m";

    /** Used for red terminal text */
    public static final String ANSI_RED = "\u001B[31m";

    /** Used for plain terminal text */
    private static final String ANSI_PLAIN = "\033[0;0m";

    /** Used for bold terminal text */
    private static final String ANSI_BOLD = "\033[0;1m";


    // Diverse attribut for simuleringsparametrar (ankomstintensiteter,
    // destinationer...)
    /** The destination belonging to cars continuing along the main road */
    private CarPosition dest1 = new CarPosition(r1);

    /** The destination belonging to cars going to the turn lane  */
    private CarPosition dest2 = new CarPosition(r2);

    // Diverse attribut for statistiksamling
    //....    
    /** The initial lifeTime value a car is created with*/
    private int lifeTime = 0;

    /** For each car i created, car recieves carNr  1000 + i*/
    private int carNr = 0;

    /** The current number of cars that have been placed on the road */
    private int carIndex = 0;

    /** The total nr of cars that will be placed on the road */
    private int carAmount = 0;

    /** The total number of cars that  have fininshed */
    private int carStatInt = 0;
    
    


    /** Description of TrafficSystem()
     *
     * Constructs a three roads r0,r2,r3, and two trafficlights s1 and s2.
     * 
     *@param roadlen1               integer deciding length of the roads r0 and r1
     *@param roadlen2               integer deciding length of the road r2
     *@param forwardPeriod          sets period for trafficlight s1
     *@param forwardGreen           sets green value for trafficlight s1
     *@param turnPeriod             sets period for trafficlight s2
     *@param turnGreen              sets green value for trafficlight s2
     *
     */
    public TrafficSystem(int roadlen1, int roadlen2, int forwardPeriod, int forwardGreen, int turnPeriod, int turnGreen) {
	/**Road to move cars on*/
	r0 = new Lane(roadlen1);
	/**Continuation of road r0 to move cars on*/
	r1 = new Lane(roadlen2);
	/**Sidelane road to move cars on*/
	r2 = new Lane(roadlen2);
	
	/**Traffic light belonging to r1*/
	s1 = new Light(forwardPeriod, forwardGreen);
	/**Traffic light belonging to r1*/
	s2 = new Light(turnPeriod, turnGreen);
    	}



	/** readParameters()
	 * 
	 */
    public void readParameters() {
	// Laser in parametrar for simuleringen
	// Metoden kan lasa fran terminalfonster, dialogrutor
	// eller fran en parameterfil. Det sista alternativet
	// ar att foredra vid uttestning av programmet eftersom
	// man inte da behover mata in vardena vid varje korning.
        // Standardklassen Properties ar anvandbar for detta. 
    }


    /**addCarsToStatGarage(Lane road, Light s)
     *
     * Removes first car in road
     * and adds that car to statisticsGarage  
     * incrementing carStatInt only if traffics light s is green.
     * Else increment the waitingTime counter for the first car in rood by 1.
     *
     * @param road	        the road to remove car from
     * @param s		        the trafficlight used to check if car removal is allowed
     */
    public void addCarsToStatGarage(Lane road, Light s){
	if(carStatInt < carAmount){
	    if(road.firstCar() != null && s.isGreen()){
		road.firstCar().setFinished();                  
		statisticsGarage[carStatInt++] = road.getFirst();
		
	    }
	    else if(road.firstCar() != null){               //Check for null car
		road.firstCar().stepWaitingTime();         //Increment waitingTime
	    }
	}
    }



    /**initCars(int carAmount)
     * Constructs array full of cars garage and an empty array of cars statisticsGarage of size carAmount;
     * The third car inserted into the garage is a taxi
     * @param carAmount		        number of cars to be created and inserted in garage array and statisticsGarage array
     */
    public void initCars(int carAmount){
	this.carAmount = carAmount;
	garage = new Car[carAmount];
	statisticsGarage = new Car[carAmount];
	for(int i = 0; i < carAmount; i++){
	    if(i == 3){
		garage[i] = new Taxi(lifeTime,1000 + 1,0);
		garage[i].randomDestination(dest1, dest2);
	    }
	    else{
		garage[i] = new Car(lifeTime, 1000 + i);
		garage[i].randomDestination(dest1, dest2);
	    }
	}
	r0.putLast(garage[carIndex++]);
    }
    

   /**checkLanesNull()
   * 
   * True if all roads are empty.
   * @see step()
   * @return true if all Car objects in r0, r1, r2 are set to null. Else false.
   */
    public boolean checkLanesNull(){
	if(r0.isEmpty() && r1.isEmpty() && r2.isEmpty()){
	    return true;
	}else {
	    return false;
	}
    }



   /**toLastIfFree()
   *  
   *
   *@param road Road to put cars in
   *@param newCar Creates a new car on the road
   *@throws OverflowException
   */
    public void toLastIfFree( Lane road , Car newCar){
	try {
	    road.putLast(newCar);
	    ++carIndex;
	}
	catch (OverflowException e) {
	    System.out.println("Error " + e.getMessage());
	    e.printStackTrace();
	}	
    }
    
    /**
     * Moves switcherCar to either the forward or the turning lane depending on its destination.
     *
     * @param switcherCar the car to be moved
     * @param l1 the forward lane
     * @param l2 the turning lane
     * @param d1 the forward destination
     * @param d2 the turning destination
     */	        
    
    public void switchLanes(Car switcherCar, Lane l1 , Lane l2, CarPosition d1, CarPosition d2){
	if(switcherCar != null){
	    if(switcherCar.getDestination() == d1 && l1.lastFree()){
		l1.putLast(r0.getFirst());
	    }
	    else{
		if(l2.lastFree() && switcherCar.getDestination() == d2){
		    l2.putLast(r0.getFirst());
		}
	    }
	}
    }

    /**
     * Coordinates the whole simulation with the help of the other classes step() functions; moving cars forward in the lane, switching to new lanes and moving cars to the garage for statistics gathering.
     */

    public void step() {
	for(int i = 0; i < carIndex; i++){		
	    if(garage[i].isFinished() != true){
		garage[i].step();
	    }
	}
	


	if(carIndex < carAmount){
	    System.out.println("\nCarIndex: " + carIndex + " carAmount: " + carAmount);
	    
	    addCarsToStatGarage(r1, s1);
	    addCarsToStatGarage(r2, s2);
	    
	    
	    r1.step();
	    r2.step();
	    
	    switcher = r0.firstCar();
	    if(switcher != null){
		System.out.println("\n-------------\nSWITCHER CAR: " + switcher.toStringCar() + "\n-------------");
	    }

	    switchLanes(switcher,r1,r2,dest1,dest2);
	    r0.step();

	    toLastIfFree(r0, garage[carIndex]);

	    s1.step();
	    s2.step();
	}
	else{
	    System.out.println("\nCarIndex: " + carIndex + " carAmount: " + carAmount);

	    addCarsToStatGarage(r1, s1);
	    addCarsToStatGarage(r2, s2);

	    r1.step();
	    r2.step();

	    switcher = r0.firstCar();
	    if(switcher != null){
		System.out.println("\n-------------\nSWITCHER CAR: " + switcher.toStringCar() + "\n-------------");
	    }
	    switchLanes(switcher, r1, r2, dest1, dest2);
	    r0.step();

	    s1.step();
	    s2.step();
	}

    }
    

    /**
     * Prints the statistics of all cars after the simulation has finished, showing values such as waiting time and total time in the simulation.
     */

    public void printStatistics() {
	// Skriv statistiken samlad sa har langt
	System.out.println("\nSTATISTICS-GARAGE:\n------------------");

	for (int i = 0; i < statisticsGarage.length; i++) {
	    if (statisticsGarage[i] != null){
		try {
		    System.out.flush();

		    Thread.sleep(120);
		    System.out.println(statisticsGarage[i].toStringCar());
		    
		} catch (Exception ex) {
		    Thread.currentThread().interrupt();

		}
	    }
	    else{
		System.out.println("<EMPTY>");
	    }
	}
	System.out.println("\n------------------");
    }
 
    /**
     * Prints the statistics of the simulation, i.e the cars with the highest waiting times in the simulation and the average waiting time. 
     */

    public void printHighestWaitingTimes() {
	Car[] carsToReturn = new Car[statisticsGarage.length];
	int highestInt = 0;
	int totalWait = 0;
	for (int i = 0; i < statisticsGarage.length; i++) {
	    totalWait += statisticsGarage[i].getWaitingTime();
	    if (statisticsGarage[i].getWaitingTime() >= highestInt) {
		highestInt =statisticsGarage[i].getWaitingTime();
		carsToReturn[i] = statisticsGarage[i];
	    }
	}
	System.out.println("\nCars with highest waiting times:\n---------------------------------");
	for (int i = 0; i < carsToReturn.length; i++) {
	    if (carsToReturn[i] != null && carsToReturn[i].getWaitingTime() == highestInt) {
		System.out.println("* " + carsToReturn[i].toStringCar());
	    }
	}
	System.out.print("\nAverage waiting time: ");
	System.out.println(totalWait/statisticsGarage.length + "\n");	
    }


    /**
     * Uses the classes various print functions to portrait an overall representation of the traffic simulation.
     */
    
    public void print() {
	System.out.println("*******************************************\n");

	System.out.println("Forward Light: " + s1.toString());
	if(s1.isGreen()){
	    System.out.println("Is forward green?: " + ANSI_GREEN + s1.isGreen() + ANSI_RESET);
	}else{
	    System.out.println("Is forward green?: " + ANSI_RED + s1.isGreen() + ANSI_RESET);

	}
	System.out.println("Forward: ");
	r1.toStringLane();
	System.out.println("");
	System.out.println("Turn light: " + s2.toString());
	if(s2.isGreen()){
	System.out.println("Is Turn green?: " + ANSI_GREEN+ s2.isGreen() + ANSI_RESET);
	}else{
	    System.out.println("Is Turn green?: " + ANSI_RED+ s2.isGreen() + ANSI_RESET);
	}
	System.out.println("Turn: ");
	r2.toStringLane();
	System.out.println("");

	System.out.println("Main road: ");
	r0.toStringLane();
	System.out.println("");
	System.out.println("*******************************************");

	// Skriv ut en grafisk representation av kosituationen 
	// med hjalp av klassernas toString-metoder
    }

}

