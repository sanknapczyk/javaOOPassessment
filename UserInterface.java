package crownAndAnchorApp;

import java.util.Scanner;

public class UserInterface {
	private static Scanner myScanner;


	public UserInterface(){
		myScanner = new Scanner(System.in);
	}

	//get player's name
	public String getName(){
		String name = "";
		System.out.println("Enter your name");
		while (!myScanner.hasNext()) {
			System.out.println("That's not a valid name");
			myScanner.next();
		}
		name = myScanner.next().toUpperCase().toString();
		return name;
	}

	public String getString(String type) {
		String temp="";
		boolean valid = false;
		while(!valid) {
			System.out.println(type + ": ");
			temp = myScanner.nextLine();
			if(temp != null && !temp.trim().isEmpty())
				valid = true;
		}
		return temp;
	}

	public char getYesNo(String prompt) {
		return getString(prompt).toLowerCase().charAt(0);

	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	//get player's stake
	public int getPlayerStake() {
		int stake = 0;
		boolean valid;

		do {
			valid = true;
			displayMessage("Please enter your stake. Minimum amount is 3:");

			if (myScanner.hasNextInt()) {
				stake = myScanner.nextInt();
				myScanner.nextLine();

				if (stake < 3) {
					displayMessage("Amount is too low, try again: ");
					valid = false;
				}
			} else {
				displayMessage("Input not recognized. Try again.");
				valid = false;
				myScanner.next();
			}
		} while (!valid);

		return stake;
	}

	public char getBetType() {
	    while (true) {
	        displayMessage("Please choose which type of bet you'd like to make:");
	        displayMessage("1: Ordinary\n2: Double or Nothing\n3: All In");

	        String input = myScanner.nextLine();

	        if (input.length() == 1 && "123".contains(input)) {
	            return Character.toLowerCase(input.charAt(0));
	        } else {
	            displayMessage("That is not a valid choice! Try again.");
	        }
	    }
	}
	
	public String getWhatOn() {

		String whatOn = null;
		int selection;

		do {
			displayMessage("Please pick which suit you'd like to bet on: ");
			displayMessage("---------");
			displayMessage("1: Crown");
			displayMessage("2: Anchor");
			displayMessage("3: Heart");
			displayMessage("4: Club");
			displayMessage("5: Spade");
			displayMessage("6: Diamond");

			while (!myScanner.hasNext("[1-6]")) {
				System.out.println("That's not a correct value! Try again: ");
				myScanner.next();
			}
			selection = myScanner.next().toLowerCase().charAt(0);
		} while (false);

		switch (selection) {
		case '1':
			whatOn = "Crown";
			break;
		case '2':
			whatOn = "Anchor";
			break;
		case '3':
			whatOn = "Heart";
			break;
		case '4':
			whatOn = "Club";
			break;
		case '5':
			whatOn = "Spade";
			break;
		case '6':
			whatOn = "Diamond";
			break;
		}

		return whatOn;

	}

	public int getAmount(int stake, char betType, String whatOn) {

		int amount;
		int minimumBet = 0;
		boolean valid = true;

		switch (betType) {
		case '1':
			minimumBet = 1;
			break;
		case '2':
			minimumBet = 2;
			break;
		case '3':
			minimumBet = 3;
			break;
		}

		do {

			valid = true;
			amount = 0;

			displayMessage("You are betting on " + whatOn + " the minimum bet is " + minimumBet);
			displayMessage("Please enter your betting amount: ");

			if (myScanner.hasNextInt()) {
				amount = myScanner.nextInt();

				if (amount >= minimumBet) {
					{
						if ((amount - stake) > 0) {
							displayMessage("You do not have enough credits!");
							valid = false;
						}
					}

				} else {
					displayMessage("This is too low for this bet type, please enter another amount: ");
					valid = false;

				}
			} else {
				displayMessage("Invalid input, try again: ");
				valid = false;
				myScanner.next();
			}
		} while (!valid);

		return amount;
	}
}