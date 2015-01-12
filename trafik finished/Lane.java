
// TODO: Auto-generated Javadoc
/**
 * The Class Lane.
 */
public class Lane {

    /*  public static class OverflowException extends RuntimeException {

	public OverflowException(String s){
	    super(s);
	}
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
    }
    */

    /** The lane. */
    protected CarPosition[] theLane;
    
    /** Temporary parking spot for cars who have reached there destination, used for statistics. */
    protected Car temporaryParkingSpot;
    
    /**
     * Instantiates a new lane.
     *
     * @param n the number of CarPositions fitting in the lane.
     */
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




    /**
     * Checks if the lane is empty.
     *
     * @return true, if the lane is empty
     */
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
    
    /**
     * Checks whether the CarPosition target is at the end of the lane.
     *
     * @param target the target CarPosition
     * @return true, if target is at the end of the lane
     */
    public boolean matchEnd(CarPosition target)
    {
    	if(theLane[0] == target)
	    return true;
    	else
	    return false;
    }
    
    /**
     * Gets the length of the lane.
     *
     * @return the length
     */
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

    /**
     * Steps all cars in the lane one step forward if possible (except the one at position 0).
     * The car at position 0 gets added to the temporaryPartingSpot to be used for statistics. 
     */
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

    /**
     * Returns and removes the first car in the lane.
     *
     * @return the first car.
     */
    public Car getFirst() {
	if(theLane[0].get() != null){
	    theLane[0].setNull();
	}
	return temporaryParkingSpot;

	// Returnera och tag bort bilen som står först
    }
    
    /**
     * Returns the first car in the lane without removing it.
     *
     * @return the first car
     */
    public Car firstCar() {
    	return temporaryParkingSpot;
	// Returnera bilen som står först utan att ta bort den
    }
    

    /**
     * Checks whether or not the last CarPosition in the lane is free, i.e there's no car there.
     *
     * @return true, if the last CarPosition is free.
     */
    public boolean lastFree() {
	if(theLane[getLength() - 1].get() == null){
	    return true;
	}
    	return false;
	// Returnera true om sista platsen ledig, annars false
    }



    /**
     * Puts the car c at the last CarPosition in the lane if it's free, otherwise throws an exception.
     *
     * @param c the car
     * @throws OverflowException Overflow exception if the last CarPosition is occupied.
     */
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


    /**
     * Prints data about the lane.
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
