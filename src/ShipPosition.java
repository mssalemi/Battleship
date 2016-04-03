import java.util.*;

public class ShipPosition {

	final String [] boardItem = {"~","X","S"};
	
	int xCord;
	int yCord;
	boolean hit;
	boolean ship;
	String shipID;
	
	ShipPosition(int x, int y, boolean tf){
		xCord = x;
		yCord = y;
		hit = false;
		shipID = Integer.toString(x) + Integer.toString(y);
		ship = tf;
	}
	
	public String toString(){
		if (!hit){
			return boardItem[0];
		} else if (ship){
			return boardItem[2];
		}
		return boardItem[1];
	}
	
	public void toShip(){
		ship = true;
	}
	
	public void hitSpot(){
		hit = true;
	}
	
}
