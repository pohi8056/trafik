
public class Taxi extends Car{

    private int taxiMeter;

    public Taxi(int lifetime, CarPosition destination, int carNr, int taxiMeter){

	super(lifetime, destination, carNr);
	this.taxiMeter = taxiMeter;
    }

    
    public Taxi(int lifetime, int carNr, int taxiMeter){
	super(lifetime, carNr);
	this.taxiMeter = taxiMeter;
	
    }
    

    public void setTaxiMeter(){
	this.taxiMeter = 0;
    }

    public void setTaxiMeter(int startValue){
	this.taxiMeter = startValue;
    }


    public int getTaxiMeter(){
	return taxiMeter;
    }

    @Override
    public void step(){
	this.lifetime += lifetime;
	this.taxiMeter +=  taxiMeter;
    }


    //

    @Override
    public String toStringCar() {
    	return "Taxi(lifeTime =" + this.lifetime + ", destination = " + this.stringDestination + ", currentPosition =" + this.currentPosition + ", carNr:" + this.carNr + ", IntPos: " + getIntPosition() +", Waiting time: " + this.waitingTime + " Taximeter: $" + this.taxiMeter + ")";
    	}
	
}
