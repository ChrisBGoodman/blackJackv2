/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackJack;

/**
 *
 * @author ChrisGoodman
 */
public class player {
    
    private String name;
    private String score;
    
    player (String a, String b)
    {
        this.name = a;
        this.score = b;
    }
    
   public String getName()
   {
       return name;
   }
   
   public String getScore()
   {
       return score;
   }
   
   public void setScore(String x)
   {
       this.score = x;
   }
    
    
    
}
