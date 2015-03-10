/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackJack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ChrisGoodman
 */
public class scores {
    
        private static final String HIGHSCORE_FILE = "highScores.txt";

        private ArrayList <player> players = new ArrayList<player>();
        private boolean playerFound;
        private String pName;
        
        scores() //Will read in text file and build a string from txt file
        {
            BufferedReader br = null;
            try {
                System.out.println("UserName? ");
                Scanner sc = new Scanner(System.in);
                pName = sc.nextLine().toLowerCase();
                playerFound = false;
                
                br = new BufferedReader(new FileReader(HIGHSCORE_FILE));
                StringBuilder sb = new StringBuilder();
                String name = br.readLine();
                String num  = br.readLine();

                while (name != null && num != null)
                {
                    players.add(new player(name, num));  //Filling players array list with data from text file
                    sb.append(name+"\n");    //
                    //sb.append(",");
                    sb.append(num + "\n");
                    //sb.append(",");
                    
                    name = br.readLine();
                    num  = br.readLine();
                }
                br.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
            
        }
        
        public String findPlayerScore()
        {
            for ( int i = 0; i < players.size(); i++)   //loop through all players to check for new player 
            {
                                
                if (players.get(i).getName().toLowerCase().equals(pName))
                {
                    playerFound = true;
                    return players.get(i).getScore();
                }
                
            }    
                
            players.add(new player(pName, "2500"));
            return players.get(players.size()-1).getScore(); //return new player at end of list 

                 
            
        }
        
        /**
        /*  @if pName finds matching player in ArrayList, update their score  based on chip value
        /*
         * @param chipValue 
         */
        public void updateScore(int chipValue)
        {
            for ( int i = 0; i < players.size(); i++)   
            {
                       if (players.get(i).getName().equals(pName))
                            players.get(i).setScore(Integer.toString(chipValue));
            }
           
        }
              
        public void updateFile()
        {
            FileOutputStream outFile = null;
            try {
                File file = new File("highScores.txt");
                outFile = new FileOutputStream(file, false);
                PrintStream ps = new PrintStream(outFile);
                for ( int i = 0; i < players.size(); i++)               {
                    try //loop through all players to check for new player
                    {
                        ps.write(players.get(i).getName().getBytes());
                        ps.println();
                        ps.write(players.get(i).getScore().getBytes());
                        ps.println();
                        //outFile.write(players.get(i).getName().getBytes());
                       //outFile.write();
                        //outFile.write(players.get(i).getScore().getBytes());
                    } catch (IOException ex) {
                        Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    outFile.close();
                } catch (IOException ex) {
                    Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        public void showFile()
        {
            try {
                BufferedReader br = null;
                
                try {
                    br = new BufferedReader(new FileReader(HIGHSCORE_FILE));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
                }
                StringBuilder sb = new StringBuilder();
                String name = br.readLine();
                String num  = br.readLine();
                
                while (name != null && num != null)
                {
                    sb.append(name);
                    sb.append("\n");
                   
                    sb.append(num);
                    sb.append("\n");
                    
                    name = br.readLine();
                    num  = br.readLine();
                }
                br.close();
                                

                System.out.println(sb.toString());
                
            } catch (IOException ex) {
                Logger.getLogger(scores.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
        }
    
    
    
    
    
    
    
    
