package blackJack;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hand 
{

	private card[] Cards;
	private int count = 0;
        private boolean busted;
	
	hand(deck d)
	{
		Cards = new card[5]; //Size 4 because 5 cards is automatic win.
		
		for (int i = 0; i < 2; i++)
		{
			Cards[i] = d.drawFromDeck();
			count++;
		}
	}
	
	void displayHandAt(int x)
	{
		System.out.print("\n\t" + Cards[x].toString() + " ");
	}
	
	void displayDealer()
	{
    	System.out.print("\nThe Dealer is showing a: ");
		System.out.println("\n\t" + Cards[0]);
	}
	
	int getRankAt(int x)
	{
		if(Cards[x].getRank() >= 10)  //if a face card, set rank to 10
			return 10;
		
		return Cards[x].getRank() + 1;
	}
	
	int getUserCardsCount()
	{
		return count;
	}
	
        
        /**
         * 
         * @param none 
         * @return value of all cards in deck  
         */
	int getFaceValue() 
	{
		int value = 0;
		for (int i = 0; i < count; i++)
		{
			if(Cards[i].getRank() >= 9)  							//if a face card, set rank to 10
				value = value + 10;
			
			if(Cards[i].getRank() < 9 && Cards[i].getRank() != 0) 	//if a not face card, and not ace
				value = value + Cards[i].getRank() + 1;	
			
			if(Cards[i].getRank() == 0)		//if ace
			{
				if (value <= 10)
					value = value + 10;
				if (value > 10)
					value = value + 1;
			}	
		}
		return value;
	}
	
	int showFaceValue()
	{
		int value = 0;
		for (int i = 0; i < count; i++)
		{
			if(Cards[i].getRank() >= 9)  //if a face card, set rank to 10
				value = value + 10;
			
			if(Cards[i].getRank() < 9 && Cards[i].getRank() != 0)  //if not face card, and not ace
				value = value + Cards[i].getRank() + 1;
			
			if(Cards[i].getRank() == 0)		//if ace
			{
				if (value <= 10)
					value = value + 10;
				if (value > 10)
					value = value + 1;
			}	
		}
		System.out.println("\nYour hand value is: " + value);
		
		if (value > 21)
			System.out.println("BUSTED!");
		return value;
	}
	
	boolean hit(deck d)
	{
		int i = 0;
    	System.out.print("Would you like to hit(1) or stay(2)\n");

        Scanner sc = new Scanner(System.in);
        i=sc.nextInt();
        
        if (i == 1)
        {
        	Cards[count] = d.drawFromDeck();
        	System.out.println("You drew a " + Cards[count].toString());
        	count++;
        	
        	return true;
        }
        
		return false;
	}
	
	boolean compareHands(hand user, hand dealer)
	{
		
                if (user.getFaceValue() <= 21 && dealer.getFaceValue() > 21)
                {
                    System.out.println("You won! You had: " + user.getFaceValue() + " The dealer had: " + dealer.getFaceValue());
			return true;
                }
            
		if (user.getFaceValue() > dealer.getFaceValue() && user.getFaceValue() < 22)
		{
			System.out.println("You won! You had: " + user.getFaceValue() + " The dealer had: " + dealer.getFaceValue());
			return true;
		}
		
		if (user.getFaceValue() <= dealer.getFaceValue())
		{
			System.out.println("You lost.. You had: " + user.getFaceValue() + "The dealer had: " + dealer.getFaceValue());
			return false;
		}
		
		if (user.getFaceValue() > 21)
		{
			System.out.println("Busted!");
			return false;
		}
		
		return false;
	}
	
	void dealerHit(deck d, hand dealer)
	{
            System.out.print("Dealer thinking");
            
            try {
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.println(".");
                Thread.sleep(500);
                } catch (InterruptedException ex) {
                Logger.getLogger(hand.class.getName()).log(Level.SEVERE, null, ex);}
            
            while (dealer.getFaceValue() <= 14)
            {
                System.out.println("Dealer chooses to hit.");
                dealer.Cards[count] = d.drawFromDeck();
                count++;
                try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(hand.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            if (dealer.getFaceValue() > 14) 
            {
                    System.out.println("Dealer chooses to stay");
            }
        }
	
	
	void setBust(boolean x)
        {
            busted = x;
        }
        
        boolean getBust()
        {
            return busted;
        }
	
	
	
	
}
