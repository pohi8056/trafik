import java.util.Random; //imported randomgen



/**
 * The Class Car.
 */
public class Car implements java.lang.Cloneable{
    
    /** The car number. */
    protected int carNr;
    
    /** The lifetime of the car. */
    protected int lifetime;
    
    /** The destination of the car (Forward or turn). */
    protected CarPosition destination; 
    
    /** The integer position of the car, used for printing purposes. */
    protected int intPosition;
    
    /** The current position. */
    protected CarPosition currentPosition;
    
    /** The amount of time the car has been waiting at traffic lights or due to queues. */
    protected int waitingTime = 0;
    
    /** Boolean to be set to true when the car has reached its destination. */
    protected boolean routeFinished = false;
    
    /** String destination, used for printing purposes. */
    protected String stringDestination;

    /**
     * Steps lifetime of car, i.e amount of time the car has been in the simulation.
     */
    public void step()
    {
	    lifetime += 1;
	  

    }
    
    /**
     * Steps the waiting time, i.e the amount of time the car has been waiting for traffic lights or due to queues.
     */
    public void stepWaitingTime()
    {
	    waitingTime += 1; 
    }
    
    /**
     * Instantiates a new car.
     *
     * @param lifetime the lifetime
     * @param destination the destination
     * @param carNr the car nr
     */
    public Car(int lifetime, CarPosition destination, int carNr){
	this.destination = destination;
	this.lifetime = lifetime;

	//added carNR
	this.carNr = carNr;
    }


    /**
     * Instantiates a new car.
     *
     * @param lifetime the lifetime
     * @param carNr the car number
     */
    public Car(int lifetime, int carNr){
	this.lifetime = lifetime;
	this.carNr = carNr;
	
    }

    @Override
    public Car clone() throws CloneNotSupportedException{
	return (Car) super.clone();

    }


    

    /**
     * Sets a car to finished.
     */
    public void setFinished(){
	this.routeFinished = true;
    }



    /**
     * Checks if a car has been set to finished, i.e is finished with the simulation.
     *
     * @return true, if finished
     */
    public boolean isFinished(){
	return routeFinished;
    }

    /**
     * Generates a random destination for the car to reach.
     *
     * @param s1 forward
     * @param s2 turn
     */
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
    }



    /**
     * Sets the position of the car.
     *
     * @param currentPosition The position
     */
    public void setPosition(CarPosition currentPosition){
	this.currentPosition = currentPosition;
    }

    /**
     * Gets the position of the car.
     *
     * @return The position
     */
    public CarPosition getPosition(){
	return currentPosition;
    }

    /**
     * Gets the car number.
     *
     * @return the car number
     */
    public int getCarNr(){
	return this.carNr;
    }

    /**
     * Sets the destination of the car to be reached.
     *
     * @param destination the new destination
     */
    public void setDestination(CarPosition destination){
	this.destination = destination;
    }
    
    /**
     * Gets the car destination.
     *
     * @return the destination
     */
    public CarPosition getDestination(){
	return this.destination;
}

    /**
     * Sets the integer position of the car.
     *
     * @param i the new integer position
     */
    public void setIntPosition(int i){
	this.intPosition = i;
    }
    
    /**
     * Gets the position of the car in integer format to be used for printing purposes.
     *
     * @return the int position
     */
    public int getIntPosition(){
	return intPosition;
    }

    /**
     * Gets the waiting time of the car.
     *
     * @return the waiting time
     */
    public int getWaitingTime(){
	return waitingTime;
    }


    /**
     * Prints data about the car.
     *
     * @return the string
     */
    public String toStringCar() {
    	return "Car(lifeTime =" + this.lifetime + ", destination = " + this.stringDestination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ", IntPos: " + getIntPosition() +", Waiting time: " + this.waitingTime + ")";
    	}
	




}
