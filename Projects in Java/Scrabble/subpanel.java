//********************************************************************

import java.util.Random;
import java.util.LinkedHashSet;
import java.util.Set;

 //********************************************************************
 // Rectangle.java Author: Dipika Subramaniam
 // subpanel for computer choice of 0,1,2
 //********************************************************************


 public class subpanel
 {
   private Random rand = new Random();
   public subpanel()
   {

   }
   public String[] getComp()
   {
     Set<Integer>set = new LinkedHashSet<Integer>(); // this removes duplicates!
     Random randNum = new Random();
     while (set.size() < 7) {
              set.add(randNum.nextInt(26)-1);
           }
    String[] sevenNumbers = new String[set.size()];
    set.toArray(sevenNumbers);

    return sevenNumbers;
   }
 }
