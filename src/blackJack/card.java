package blackJack;

public class card {
	private int rank, suit; 
	
	public card(int a, int b) {
		this.rank = b;
		this.suit = a;
	}

	private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
	private static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };


	public @Override String toString()
	{
		return ranks[rank] + " of " + suits[suit];
	}
	
	int getRank()
	{
		return rank;
	}
	
	


}
