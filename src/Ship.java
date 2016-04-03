import java.util.*;

public class Ship {

	int size;
	int hitsTaken;
	int [] startPos;
	
	Ship(int startX, int startY, int size){
		startPos = new int[]{startY, startX};
		this.size = size;
		this.hitsTaken = 0;
	}
	
	public void check(int x, int y){

	}
}
