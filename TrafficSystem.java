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
    /** Description of r0 */
    private Lane  r0;
    /** Description of r1 */
    private Lane  r1;
    /** Description of r2 */
    private Lane  r2;
    /** Description of s1 */
    private Light s1;
    /** Description of s2 */
    private Light s2;
    /** Description of garage */
    private Car[] garage;
    /** Description of switcher */
    private Car switcher;
    /** Description of statisticsGarage */
    private Car[] statisticsGarage;
    /** Description of ANSI_GREEN */
    public static final String ANSI_GREEN = "\u001B[32m";
    /** Description of ANSI_RESET */
    public static final String ANSI_RESET = "\u001B[0m";
    /** Description of ANSI_RED */
    public static final String ANSI_RED = "\u001B[31m";
    /** Description of ANSI_PLAIN */
    private static final String ANSI_PLAIN = "\033[0;0m";
    /** Description of ANSI_BOLD */
    private static final String ANSI_BOLD = "\033[0;1m";


    // Diverse attribut for simuleringsparametrar (ankomstintensiteter,
    // destinationer...)
    /** Description of dest1 */
    private CarPosition dest1 = new CarPosition(r1);
    /** Description of dest2 */
    private CarPosition dest2 = new CarPosition(r2);

    // Diverse attribut for statistiksamling
    //....    
    /** Description of lifeTime */
    private int lifeTime = 0;
    /** Description of carNr */
    private int carNr = 0;
    /** Description of carIndex */
    private int carIndex = 0;
    /** Description of carAmount */
    private int carAmount = 0;
    /** Description of carStatInt */
    private int carStatInt = 0;
    
    


    /** Description of TrafficSystem()
     *
     * Constructs a Lane objects r0,r2,r3 and Light objects s1 and s2.
     * 
     *@param roadlen1        integer deciding length of the array r0 and r1 of type Lane
     *@param roadlen2        integer deciding length of the array r2 of type Lane
     *@param period          sets period for Light s1 and Light s2
     *@param green           sets green for Light s1 and Light s2
     */
    public TrafficSystem(int roadlen1, int roadlen2, int forwardPeriod, int forwardGreen, int turnPeriod, int turnGreen) {
	
	r0 = new Lane(roadlen1);
	r1 = new Lane(roadlen2);
	r2 = new Lane(roadlen2);
		
	s1 = new Light(forwardPeriod, forwardGreen);
	s2 = new Light(turnPeriod, turnGreen);
    	}



	/** Description of readParameters()
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


    /** Description of addCarsToStatGarage(Lane road, Light s)
     *
     * Set Car object in road[0] to null
     * and add Car object to statisticsGarage[carStatInt] and 
     * increment carStatInt, if s.isGreen() == true.
     * Else increment the waitingTime counter for the Car object in rood[0] by 1.
     *
     *
     *
     * @param road	        the Lane object to remove Car objects from
     * @param s		        the Light object to check if Car removal is allowed
     * @return Nothing
     */
    public void addCarsToStatGarage(Lane road, Light s){
	if(carStatInt < carAmount){
	    if(road.firstCar() != null && s.isGreen()){
		road.firstCar().setFinished();                  //
		statisticsGarage[carStatInt++] = road.getFirst();
		
	    }
	    else if(road.firstCar() != null){               //Check for null car
		road.firstCar().stepWaitingTime();         //Increment waitingTime
	    }
	}
    }



    /** Description of initCars(int carAmount)
     * Constructs Car array garage and Car array statisticsGarage of size carAmount;
     * inserts Car(lifeTime, 1000 + i) for i=0 to carAmount-1 into garage array.
     *
     * @param carAmount			number of Car objects to be created and inserted in garage array and statisticsGarage array
     * @return Nothing
     */
    public void initCars(int carAmount){
	this.carAmount = carAmount;
	garage = new Car[carAmount];
	statisticsGarage = new Car[carAmount];
	for(int i = 0; i < carAmount; i++){
	    if(i == 3){
		garage[i] = new Taxi(lifeTime,1000 + 1,0);
	    }
	    else{
		garage[i] = new Car(lifeTime, 1000 + i);
		garage[i].randomDestination(dest1, dest2);}
	}

	r0.putLast(garage[carIndex++]);

    }
    

   /**Description of checkLanesNull()
   * 
   * Checks if all Car objects in r0, r1, r2 are null.
   *
   * @return true if all Car objects in r0, r1, r2 are set to null. Else false.
   */
    public boolean checkLanesNull(){
	if(r0.isEmpty() && r1.isEmpty() && r2.isEmpty()){
	    return true;
	}else {
	    return false;
	}
    }



   /**Description of toLastIfFree()
   * 
   * @throws 
   *
   * @return
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
    
    public void printStatistics() {
	// Skriv statistiken samlad sa har langt
	System.out.println("\nSTATISTICS-GARAGE:\n------------------");

	for (int i = 0; i < statisticsGarage.length; i++) {
	    if (statisticsGarage[i] != null){
		System.out.println(statisticsGarage[i].toStringCar());
	    }
	    else{
		System.out.println("<EMPTY>");
	    }
	}
	System.out.println("\n------------------");
    }
 

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

