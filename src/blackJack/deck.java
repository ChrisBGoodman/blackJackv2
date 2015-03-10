package blackJack;

import java.util.ArrayList;
import java.util.Random;

public class deck {
	
	private ArrayList <card> cards;
	
	deck()									//Creates a deck of cards 
	{
		cards = new ArrayList<card>();
		Random generate = new Random();
		
		int index1, index2 = 0;				//vars used for shuffling deck
		card temp; 			
		
		for (int a=0; a<=3; a++)
		{
			for (int b=0; b<=12; b++)
			{
				cards.add(new card(a,b));
			}
		}
		
		for(int i = 0; i < 200; i++)						//Shuffle deck 100 times
		{
			index1 = generate.nextInt(cards.size() - 1);	//generate 2 random numbers
			index2 = generate.nextInt(cards.size() -1);

			temp = cards.get(index2);						//Swap the 2 randomly chosen cards 
			cards.set(index2, cards.get(index1));
			cards.set(index1, temp);
		}
	}

	public card drawFromDeck()			//Removes first card from deck and discards
	{
		return cards.remove(0);
	}
	
	public int getDeckSize()
	{
		return cards.size();
	}

}



