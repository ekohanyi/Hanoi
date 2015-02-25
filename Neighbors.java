import java.util.ArrayList;

public class Neighbors
{
   public StateNode n;
   public StateNode temp;
   public int k;
   public ArrayList neighbors;
   public ArrayList relationships;
   public ArrayList neighborhood;

   
   public Neighbors()
   {
   }
   
   public Neighbors(StateNode q)
   {
      k=1;
      n=q;
     neighbors = new ArrayList<String>(); //children of 1 node
     neighborhood = new ArrayList<String>(); //all the nodes in the graph
     relationships = new ArrayList<ArrayList>(); //the children of all nodes 
   }
   
   public ArrayList getNeighbors()
   {
      n.findChildren();
      neighbors = n.getChildren();
         return neighbors; //returns the children of 1 node
   }
   
   public ArrayList getRelationships()
   {
      relationships.add(neighbors);
      return relationships; // returns the children of every node
   }
   
   public ArrayList getAllNodes()
     {
      return n.getAll();
     }
   
   
   
}