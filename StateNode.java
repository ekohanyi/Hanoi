import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.*;

public class StateNode
{
   private Tower state[];
   private int depth;
   private StateNode parent;
   private StateNode newnode1;
   private StateNode newnode;
   private Tower working[];
   private ArrayList children;
   int k;
   public Hashtable htNode = new Hashtable(91);
   public Hashtable htString = new Hashtable(91);
   public ArrayList all;
   public String comp;

   public StateNode(Tower [] current)
   {
      state = current;
      //depth = dpth;
      //parent = p;
      children = new ArrayList <String> ();
      working = new Tower[state.length];
      all = new ArrayList<String>();
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
   
   public void findChildren()
   {
      if ((state[0].getSmallest() < state[1].getSmallest()) && (state[0].getSmallest() < 5))
      {
         int temp = state[0].getSmallest();
         working[0].removeDisc(temp);
         working[1].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println("if1");
         this.compare();
         System.out.println(htString.containsKey(this.drawStateNode()));
         System.out.println(htString.containsValue(k));
         k++;
         //this.drawStateNode();
         if(this.compare() == false) { 
            children.add(newnode.drawStateNode());
            all.add(newnode.drawStateNode());
         } 
         else {
         }
      }
   
      this.revertWorking();
      if ((state[0].getSmallest() < state[2].getSmallest()) && (state[0].getSmallest() <5))
      {
         int temp = state[0].getSmallest();
         working[0].removeDisc(temp);
         working[2].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println();
         System.out.println("if2");
         this.compare();
         System.out.println(htString.containsKey(this.drawStateNode()));
         System.out.println(htString.containsValue(k));
         System.out.println(htString.get(this.drawStateNode()));
         k++;
        //this.drawStateNode();
         if(this.compare() == false) { 
            children.add(newnode.drawStateNode());
            all.add(newnode.drawStateNode());
         } 
         else {
         }
      }
      this.revertWorking();
      if ((state[1].getSmallest() < state[2].getSmallest()) && (state[1].getSmallest() <5))
      {
         int temp = state[1].getSmallest();
         working[1].removeDisc(temp);
         working[2].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println();
         System.out.println("if3");
         this.compare();
         System.out.println(htString.containsKey(this.drawStateNode()));
         System.out.println(htString.containsValue(k));
         System.out.println(htString.get(this.drawStateNode()));
         k++;
         //this.drawStateNode();
         if(this.compare() == false) { 
            children.add(newnode.drawStateNode());
            all.add(newnode.drawStateNode());
         } 
         else {
         }
      }
      this.revertWorking();
      if ((state[1].getSmallest() < state[0].getSmallest()) && (state[1].getSmallest() <5))
      {
         int temp = state[1].getSmallest();
         working[1].removeDisc(temp);
         working[0].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println();
         System.out.println("if4");
         this.compare();
         System.out.println(htString.containsKey(this.drawStateNode()));
         System.out.println(htString.containsValue(k));
         System.out.println(htString.get(this.drawStateNode()));
         k++;
         //this.drawStateNode();
         if(this.compare() == false) { 
            children.add(newnode.drawStateNode());
            all.add(newnode.drawStateNode());
         } 
         else {
         }
      }
      this.revertWorking();
      if ((state[2].getSmallest() < state[0].getSmallest()) && (state[2].getSmallest() <5))
      {
         int temp = state[2].getSmallest();
         working[2].removeDisc(temp);
         working[0].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println();
         System.out.println("if5");
         this.compare();
         System.out.println(htString.containsKey(this.drawStateNode()));
         System.out.println(htString.containsValue(k));
         System.out.println(htString.get(this.drawStateNode()));
         k++;
         //this.drawStateNode();
         if(this.compare() == false) { 
            children.add(newnode.drawStateNode());
            all.add(newnode.drawStateNode());
         } 
         else {
         }
      }
      this.revertWorking();
      if ((state[2].getSmallest() < state[1].getSmallest()) && (state[2].getSmallest() <5))
      {
         int temp = state[2].getSmallest();
         working[2].removeDisc(temp);
         working[1].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println();
         System.out.println("if6");
         this.compare();
         System.out.println(htString.containsKey(this.drawStateNode()));
         System.out.println(htString.containsValue(k));
         System.out.println(htString.get(this.drawStateNode()));
         k++;
         //this.drawStateNode();
         if(this.compare() == false) { 
            children.add(newnode.drawStateNode());
            all.add(newnode.drawStateNode());
         } 
         else {
         }
      }
     
      Enumeration en=htString.keys();
   
      System.out.println("Display result:"); 
   
   // display search result
      while (en.hasMoreElements()) {
         System.out.println(en.nextElement());
      }
   }
   public ArrayList getNeighbors()
   {
      this.findChildren();
      return children;
   }
   public StateNode getParent()
   {
      return parent;
   }
   public Tower[] getState()
   {
      return state;
   }
   
   public String drawStateNode() {
      String output="";
      for (int i = 0; i<3; i++){
         output = output.concat(working[i].getTowers());
      }
      return output;
   }
  
  
  
   public boolean compare(){
      comp = this.drawStateNode();
      if(htString.containsValue(comp)) {
         return true;
      } 
      else {
         htString.put(comp, k);
         return false;
      }
      }
   public ArrayList getAll()
   {
      return all;
   }
   


}
