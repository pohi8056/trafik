

public class Car {

    private int bornTime;
    private CarPosition destination; 

    private CarPosition currentPosition;
    
    public void step()
    {
    	// Uppdatera bilen ett tidssteg
    }

    //lol


    public Car(int bornTime, CarPosition destination){
	this.destination = destination;
	this.bornTime = borntime;
	//Not Changed, bitcha.
	//Changed, bitchy.
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
    	return "";
    	}
	
}
