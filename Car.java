import java.util.Random; //imported randomgen


public class Car {
    private int carNr;
    private int lifetime;
    private CarPosition destination; 
    private int intPosition;
    private CarPosition currentPosition;
    private boolean routeFinished = false;
    
    public void step()
    {
	    this.lifetime = lifetime + 1;

    }


   

    public Car(int lifetime, CarPosition destination, int carNr){
	this.destination = destination;
	this.lifetime = lifetime;

	//added carNR
	this.carNr = carNr;
    }


    public Car(int lifetime, int carNr){
	this.lifetime = lifetime;
	this.carNr = carNr;
	
    }


    public void setFinished(){
	this.routeFinished = true;
    }



    public boolean isFinished(){
	return routeFinished;
    }

    public void randomDestination(CarPosition s1, CarPosition s2){
	Random random = new Random();
	int randomNumber = random.nextInt(1 - 0 + 1) + 1;
	
	if(randomNumber == 1){
	    this.setDestination(s1);
	}else{
	    this.setDestination(s2);
	}
	//randomdest
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

    public void setDestination(CarPosition destination){
	this.destination = destination;
    }
    
    public CarPosition getDestination(){
	return this.destination;
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



    public String toStringCar() {
    	return "Car" + "(bornTime =" + this.lifetime +", destination =" + this.destination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ", IntPos: " + getIntPosition() +")";
    	}
	




}
