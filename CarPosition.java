
// Holler i en bil och kqnner till sina "grannar". 
public class CarPosition{
    //Added Position
    private int position;
    private Car currentCar = null; // null om ingen bil finns pq positionen
		
    private CarPosition forward;
    private CarPosition turn;


    private Lane owner;
	
    public CarPosition(Lane owner)
    {

	this.owner = owner;

    }


    public boolean isEnd(CarPosition target)
    {
	return owner.matchEnd(target);
    }
	
    public boolean moveForward()
    {
	if(currentCar.getDestination() == forward && owner.matchEnd(this) == true){
	    return true;
	}
	return false;
	// Flytta bilen fram till forward
    }
	
    public boolean turn()
    {
	if(currentCar.getDestination() == turn && owner.matchEnd(this) == true){
	    return true;
	}
	return false;
	// Flytta bilen till turn
    }

    public Car get(){
	return currentCar;
	//GET CAR

    }

    public void setTurn(CarPosition turn) {
	this.turn = turn;
    }

    public CarPosition getTurn() {
	return turn;
    }
    //Added getForward
    public CarPosition getForward() {
	return forward;
    }
    //Added updateForward
    public void updateForward(CarPosition newForward) {
	this.forward = newForward;
    }	

    public boolean isThereACar(){
	if(this.get() == null){
	    return false;
	}
	else{
	    return true;
	}
    }
    
    public void set(Car c){
	currentCar = c;
    }

    public void setNull(){
	this.currentCar = null;
}

    /*

      Do we really need these two?

     */


    //added getPos
    public int getPosition(){
	return position;
    }


    //added setPos
    public void setPosition(int pos){
	position = pos;
    }
}
