package crownAndAnchorApp;

public class Dice {
	protected int diceFace;
	
	public Dice() {
		throwDice();
	}

	public Dice(int diceFace) {
		this.diceFace = diceFace;
	}


	public void throwDice() {
		double randomNo = Math.random();
		randomNo*=6;
		randomNo++;
		diceFace= (int) randomNo;
	}

	public int getDiceFace() {
		return diceFace;
	}
}
