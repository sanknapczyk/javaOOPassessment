package crownAndAnchorApp;

import java.util.List;
import java.util.Arrays;

public class CADice extends Dice {
	// Constructor - invokes the superclass constructor
	public CADice() {
		super();
	}

	public CADice(int i) {
		// TODO Auto-generated constructor stub
	}


	// Method to get the symbol associated with a particular dice face
	public String getDiceSymbol() {
		// Create a list of the six possible symbols
		List<String> myList = Arrays.asList("crown", "anchor", "diamond", "spade", "club", "heart");
		// Return the symbol associated with the current dice face
		return myList.get(diceFace-1);
	}
}



