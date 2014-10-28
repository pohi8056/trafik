
public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
    }

    protected CarPosition[] theLane;

    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats for n fordon
    // Samt lanker ihop varje CarPosition med forward for den framfor
	theLane = new CarPosition[n];
	for(int i = 0; i < n; i++){
	    theLane[i] = new CarPosition(this);
	    theLane[i].setPosition(i);
	}
	for (int i = (n-1); i > 0; i--) {
	    theLane[i].updateForward(theLane[i-1]);  
	}
    }
    
    public boolean matchEnd(CarPosition target)
    {
    	if(theLane[0] == target)
	    return true;
    	else
	    return false;
    }
    
    public int getLength(){
    	return theLane.length;
    }
    
    public void setParallel(Lane sideLane)
    {
    	int i = 0;
        
    	while(i < sideLane.getLength() && i < theLane.length)
	    {
	    theLane[i].setTurn(sideLane.theLane[i]);
	    i++;
    	}
    }

    public void step() {
	// Stega fram alla fordon (utom det pa plats 0) ett steg 
	// (om det gar). (Fordonet pa plats 0 tas bort utifran 
	// mm h a metoden nedan.)

// TODO: SAVE CAR!!!!
	//theLane[0].getFirst();
	int len = getLength();
	for (int i = 1; i < len; i++) {
	    theLane[i-1] = theLane[i];	    
	}
    }

    public Car getFirst() {

	if(theLane[0] != null){
	    theLane[0] = null;
	}
    	return theLane[0].get();
	// Returnera och tag bort bilen som står först
    }
    
    public Car firstCar() {
    	return theLane[0].get();
	// Returnera bilen som står först utan att ta bort den
    }
    

    public boolean lastFree() {
	if(theLane[getLength() - 1] != null){
	    return true;
	}
    	return false;
	// Returnera true om sista platsen ledig, annars false
    }



    public void putLast(Car c) throws OverflowException {
	if(lastFree() == true){
	    theLane[getLength() - 1].set(c);
	}

	// Stall en bil pa sista platsen pa vagen
	// (om det gar).
    }

    public String toString() {
    	return "Lane(" + this.theLane + ")";
    	//...
    	}

}


