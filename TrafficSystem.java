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
		statisticsGarage[carStatInt] = road.getFirst();
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
	//r0.toStringLane();
	//garage[carAmount-1].toStringCar();
	r0.putLast(garage[carIndex++]);
	//r0.toStringLane();
	//System.out.println("YEY");
    }
    

    public boolean checkLanesNull(){
	if(r0.isEmpty() && r1.isEmpty() && r2.isEmpty()){
	    return true;
	}else {
	    return false;
	}
    }



    public void toLastIfFree( Lane road , Car newCar){
	if(road.lastFree()){
	    //System.out.println(road.lastFree());
	    road.putLast(newCar);
	    //road.toStringLane();
	    ++carIndex;
	}
    }
    
    public void switchLanes(Car switcherCar, Lane l1 , Lane l2, CarPosition d1, CarPosition d2){
	if(switcherCar != null){
	    if(switcherCar.getDestination() == dest1 && l1.lastFree()){
		l1.putLast(r0.getFirst());
	    }
	    else{
		if(l2.lastFree()){
		    l2.putLast(r0.getFirst());
		}
	    }
	}
    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lagg in och ta ur pa de olika Lane-kompenenterna
	if(carIndex < carAmount){  //OK, not great
	    //for testing
	    System.out.println("CarIndex: " + carIndex + " carAmount: " + carAmount);
	    //for testing
	    addCarsToStatGarage(r1, s1);
	    addCarsToStatGarage(r2, s2);
	    
	    
	    r1.step();
	    r2.step();
	    //toLastIfFree(r0, garage[carIndex]);

	    //  r0.step();
	    
	    switcher = r0.firstCar();

	    switchLanes(switcher,r1,r2,dest1,dest2);
	    r0.step();

	    //	    r0.toStringLane();
	    toLastIfFree(r0, garage[carIndex]);
	    //	    r0.toStringLane();
	    //System.out.println(garage[carIndex].toStringCar());
	    s1.step();
	    s2.step();
	}
	else{
	    addCarsToStatGarage(r1, s1);
	    addCarsToStatGarage(r2, s2);

	    r1.step();
	    r2.step();
	    //	    r0.step();

	    switcher = r0.getFirst();

	    switchLanes(switcher, r1, r2, dest1, dest2);
	    r0.step();


	    s1.step();
	    s2.step();
	}
    }
    
    public void printStatistics() {
	// Skriv statistiken samlad sa har langt
    }

    
    public void print() {

	System.out.println("Main road: ");
	r0.toStringLane();
	System.out.println("");
	System.out.println("S1: " + s1.toString());
	System.out.println("Is forward green?: " + s1.isGreen());
	System.out.println("Forward: ");
	r1.toStringLane();
	System.out.println("");
	System.out.println("S2: " + s2.toString());
	System.out.println("Is Turn green?: " + s2.isGreen());
	System.out.println("Turn: ");
	r2.toStringLane();
	System.out.println("");
	// Skriv ut en grafisk representation av kosituationen
	// med hjalp av klassernas toString-metoder
    }

}
