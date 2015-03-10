/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackJack;

import java.util.Scanner;

/**
 *
 * @author ChrisGoodman
 */
public class chips {
        
        int chipValue;
        int i;
         
    chips(int x) //Start with a total of 5000 in chips
    {
       this.chipValue = x;
    }
    
    public int getChipValue()
    {
        System.out.println("Chip Value: " + chipValue);
        return chipValue;
    }
    
    void placeBet()
    {
        System.out.println("Would would you like to bet?");
        Scanner sc = new Scanner(System.in);
        i=sc.nextInt();
        
        if (chipValue - i >= 0)
            System.out.println("Betting " + i);
        
        if (chipValue - i < 0)
        {
            System.out.println("You don't have enough chips to do that.");
            placeBet();
        }
    }
    
    void handWon() //Add betted amount to value for win
    {
        chipValue = chipValue + i;
    }
    
    void handLost()
    {
        chipValue = chipValue - i;
    }
    
    
    
    
    
    
    
    
    
}
