//********************************************************************

import java.util.Random;


 //********************************************************************
 // Rectangle.java Author: Dipika Subramaniam
 // subpanel for computer choice of 0,1,2
 //********************************************************************


 public class subpanel
 {
   private int value;
   private Random rand = new Random();

   public subpanel()
   {

   }
   public int getComp()
   {
     int value = rand.nextInt(3);
     return value;
   }
 }
