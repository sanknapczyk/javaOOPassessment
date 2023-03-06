package crownAndAnchorApp;

import java.text.NumberFormat;

public class DoubleOrNothing extends Bet {

	public DoubleOrNothing(String whatOn, int amount) {
		super('D',whatOn, amount);
		if (amount < 2) {
			throw new IllegalArgumentException("The minimum bet amount for a double or nothing bet is £2.");
		}
	}

	@Override
	public String displayBet() {
		return "Bet type: " + typeOfBet + ", bet amount: " + NumberFormat.getCurrencyInstance().format(amount) + ", bet on: " + whatOn;
	}

	@Override
	public int workOutWinnings(CADice[] dices) {
		int winnings=(checkMatches(dices)>1)? 5*amount : 0;
		return winnings;
	}

}
