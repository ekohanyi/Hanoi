import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class StateNode
{
   private Tower state[];
   private StateNode newnode;
   private Tower working[];
   private ArrayList children;


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
          System.out.println("if1");
            children.add(newnode.drawStateNode());
      }
   
      this.revertWorking();
      if ((state[0].getSmallest() < state[2].getSmallest()) && (state[0].getSmallest() <5))
      {
         int temp = state[0].getSmallest();
         working[0].removeDisc(temp);
         working[2].placeDisc(temp);
         newnode = new StateNode(working);
         System.out.println();
            children.add(newnode.drawStateNode());
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
            children.add(newnode.drawStateNode());
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
         children.add(newnode.drawStateNode());
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
         children.add(newnode.drawStateNode());
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

}
