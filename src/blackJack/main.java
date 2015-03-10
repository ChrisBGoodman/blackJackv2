/**
 * @author Christian Goodman
 * @version v1.1
 * @since 3/7/15
 */
package blackJack;

import java.util.Scanner;


public class main  {
		static boolean hit = true;
		static int i = 1;
		static int won = 0;
		static int lost = 0;
		static boolean checkwin;
                static boolean busted;
                static deck deck = new deck();
                static display dis = new display();
                static scores score = new scores();

                

		public static void main(String[] args) {
                    int choice;
                    do{
                    choice = dis.menu();
                    
                    if (choice == 2)
                        score.showFile();
                    
                    if (choice == 3)
                        System.exit(1);
                    
                    } while (choice != 1);
                   
                    
                    
                               
                    String x  = score.findPlayerScore();
                    int xx = Integer.parseInt(x);
                    chips chips = new chips(xx);

                    
			while(i == 1 && chips.getChipValue() > 0)
			{
				hand user = new hand(deck);
				hand dealer = new hand(deck);
				card c;
                                


				hit = true;
                                busted = false; 
                                
                                chips.placeBet();
                                
				System.out.print("\nYou are dealt: ");		
				user.displayHandAt(0);
				user.displayHandAt(1);
				dealer.displayDealer();

				while (hit)
				{
					user.showFaceValue();
					hit = user.hit(deck);

					if(user.getFaceValue() > 21)            //if > 21 don't allow hit, set busted
					{
						hit = false;
                                                user.setBust(true);
					}
                                        
                                        if(user.getFaceValue() == 21)           //if 21, don't allow a hit 
                                            hit = false;
				}	 
                                
                      		if (user.getBust() == false)                    //let dealer hit deck if not busted
                                {
                                    dealer.dealerHit(deck, dealer);
                                }
                              
				checkwin = user.compareHands(user, dealer);
				
				if ( checkwin == true){
					won++;
                                        chips.handWon();
                                }
				
				if ( checkwin == false){
					lost++;
                                        chips.handLost();
                                }

				System.out.print("\nWould you like to play again? Yes(1), No(2).");
				Scanner sc = new Scanner(System.in);
				i=sc.nextInt();
				System.out.println("---------------------------------------------------\n");
			}
                        System.out.println("Hands won: " + won + " Hands Lost: " + lost);
                        
                                                        
                        int cv = chips.getChipValue(); //Return the number of chips user had at end of game
                        score.updateScore(cv);          //Update Player in file to match chips for player                        
                        score.updateFile();

                                                

                        System.exit(1);
		}	
}
