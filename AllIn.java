package crownAndAnchorApp;

import java.text.NumberFormat;

public class AllIn extends Bet {

	public AllIn(String whatOn, int amount) {
		super('A', whatOn, amount);
		if (amount < 3) {
			throw new IllegalArgumentException("The minimum bet amount for an all in bet is £3.");
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
			case 3:
				winnings = 10 * amount;
				break;
			default:
				winnings=0;
				break;
			}
			return winnings;
	}

}
