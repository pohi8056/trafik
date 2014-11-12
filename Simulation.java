import java.util.Scanner;

/*
=======
 /*
  Modell för trafiksimulering
  ===========================

  Foljande klasser skall anvandas: 

     Car representerar fordon
         ankomsttid och destination som satts nar objektet skapas

     Light representerar ljussignaler
         Se nedan
  
     Lane representerar ett vagavsnitt
         En vag representeras av en array dar varje element
	 antingen ar tomt eller innehaller en referens till 
         ett bil-objekt.
         OBS: Klassen Lane paminner om komekanismen i foregaende
         uppgift men den skiljer sig ocksa i flera avseende.
         I denna klass stalls nya bilar i ena anden av ARRAYEN
         och inte narmast efter den som finns dar. I komekanismen        
         var alltid elementen (kunderna) samlade medan bilarna
         i denna klass kan vara utspridda over hela arrayen.

     TrafficSystem
         Definierar de komponeneter dvs de vagar och signaler
	 som ingar i systemet. Se vidare nedan

     Simulation
         main-metod som driver simuleringen


  Den situation som skall simuleras ser schematiskt ut enligt



         C           B                               A
       s1<----r1-----<---------r0---------------------
       s2<----r2-----< 


  En fil (vagstracka) r0 delar sig vid B i två filer r1 och r2.
  Signal s1 kontrollerar fil r1 och och signal s2 fil r2.
 
  Bilar uppstar vid A. Sannolikheten att en bil skall komma till A
  vid ett visst tidsteg kallas ankomstintensiteten.

  Vid ett tidssteg ror sig bilarna ett steg framat (om platsen framfor
  ar ledig). Vid C tas bilarna ut från filerna om repektive
  signal ar gron. Vid B tas bilar ut från r0 och laggs in på r1 eller r2
  beroende på destination (och om platsen ar ledig).

  Anm: Man skulle kunna representera systemet med tva Lane-objekt
  men da måste man ha nagot satt att representera en "avtappning"
  (dar svangfilen borjar). Med den har valda representationen
  blir Lane-klassen enklare.  
    
*/





public class Simulation {

    public static int[] menu(){
	Scanner scan = new Scanner(System.in);
	System.out.println("Welcome to Kerbal Traffic Program.");
	System.out.println("");
	

	    System.out.println("Maximum amount of cars that fits on the main road: ");
	    int mainLength = scan.nextInt();
	    System.out.println("Maximum amount of cars that fits on the turning lane: ");
	    int turnLength = scan.nextInt();
	    if(mainLength > turnLength){
		mainLength = mainLength - turnLength;
		
	    }else{
		while(mainLength < turnLength){
		    System.out.println("Turn lane can't be longer than the main road.");
		    System.out.println("Maximum amount of cars that fits on the turning lane: ");
		    turnLength = scan.nextInt();
		}
	    }
	    System.out.println("Red light period for cars crossing the intersection.");
	    int forwardRed = scan.nextInt();
	    System.out.println("Green light period for cars crossing the intersection.");
	    int forwardGreen = scan.nextInt();
	    System.out.println("Red light period for cars turning in the intersection.");
	    
	    int forwardPeriod = forwardRed + forwardGreen;

	    int turnRed = scan.nextInt();
	    System.out.println("Green light period for cars turning in the intersection");
	    int turnGreen = scan.nextInt();

	    int turnPeriod = forwardRed + forwardGreen;

	    //  System.out.println("Car intensity. [1 = Night time, 2 = Normal, 3 = Rush hour.]");
	    //int intensity = scan.nextInt();
	    System.out.println("Amount of cars to be simulated: ");
	    int carAmount = scan.nextInt();
	    
	    int[] inputData = new int[]{mainLength, turnLength, forwardPeriod, forwardGreen, turnPeriod, turnGreen, carAmount};
	    
	    return inputData;

    }
    
    
    public static void main(String [] args) {
	try {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	} catch (Exception e) {
	    Thread.currentThread().interrupt();
	}
	int[] data = menu();


	TrafficSystem system = new TrafficSystem(data[0], data[1], data[2], data[3], data[4], data[5]); //INTENSITY NOT ADDED
	system.initCars(data[6]);
	
	//TrafficSystem system = new TrafficSystem(10, 5, 5, 1);
	
	
	try{
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	    System.out.println("[Settings] \nMain road length: " + data[0] + "\nTurn lane length: " + data[1] + "\nForward light period: " + data[2] + "\nForward green time: " + data[3] + "\nTurning light period: " + data[4] + "\nTurning green time: " + data[5] + "\nAmount of cars: " + data[6]);
	    System.out.println("");
	    System.out.println("Simulation starts in: ");
	    Thread.sleep(1500);
	    System.out.println("3...");
	    Thread.sleep(1500);
	    System.out.println("2...");
	    Thread.sleep(1500);
	    System.out.println("1...");
	    Thread.sleep(1500);
	} catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	//	system.initCars(20);
		    
	while(system.checkLanesNull() != true){
	    try {
		Thread.sleep(1500); 
		System.out.print("\033[H\033[2J");
		System.out.flush();
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }   
	    system.print();
	    system.step();

	}
	system.print();

	system.printStatistics();
	
	system.printHighestWaitingTimes();
    }
}
