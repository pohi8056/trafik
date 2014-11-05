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
	Car switcher;

	//Lägger in alla bilar i garaget, då de inte är redo för vägen ännu.
	for (int i = 0; i < 15; i++) {
	    garage[i] = new Car(1000 + i,destS1,i); //Default destination doesn't work
	}

	//USE RANDOM GEN LATER
	garage[0].randomDestination(destS1, destS2);
	garage[1].randomDestination(destS1, destS2);
	garage[2].randomDestination(destS1, destS2);
	garage[3].randomDestination(destS1, destS2);
	garage[4].randomDestination(destS1, destS2);
	garage[5].randomDestination(destS1, destS2);
	garage[6].randomDestination(destS1, destS2);
	garage[7].randomDestination(destS1, destS2);
	garage[8].randomDestination(destS1, destS2);
	garage[9].randomDestination(destS1, destS2);
	garage[10].randomDestination(destS1, destS2);
	garage[11].randomDestination(destS1, destS2);
	garage[12].randomDestination(destS1, destS2);
	garage[13].randomDestination(destS1, destS2);
	garage[14].randomDestination(destS1, destS2);

      	//Nu rullar vi!!
	for (int i = 0; i < 15; i++) {
      	    road0.putLast(garage[i]);
	    System.out.println("Main road: ");
	    road0.toStringLane();
	    System.out.println("");
	    switcher = road0.getFirst();
	    if(switcher != null){
		if(switcher.getDestination() == destS1){
		    road1.putLast(switcher);
		}else{
		    road2.putLast(switcher);
		}
	    }
	    
	    System.out.println("Forward: ");
	    road1.toStringLane();
	    System.out.println("");
	    System.out.println("Turn: ");
	    road2.toStringLane();
	    System.out.println("");
	    road1.getFirst();  //PUT IN STATISTIC GARAGE LATER FOR EVALUATION
	    road2.getFirst();  //PUT IN STATISTIC GARAGE LATER FOR EVALUATION
	    
	    road0.step();
	    road1.step();
	    road2.step();
    	}

       
	/*Car ferrari = new Car(3,destS1,1337);
	
	car1.set(ferrari);
        System.out.print(ferrari.toString() + "\n");
        System.out.print(road0.toString() + "\n");
        //System.out.print(.toString());




	*/



		  
    }
	
 

}
