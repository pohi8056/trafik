 
// TODO: Auto-generated Javadoc
// Holler i en bil och kqnner till sina "grannar". 
/**
 * The Class CarPosition.
 */
public class CarPosition{
    //Added Position
    /** The position. */
    private int position;
    
    /** The current car at the CarPosition. */
    private Car currentCar = null; // null om ingen bil finns pq positionen
		
    /** Destination forward. */
    private CarPosition forward;
    
    /** Destination turn */
    private  CarPosition turn;

    /** The lane which the CarPosition belongs to */
    private Lane owner;
	
    /**
     * Instantiates a new car position.
     *
     * @param owner the lane which the CarPosition belongs to.
     */
    public CarPosition(final Lane owner)
    {
	this.owner = owner;
    }

    /**
     * Checks if the CarPosition is at the end of a Lane.
     *
     * @param target the target
     * @return true, if is end
     */
    public boolean isEnd(CarPosition target)
    {
	return owner.matchEnd(target);
    }
    
    /**
     * Moves the current car forward if the destination is to move forward and it's the end of the main lane..
     *
     * @return true, if the current car has the destination forward and is at the end of the main lane
     */
    public boolean moveForward()
    {
    	if(currentCar.getDestination() == forward && owner.matchEnd(this) == true){
    		return true;
    	}		
    	return false;
    }


	
    /**
     * Moves the current car to the turning lane if the destination is to turn and it's the end of the main lane.
     *
     * @return true, if the current car has the destination turn and is at the end of the main lane
     */
    public boolean turn()
    {
	if(currentCar.getDestination() == turn && owner.matchEnd(this) == true){
	    return true;
	}
	return false;
	// Flytta bilen till turn
    }

    /**
     * Gets the current car at the CarPosition.
     *
     * @return the current car
     */
    public Car get(){
	return currentCar;
	//GET CAR

    }

    /**
     * Updates CarPosition to turn.
     *
     * @param turn the turn destination
     */
    public void setTurn(CarPosition turn) {
	this.turn = turn;
    }

    /**
     * Gets the CarPosition turn.
     *
     * @return turn	
     */
    public CarPosition getTurn() {
	return turn;
    }
    /**
     * Gets the CarPosition forward.
     *
     * @return forward
     */
    public CarPosition getForward() {
	return forward;
    }
    //Added updateForward
    /**
     * Updates CarPosition to forward.
     *
     * @param newForward the new forward destination
     */
    public void updateForward(CarPosition newForward) {
	this.forward = newForward;
    }	

    /**
     * Checks if there's a car at the current CarPosition.
     *
     * @return true, if there's a car
     */
    public boolean isThereACar(){
	if(this.get() == null){
	    return false;
	}
	else{
	    return true;
	}
    }
    
    /**
     * Sets the current car at the CarPosition to c.
     *
     * @param c the car
     */
    public void set(Car c){
	currentCar = c;
    }

    /**
     * Sets the current car at the CarPosition to null.
     */
    public void setNull(){
	this.currentCar = null;
    }

 

    //added getPos
    /**
     * Gets the CarPositions' position.
     *
     * @return the position
     */
    public int getPosition(){
	return position;
    }

    //added setPos
    /**
     * Sets the CarPositions' position.
     *
     * @param pos the new position
     */
    public void setPosition(int pos){
	position = pos;
    }
}
