
// Holler i en bil och kqnner till sina "grannar". 
public class CarPosition{
    //Added Position
    private int position;
    private Car currentCar = null; // null om ingen bil finns pq positionen
	
    private Lane owner;
	
    private CarPosition forward;
    private CarPosition turn;
	
    public CarPosition(Lane a_Owner)
    {

	owner = a_Owner;
    }



	
    public boolean isEnd(CarPosition target)
    {
	return owner.matchEnd(target);
    }
	
    public boolean moveForward()
    {
	
	return false;
	// Flytta bilen fram till forward
    }
	
    public boolean turn()
    {
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
