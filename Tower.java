public class Tower
{
   public boolean l;
   public boolean m;
   public boolean s;
   public boolean xs;
   public boolean e;
   public int temp;
   public String output;
   
   public Tower()
   {
   }
   
   public Tower(boolean large, boolean medium, boolean small, boolean xsmall, boolean empty)
   {
      l = large;
      m = medium;
      s = small;
      xs = xsmall;
      e = empty;
   }
   
   public int getSmallest()
   {
      if (xs==true)
         return 1;
      else if (s ==true)
         return 2;
      else if (m == true)
         return 3;
      else if (l == true)
         return 4;
      else 
         return 5;
   }
    
   public void removeDisc(int t)
   {
      temp = t;
      if (temp == 1)
         xs = false;
      else if (temp ==2)
         s = false;
      else if (temp ==3)
         m = false;
      else if (temp==4)
         l = false;
      else
         e=false;
   }
    
   public void placeDisc(int t)
   {
      temp = t;
      if (temp == 1)
         xs = true;
      else if (temp ==2)
         s = true;
      else if (temp ==3)
         m =true;
      else if (temp==4)
         l = true;
      else 
         e = true;
   }
    
   public boolean getL()
   {
      return l;
   }

   public boolean getM()
   {
      return m;
   }
    
   public boolean getS()
   {
      return s;
   }
   public boolean getXS()
   {
      return xs;
   }
   public boolean getE()
   {
      return e;
   }
   public String getTowers()
   {
      output = "";
      
      if (this.getL()==true)
         output = output.concat("4");
      else 
         output = output.concat("0");
      
      if (m==true)
         output = output.concat("3");
      else
         output = output.concat("0");
      
      if (s==true)
         output = output.concat("2");
      else 
         output = output.concat("0");
      
      if (xs==true)
         output = output.concat("1");
      else 
         output = output.concat("0");
      
      if (e==true)
         output = output.concat("5");
      else
         output = output.concat("0");
   
      return output;
   
   }
}