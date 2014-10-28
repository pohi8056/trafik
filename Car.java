

public class Car {

    private int bornTime;
    private CarPosition destination; 

    private CarPosition currentPosition;
    
    public void step()
    {
	bornTime += 1;
    	// Uppdatera bilen ett tidssteg
    }

    


    public Car(int bornTime, CarPosition destination){
	this.destination = destination;
	this.bornTime = borntime;
}

    public CarPosition setPosition(CarPosition currentPosition){
	this.currentPosition = currentPosition;
}

    public CarPosition getPosition(){
	return currentPosition;
}

    public CarPosition setDestination(CarPosition destination){
	this.destination = destination;
}

    public CarPosition getDestination(){
	return destination;
}


    public String toString() {
    	return "Car(bornTime =" + this.bornTime +", destination =" + this.destination + ", currentPosition =" + this.currentPosition + ")";
    	}
	
}
