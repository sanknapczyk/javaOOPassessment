package crownAndAnchorApp;

import java.text.NumberFormat;

public class Ordinary extends Bet {

	public Ordinary(String whatOn, int amount) {
		super('O', whatOn, amount);
		if (amount < 1) {
			throw new IllegalArgumentException("The minimum bet amount for a ordinary bet is £1.");
		}
	}

	@Override
	public String displayBet() {
		return "Bet type: " + typeOfBet + ", bet amount: " + NumberFormat.getCurrencyInstance().format(amount) + ", bet on: " + whatOn;
	}

	@Override
	public int workOutWinnings(CADice[] dices) {
		int winnings;
		switch (checkMatches(dices)) {
		case 1:
			winnings = 2 * amount;
			break;
		case 2:
			winnings = 3 * amount;
			break;
		case 3:
			winnings = 4 * amount;
			break;
		default:
			winnings=0;
			break;
		}
		return winnings;

	}
}

