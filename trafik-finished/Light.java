// TODO: Auto-generated Javadoc
/**
 * The Class Light.
 */
public class Light {
    
    /** The period of the traffic lights. */
    private int period;
    
    /** Internal clock for the traffic lights. */
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    
    /** The amount of time each period which the light is green. */
    private int green; // Signalen gron nar time<green 

    /**
     * Instantiates a new light.
     *
     * @param period the period time
     * @param green the green time
     */
    public Light(int period, int green) {
    	this.period = period;
	this.green = green;
    	}

    /**
     * Increases the time by one.
     */
    public void    step() {
	if(time == period - 1){
	    time = 0;
	}
	else{
	    this.time++;
	}
    }

    /**
     * Checks whether the traffic light is green.
     *
     * @return true, if the traffic light is green
     */
    public boolean isGreen()   {
	if (this.time < this.green) {
	    return true;
	}
	else{
	    return false;
    	// Returnerar true om time<green, annars false
	}
    }


    public String  toString()  {
    	return "Light( period: " + this.period + " time: " + this.time + " green: "+ this.green + ")";
    	}
	
}
