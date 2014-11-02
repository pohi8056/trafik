import java.util.Random; //imported randomgen


public class Car {
    private int carNr;
    private int lifetime;
    private CarPosition destination; 
    private int intPosition;
    private CarPosition currentPosition;
    
    public void step()
    {
	    lifetime += 1;
	    //}

    	// Uppdatera bilen ett tidssteg

	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//
	//Skall inte bornTime vara constant?
	//Eftersom den anger time of birth
	//Men varför finns då step method?
	//Its probably right, just curious.
	//Not update currentPos?
    }

    


    public Car(int lifetime, CarPosition destination, int carNr){
	//this.destination = destination;
	this.lifetime = lifetime;

	//added carNR
	this.carNr = carNr;
}

    public void setPosition(CarPosition currentPosition){
	this.currentPosition = currentPosition;
}

    public CarPosition getPosition(){
	return currentPosition;
}

    public int getCarNr(){
	return this.carNr;
}

    public boolean randomDestination(){
	Random random = new Random();
	int randomNumber = random.nextInt(2 - 1) + 1;
	
	if(randomNumber == 1){
	    return true;
	}else{
	    return false;
	}
	//randomdest
    }

    public void setDestination(CarPosition destination){
	this.destination = destination;
}

    public CarPosition getDestination(){
	return destination;
}
    
    //*******tempForTest********
    //
    public void setIntPosition(int i){
	this.intPosition = i;
    }
    public int getIntPosition(){
	return intPosition;
    }
    //
    //*******tempForTest********



    public String toString() {
    	return "Car(bornTime =" + this.lifetime +", destination =" + this.destination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ")";
    	}
	
}
