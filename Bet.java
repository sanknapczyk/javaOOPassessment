package crownAndAnchorApp;

import java.util.Arrays;

public abstract class Bet {
	protected char typeOfBet;
	protected String whatOn;
	protected int amount;

	public Bet(char typeOfBet, String whatOn, int amount) {
		this.typeOfBet = typeOfBet;
		this.whatOn = whatOn;
		this.amount = amount;
	}
	//checking if dice matches the bet
	protected int checkMatches(CADice[] dices) {
	    int matches = (int) Arrays.stream(dices)
	                        .filter(dice -> dice.getDiceSymbol().equalsIgnoreCase(whatOn))
	                        .count();
	    return matches;
	}
	
	public abstract String displayBet();
	
	public abstract int workOutWinnings(CADice[] dices);
	
	public char getTypeOfBet() {
		return typeOfBet;
	}

	public String getWhatOn() {
		return whatOn;
	}

	public int getAmount() {
		return amount;
	}


}
