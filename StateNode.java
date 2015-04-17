import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


public class StateNode
{
   private Tower state[];
   private StateNode newnode;
   private Tower working[];
   private ArrayList children;
  
   public  ArrayList<Boolean> t1;
   public ArrayList<Boolean> t2;
   public ArrayList<Boolean> t3;
   public ArrayList<Boolean> whole;
   public Tower[] tworking;
   public StateNode sworking;
   public Tower nt1;
   public Tower nt2;
   public Tower nt3;
   public String path;
   public String label;
   public String x;
   public String input;

   public StateNode(Tower [] current)
   {
      state = current;
      children = new ArrayList <String> ();
      working = new Tower[state.length];
      this.revertWorking();
   }
  
   public void revertWorking()
   {
      for (int i = working.length - 1; i >= 0; --i) {
         Tower t = new Tower(state[i].getL(), state[i].getM(), state[i].getS(), state[i].getXS(), state[i].getE());
         if (t != null)
            working[i] = t;
      }
   }
  
   public void findChildren(){
      if ((state[0].getSmallest() < state[1].getSmallest()) && (state[0].getSmallest() < 5))
      {
         int temp = state[0].getSmallest();
         working[0].removeDisc(temp);
         working[1].placeDisc(temp);
         newnode = new StateNode(working);
         children.add(newnode.drawStateNode());
      }
   
      this.revertWorking();
      if ((state[0].getSmallest() < state[2].getSmallest()) && (state[0].getSmallest() <5))
      {
         int temp = state[0].getSmallest();
         working[0].removeDisc(temp);
         working[2].placeDisc(temp);
         newnode = new StateNode(working);
         children.add(newnode.drawStateNode());
      }
   
      this.revertWorking();
      if ((state[1].getSmallest() < state[2].getSmallest()) && (state[1].getSmallest() <5))
      {
         int temp = state[1].getSmallest();
         working[1].removeDisc(temp);
         working[2].placeDisc(temp);
         newnode = new StateNode(working);
         children.add(newnode.drawStateNode());
      }
   
      this.revertWorking();
      if ((state[1].getSmallest() < state[0].getSmallest()) && (state[1].getSmallest() <5))
      {
         int temp = state[1].getSmallest();
         working[1].removeDisc(temp);
         working[0].placeDisc(temp);
         newnode = new StateNode(working);
         children.add(newnode.drawStateNode());
      }
     
      this.revertWorking();
      if ((state[2].getSmallest() < state[0].getSmallest()) && (state[2].getSmallest() <5))
      {
         int temp = state[2].getSmallest();
         working[2].removeDisc(temp);
         working[0].placeDisc(temp);
         newnode = new StateNode(working);
         children.add(newnode.drawStateNode());
      }
      this.revertWorking();
      if ((state[2].getSmallest() < state[1].getSmallest()) && (state[2].getSmallest() <5))
      {
         int temp = state[2].getSmallest();
         working[2].removeDisc(temp);
         working[1].placeDisc(temp);
         newnode = new StateNode(working);
         children.add(newnode.drawStateNode());
      }
   }
   
   public ArrayList getNeighbors()
   {
      this.findChildren();
      return children;
   }

   public Tower[] getState()
   {
      return state;
   }

   public String drawStateNode() {
      String output="";
      for (int i = 0; i<3; i++)
         output = output.concat(working[i].getTowers());
      return output;
   }

   public String getNode()
   {
      return this.drawStateNode();
   }

 //Turns a Statenode into a 15 boolean long arraylist
   public Tower[] stringToStateNode(String convert) {
      input = convert;
      t1 = new ArrayList<Boolean>();
      t2= new ArrayList<Boolean>();
      t3= new ArrayList<Boolean>();
      whole = new ArrayList<Boolean>();
      
     //These take from the string, and fill 3 arraylists of booleans
      for(int q=0; q<5;q++) {
         if (input.charAt(q) != '0')
            t1.add(true);
         else 
            t1.add(false);
      }
    
      for(int w=5; w<10;w++) {
         if (input.charAt(w) != '0')
            t2.add(true);
         else 
            t2.add(false);
      }
    
      for(int e=10; e<15;e++) {
         if (input.charAt(e) != '0')
            t3.add(true);
         else 
            t3.add(false);
      }
   
      nt1 = new Tower(t1.get(0), t1.get(1), t1.get(2), t1.get(3), t1.get(4));
      nt2 = new Tower(t2.get(0), t2.get(1), t2.get(2), t2.get(3), t2.get(4));
      nt3 = new Tower(t3.get(0), t3.get(1), t3.get(2), t3.get(3), t3.get(4));
    
      tworking = new Tower[3];
      tworking[0]=nt1;
      tworking[1]=nt2;
      tworking[2]=nt3;
    
      return tworking;
   }
     
   public String parsePath(String name)
   {
      path = name;
      for (int i = path.length() -1 ; i>path.length(); i--){
         if (path.charAt(i) == 'S')
            for(int j = i; j<path.length(); j++){
               x = String.valueOf(path.charAt(j));
               label.concat(x);
            }
       }
      return label;
    }
}