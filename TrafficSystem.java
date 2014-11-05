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
    Car switcher;


    // Diverse attribut for simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    private CarPosition dest1;
    private CarPosition dest2;

    // Diverse attribut for statistiksamling
    //....    
    
    private int time = 0;
    private int carNr = 0;
    private int carIndex = 0;
    


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


    public void initCars(int carAmount){
	
	garage = new Car[carAmount];
	for(int i = 0; i < carAmount; i++){
	    garage[i] = new Car(time, 1000 + i);
	    garage[i].randomDestination(dest1, dest2);
	}
    }
    

    public boolean checkLanesNull(){

	if(r0.isEmpty() && r1.isEmpty() && r2.isEmpty() == true){
	    return true;
	}else {
	    return false;
	}
    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lagg in och ta ur pa de olika Lane-kompenenterna
	
	r0.putLast(garage[carIndex++]);
	switcher = r0.getFirst();
	if(switcher != null){
	    if(switcher.getDestination() == dest1){
		r1.putLast(switcher);
	    }else{
		r2.putLast(switcher);
	    }
	}
	

	s1.step();
	s2.step();
	r0.step();
	r1.step();
	r2.step();
    }

    public void printStatistics() {
	// Skriv statistiken samlad sa har langt
    }

    public void print() {

	System.out.println("Main road: ");
	r0.toStringLane();
	System.out.println("Forward: ");
	r1.toStringLane();
	System.out.println("");
	System.out.println("Turn: ");
	r2.toStringLane();
	System.out.println("");
	// Skriv ut en grafisk representation av kosituationen
	// med hjalp av klassernas toString-metoder
    }

}
