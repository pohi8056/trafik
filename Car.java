import java.util.Random; //imported randomgen
 

public class Car {
    private int carNr;
    private int lifetime;
    private CarPosition destination; 
    private int intPosition;
    private CarPosition currentPosition;
    private int waitingTime = 0;
    private boolean routeFinished = false;
    private String stringDestination;

    public void step()
    {
	    lifetime += 1;
	    //}

    }
    
    public void stepWaitingTime()
    {
	    waitingTime += 1; 
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
	    this.stringDestination = "Forward";
	}else{
	    this.setDestination(s2);
	    this.stringDestination = "Turn";
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
    public int getWaitingTime(){
	return waitingTime;
    }


    public String toStringCar() {
    	return "Car(lifeTime =" + this.lifetime + ", destination = " + this.stringDestination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ", IntPos: " + getIntPosition() +", Waiting time: " + this.waitingTime + ")";
    	}
	




}
