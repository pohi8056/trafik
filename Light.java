public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen gron nar time<green 

    public Light(int period, int green) {
    	this.period = period;
	this.green = green;
    	}

    public void    step() {
	if(time == period - 1){
	    time = 0;
	}
	else{
	    this.time++;
	}
    }

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
    	return "Light(period=" + this.period + " time:" + this.time + "green:"+ this.green + ")";
    	}
	
}
