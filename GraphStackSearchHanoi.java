import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.LinkedList;
//DEPTH FIRST
public class GraphStackSearchHanoi
{
   public static void main(String[] args)
   {
      //All of our Variable Instantiations
      boolean Return;
      int disks = 0;
      int v = 0;
      int heuristic = 0;
      boolean cont = false;
      String tempPath = "";
      ArrayList <String> local = new ArrayList<String> (); //Stores the children of 1 node
      ArrayList <ArrayList> relationships = new ArrayList<ArrayList>(); //Stores the children of every node
      ArrayList <String> all = new ArrayList<String>();//Stores every node
      ArrayList <String> nodes = new ArrayList<String>();
      Hashtable htString = new Hashtable(91);
      Hashtable frontierReference = new Hashtable(91);
      Hashtable lastNode = new Hashtable(91);
      //ArrayList <String> frontier = new ArrayList<String>(91);
      LinkedList frontier = new LinkedList();
      StateNode tempstate;
      String finalnode = "000050000543210";
      Tower t1 = new Tower(true, true, true, true, false);
      Tower t2 = new Tower(false, false, false, false, true);
      Tower t3 = new Tower(false, false, false, false, true);
      Tower [] smallest = new Tower [3];
      smallest[0]=t1;
      smallest[1]=t2;
      smallest[2]=t3;
      StateNode dummy = new StateNode(smallest);

      int hashCounter = 2;
      String workingpath;
      int workingnodelabel;
      String workingnode;
      ArrayList <String> workingChildren = new ArrayList<String>();
     
      //Initializes the Start node in two hash tables and the frontier
      htString.put(1,"432100000500005");
      frontierReference.put("432100000500005",1);
      frontier.push("S"+frontierReference.get("432100000500005").toString());
      lastNode.put("S"+frontierReference.get("432100000500005").toString(), "432100000500005");
     
     
      // While there are still paths in the frontier
      while (cont == false) {
      //Sets the first node in the frontier as the working node, and then removes it
         workingpath = frontier.removeFirst().toString();
         System.out.println("workingpath: " + workingpath);
         workingnode = lastNode.get(workingpath).toString(); 
         System.out.println("workingnode: " + workingnode);
         tempstate = new StateNode(dummy.stringToStateNode(workingnode));
         workingChildren.addAll(tempstate.getNeighbors());
         System.out.println("workingChildren: " + workingChildren);

      // Uses a loop to add the children nodes to the hashtables, and creates labels
      // Second part of if-statement adds a concatentated path back to the frontier
         for(int k = 0;k<workingChildren.size();k++) {
            if (htString.containsKey(workingChildren.get(k)) == false){
               tempPath = workingpath;
               System.out.println(workingChildren.get(k));
               frontier.push(tempPath.concat("S"+hashCounter));
               htString.put(workingChildren.get(k), hashCounter);
               lastNode.put(tempPath.concat("S"+htString.get(workingChildren.get(k).toString())), workingChildren.get(k).toString());
               hashCounter+=1;
            }
         }
          workingChildren.clear();
          System.out.println(frontier);
         //Checks for the final node at the end of the path, prints path, then breaks.
         
         if(workingnode.equals(finalnode)){
               System.out.print(workingpath);
               cont = true;
               break;
            }
          else
            cont = false;
      }       
   }
}