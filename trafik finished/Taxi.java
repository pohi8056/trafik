
// TODO: Auto-generated Javadoc
/**
 * The Class Taxi.
 */
public class Taxi extends Car{

    /** The current price of the ride. */
    private int taxiMeter;

    /**
     * Instantiates a new taxi.
     *
     * @param lifetime the lifetime
     * @param destination the destination
     * @param carNr the car nr
     * @param taxiMeter the taxi meter
     */
    public Taxi(int lifetime, CarPosition destination, int carNr, int taxiMeter){

	super(lifetime, destination, carNr);
	this.taxiMeter = taxiMeter;
    }

    
    /**
     * Instantiates a new taxi.
     *
     * @param lifetime the lifetime
     * @param carNr the car nr
     * @param taxiMeter the taxi meter
     */
    public Taxi(int lifetime, int carNr, int taxiMeter){
	super(lifetime, carNr);
	this.taxiMeter = taxiMeter;
	
    }
    

    public void setTaxiMeter(){
	this.taxiMeter = 0;
    }

    /**
     * Sets the minimum fee of the taxi ride.
     *
     * @param startValue the starting value (minimum fee) of the taxi ride.
     */
    public void setTaxiMeter(int startValue){
	this.taxiMeter = startValue;
    }


    /**
     * Gets the current fee.
     *
     * @return the current fee.
     */
    public int getTaxiMeter(){
	return taxiMeter;
    }

    /* 
     * @see Car#step()
     */
    @Override
    public void step(){
	this.lifetime += lifetime;
	this.taxiMeter +=  taxiMeter;
    }


    //

    /*
     * @see Car#toStringCar()
     */
    @Override
    public String toStringCar() {
    	return "Taxi(lifeTime =" + this.lifetime + ", destination = " + this.stringDestination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ", IntPos: " + getIntPosition() +", Waiting time: " + this.waitingTime + " Taximeter: $" + this.taxiMeter + ")";
    	}
	
}
