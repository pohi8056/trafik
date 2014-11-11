public class TrafficSystem {
    // Definierar de vagar och signaler som ingar i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver bestandsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    private Car[] garage;
    private Car switcher;
    private Car[] statisticsGarage;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_PLAIN = "\033[0;0m";
    private static final String ANSI_BOLD = "\033[0;1m";


    // Diverse attribut for simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    private CarPosition dest1 = new CarPosition(r1);
    private CarPosition dest2 = new CarPosition(r2);

    // Diverse attribut for statistiksamling
    //....    
    
    private int time = 0;
    private int carNr = 0;
    private int carIndex = 0;
    private int carAmount = 0;
    private int carStatInt = 0;
    
    

    public TrafficSystem(int roadlen1, int roadlen2, int period, int green) {
	
	r0 = new Lane(roadlen1);
	r1 = new Lane(roadlen2);
	r2 = new Lane(roadlen2);
	
	s1 = new Light(period, green);
	s2 = new Light(period, green);
    	}

    public void readParameters() {
	// Laser in parametrar for simuleringen
	// Metoden kan lasa fran terminalfonster, dialogrutor
	// eller fran en parameterfil. Det sista alternativet
	// ar att foredra vid uttestning av programmet eftersom
	// man inte da behover mata in vardena vid varje korning.
        // Standardklassen Properties ar anvandbar for detta. 
    }

    // TODO; IMPLEMENT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void addCarsToStatGarage(Lane road, Light s){
	if(carStatInt < carAmount){
	    if(road.firstCar() != null && s.isGreen()){
		road.firstCar().setFinished();
		statisticsGarage[carStatInt++] = road.getFirst();
		
	    }
	}
    }

    public void initCars(int carAmount){
	this.carAmount = carAmount;
	garage = new Car[carAmount];
	statisticsGarage = new Car[carAmount];
	for(int i = 0; i < carAmount; i++){
	    garage[i] = new Car(time, 1000 + i);
	    garage[i].randomDestination(dest1, dest2);
	}

	r0.putLast(garage[carIndex++]);

    }
    

    public boolean checkLanesNull(){
	if(r0.isEmpty() && r1.isEmpty() && r2.isEmpty()){
	    return true;
	}else {
	    return false;
	}
    }



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
		    
	//*****************************************************************************************
	//*****************************************************************************************
	// TODO: GIVES COUNT ERROR AFTER EXCEPTION INSERTION
	//*****************************************************************************************
	//*****************************************************************************************
    
    
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
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lagg in och ta ur pa de olika Lane-kompenenterna

	//Steps lifetime
	for(int i = 0; i < carIndex; i++){		
	    if(garage[i].isFinished() != true){
		garage[i].step();
	    }
	}
	


	if(carIndex < carAmount){  //OK, not great
	    //for testing
	    System.out.println("CarIndex: " + carIndex + " carAmount: " + carAmount);
	    //for testing
	    addCarsToStatGarage(r1, s1);
	    addCarsToStatGarage(r2, s2);
	    
	   
	    r1.step();
	    r2.step();
	    switcher = r0.firstCar();
	    if(switcher != null){
		System.out.println("****SWITCHER****\n\n   " + switcher.toStringCar() + "   \n\n****        ****");
	    }

	    switchLanes(switcher,r1,r2,dest1,dest2);
	    r0.step();

	    toLastIfFree(r0, garage[carIndex]);

	    s1.step();
	    s2.step();
	}
	else{
	    System.out.println("CarIndex: " + carIndex + " carAmount: " + carAmount);

	    addCarsToStatGarage(r1, s1);
	    addCarsToStatGarage(r2, s2);

	    r1.step();
	    r2.step();

	    switcher = r0.firstCar();
	    if(switcher != null){
		System.out.println("****SWITCHER****\n\n   " + switcher.toStringCar() + "   \n\n****        ****");
	    }
	    switchLanes(switcher, r1, r2, dest1, dest2);
	    r0.step();

	    s1.step();
	    s2.step();
	}

    }
    
    public void printStatistics() {
	// Skriv statistiken samlad sa har langt
	for (int i = 0; i < statisticsGarage.length; i++) {
	    if (statisticsGarage[i] != null){
		System.out.println(statisticsGarage[i].toStringCar());
	    }
	    else{
		System.out.println("Car is null");
	    }
	}
    }



    
    public void print() {

	System.out.println("S1: " + s1.toString());
	if(s1.isGreen()){
	    System.out.println("Is forward green?: " + ANSI_GREEN + s1.isGreen() + ANSI_RESET);
	}else{
	    System.out.println("Is forward green?: " + ANSI_RED + s1.isGreen() + ANSI_RESET);

	}
	System.out.println("Forward: ");
	r1.toStringLane();
	System.out.println("");
	System.out.println("S2: " + s2.toString());
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
