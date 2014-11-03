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

	/*
	Car testCar = new Car(0, destS1, 1);
	System.out.println(testCar.getPosition());
	
	road0.putLast(testCar);
	System.out.println(testCar.getPosition());
	road0.step();
	System.out.println(testCar.getPosition());
	road0.step();
	System.out.println(testCar.getPosition());
	road0.step();
	System.out.println(testCar.getPosition());
	road0.step();
	System.out.println(testCar.getPosition());
	road0.step();

	*/

	

	

	//Lägger in alla bilar i garaget, då de inte är redo för vägen ännu.
	for (int i = 0; i < 10; i++) {
	    garage[i] = new Car(1000 + i,destS1,i);
	}

		
      	//Nu rullar vi!!
	for (int i = 0; i < 10; i++) {
      	    road0.putLast(garage[i]);
	    road0.toStringLane();
	    road0.step();
				
	    //      	    for(int j = 0; j < 10; j++){
		//      		System.out.println("Car: " + garage[j].getCarNr() + "\t Pos: " + garage[j].getPosition() + "\t intPos: " + garage[j].getIntPosition());

      		//road0.step();
      		//System.out.println("Car: " + garage[j].getCarNr() + "\t Pos: " + garage[j].getPosition() + "\t intPos: " + garage[j].getIntPosition());	    
		// road0.toString1();
      		//System.out.print(road0.toString() + "\n");
		//road0.toStringLane();
		//System.out.println(road0.toStringLane());
		//      	    }
    	}

       
	/*Car ferrari = new Car(3,destS1,1337);
	
	car1.set(ferrari);
        System.out.print(ferrari.toString() + "\n");
        System.out.print(road0.toString() + "\n");
        //System.out.print(.toString());




	*/


    Car bil1 = new Car(1,destS1,1);
    Car bil2 = new Car(1,destS1,1);
    Car bil3 = new Car(2,destS1,1);

    boolean one = bil1.isEqual(bil1);
    boolean two = bil1.isEqual(bil2);

    boolean three = bil1.isEqualRef(bil1);
    boolean four = bil1.isEqualRef(bil2);

    //REF
        System.out.println(one);
	
        System.out.println(two);
    	
        //EQUAL
        System.out.println(three);
    
	System.out.println(four);
	      
    }
	
 

}
