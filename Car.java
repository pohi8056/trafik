

public class Car {
    private int carNr;
    private int bornTime;
    private CarPosition destination; 
    private int position;
    private CarPosition currentPosition;
    
    public void step()
    {
	bornTime += 1;
    	// Uppdatera bilen ett tidssteg

	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//
	//Skall inte bornTime vara constant?
	//Eftersom den anger time of birth
	//Men varför finns då step method?
	//Its probably right, just curious.
	//Not update currentPos?
    }

    


    public Car(int bornTime, CarPosition destination, int carNr){
	this.destination = destination;
	this.bornTime = bornTime;

	//added carNR
	this.carNr = carNr;
}

    public void setPosition(CarPosition currentPosition){
	this.currentPosition = currentPosition;
}

    public CarPosition getPosition(){
	return currentPosition;
}

    public void setDestination(CarPosition destination){
	this.destination = destination;
}

    public CarPosition getDestination(){
	return destination;
}


    public String toString() {
    	return "Car(bornTime =" + this.bornTime +", destination =" + this.destination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ")";
    	}
	
}
