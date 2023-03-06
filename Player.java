package crownAndAnchorApp;

public class Player {
	private int stake; 
	private int banker = 100;
	private String name;
	
	public Player() {
		name = "";
		stake = 0;
	}

	public Player(String name, int stake) {
	    this.name = name;
	    this.stake = stake;
	}
	
	public void increaseStake(int val) {
		stake+=val ;
	}
	
	public void decreaseStake(int val) {
		stake-=val;
	}
	
	public void increaseBanker(int val) {
		banker+=val;
	}
	
	public void decreaseBanker(int val) {
		banker-=val;
	}
	
	public int getStake() {
		return stake;
	}

	public int getBanker() {
		return banker;
	}

	public String getName() {
		return name;
	}

}