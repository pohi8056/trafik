//file used temporarlly for testing methods

public class tempTest{

    
    public static void main(String[] args) {
	
	System.out.print("Lets test!\n");


	

	// C                   B                                     A
	// s1<-0-1-2-road1----n<-0-1-2------road0-------------------n<
	// s2<-0-1-2-road2----n< 
	
	
	Lane road0 = new Lane(10);
	Lane road1 = new Lane(5);
	Lane road2 = new Lane(5);
	
	CarPosition start = new CarPosition(road0);
	CarPosition destS1 = new CarPosition(road1);
	CarPosition destS2 = new CarPosition(road2);

	CarPosition car1 = new CarPosition(road0);


	//Ett garage med 10 bilar, för det bör man ha.
       	Car[] garage = new Car[15];

	//Lägger in alla bilar i garaget, då de inte är redo för vägen ännu.
	for (int i = 0; i < 10; i++) {
	    garage[i] = new Car(1000 + i,destS1,i);
	}

		
      	//Nu rullar vi!!
	for (int i = 0; i < 10; i++) {
      	    road0.putLast(garage[i]);
	    road0.toStringLane();
	    road0.step();
	    if(road0.firstCar() != null){
		road1.putLast(road0.getFirst());
		road1.step();
	    }

	}
	    
    	
		  
    }
	
 

}
