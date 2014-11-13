
public class Lane {

    /*  public static class OverflowException extends RuntimeException {

	public OverflowException(String s){
	    super(s);
	}
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
    }
    */

    protected CarPosition[] theLane;
    protected Car temporaryParkingSpot;
    
    public Lane(int n) {
	assert (n > 0) : "Cannot create Lane with negative length.";
	// Konstruerar ett Lane-objekt med plats for n fordon
	// Samt lanker ihop varje CarPosition med forward for den framfor
	theLane = new CarPosition[n];
	for(int i = 0; i < n; i++){
	    theLane[i] = new CarPosition(this);
	    //theLane[i].setPosition(i); //Temp commented, made it harder to think.
	}
	for (int i = (n-1); i > 0; i--) {
	    theLane[i].updateForward(theLane[i-1]);  
	}
    }


    public boolean isEmpty(){
	boolean trueFalse = true;
	for(int i = 0; i < getLength(); i++){
	    if(theLane[i].get() != null){
		trueFalse = false;
		break;
	    }
	}
	return trueFalse;

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
	int len = getLength();
	for (int i = 1; i < len; i++) {
	    temporaryParkingSpot = theLane[0].get();
	    //theLane[0].setNull();         /* WARNING */
	    //theLane[i].getFirst();

	    //System.out.println("IM HERE");
	    if(theLane[i - 1].isThereACar() != true){
		//System.out.println("Number: " + i +"Lane: "+ theLane[i-1].isThereACar());
		if(theLane[i].isThereACar()){   
		    theLane[i].get().setPosition(theLane[i - 1]);
		    theLane[i - 1].set(theLane[i].get());
		    theLane[i].setNull();
		    //
		    //added for test
		    //
		    theLane[i-1].get().setIntPosition(i-1);
		}
	    }
	    else if(theLane[i].isThereACar()){
		theLane[i].get().stepWaitingTime();
	    }
	    //	    theLane[i-1] = theLane[i];	    
	}
    }

    public Car getFirst() {
	if(theLane[0].get() != null){
	    theLane[0].setNull();
	}
	return temporaryParkingSpot;

	// Returnera och tag bort bilen som står först
    }
    
    public Car firstCar() {
    	return temporaryParkingSpot;
	// Returnera bilen som står först utan att ta bort den
    }
    

    public boolean lastFree() {
	if(theLane[getLength() - 1].get() == null){
	    return true;
	}
    	return false;
	// Returnera true om sista platsen ledig, annars false
    }



    public void putLast(Car c) throws OverflowException {
	    if (lastFree()){
		theLane[getLength() - 1].set(c);
		c.setPosition(theLane[getLength() - 1]);
		theLane[getLength() - 1].get().setIntPosition(getLength() - 1);
	    }	    
	    else{
		c.stepWaitingTime();
		throw new OverflowException("Unable to insert new car!");
	    }
    }

    /*   public void putLast(Car c) throws OverflowException {
	try {
	    if (lastFree()){
		theLane[getLength() - 1].set(c);
		c.setPosition(theLane[getLength() - 1]);
		theLane[getLength() - 1].get().setIntPosition(getLength() - 1);
	    }
	    else{
		throw new OverflowException("Unable to insert new car!");
	    }
	}
	catch (OverflowException e) {
	    System.out.println("Error: " + e.getMessage());
	    e.printStackTrace();
	}
    }
    */

    public void toStringLane() {
	for(int i = 0; i < getLength(); i++){
	    if(theLane[i].get() != null){
	    System.out.println("Position " + i + ": \t" + theLane[i].get().toStringCar());
	    }
	    else{
		System.out.println("Position " + i + ": \t <EMPTY>");
	    }
	}
    }
}

