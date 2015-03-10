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
public class display {
    
    /**
     * 
     * @return player choice of what to do next 
     */
    int menu()
    {
        System.out.println("Welcome to BlackJack by Stock.");
        System.out.println("Play(1), View HighScores (2), Exit(3)");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        return choice;
        
    }
    
  
    
    
    
}
