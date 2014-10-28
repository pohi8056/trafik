

//
// Håller i en bil och känner till sina "grannar". 
public class CarPosition{
	
<<<<<<< HEAD
	private Car currentCar = null; // null om ingen bil finns på positionen
	
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
=======
    private Car currentCar = null; // null om ingen bil finns p� positionen
	
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
>>>>>>> 5f99a3f2ba6354dddfb076c4e453ddb1fefb3801

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

    public void updateForward(CarPosition newForward) {
	this.forward = newForward;
    }	
}
