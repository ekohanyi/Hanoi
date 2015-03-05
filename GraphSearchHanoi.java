import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class GraphSearchHanoi
{

   
   public static void main(String[] args)
   {
      boolean Return;
      int disks = 0;
      int v = 0;
      int heuristic = 0;
      boolean compare;
      Tower t1 = new Tower(true, true, true, true, false);
      Tower t2 = new Tower(false, false, false, false, true);
      Tower t3 = new Tower(false, false, false, false, true);
      Tower [] smallest = new Tower [3];
      Hashtable htString = new Hashtable(91);
      ArrayList <String> local = new ArrayList<String> (); //stores the children of 1 node
      ArrayList <ArrayList> relationships = new ArrayList<ArrayList>(); //stores the children of every node
      ArrayList <String> all = new ArrayList<String>();//stores every node 
      smallest[0]=t1;
      smallest[1]=t2;
      smallest[2]=t3;
      StateNode s1 = new StateNode(smallest);
      local.addAll(s1.getNeighbors());
      for (int l = 0; l<local.size(); l++){
         if(htString.containsValue(local.get(l))) 
            compare = true;
         else 
            compare = false;
         if (compare == true)
            local.remove(local.get(l));
      }
      relationships.add(local);
      all.addAll(local);
      /*for (int i = 0; i < relationships.size(); i++)
         for (int j = 0; j < local.size(); j++)
            System.out.println(relationships.get(i).get(j));*/
      for (int k =0; k<all.size();k++){
         System.out.println(all.get(k));
         htString.put(all.indexOf(all.get(k)), k);
         }


      Hashtable frontierReference = new Hashtable(91);
      ArrayList <String> frontier = new ArrayList<String>(91);
      
      
      //do {
      frontier.addAll(all);
      for (int i=0; i<frontier.size(); i++){
         for (int j=10; j<=13; j++){
            char values = frontier.get(i).charAt(j);
            v = Character.getNumericValue(values);
            if (v != 0)
               disks++;
              // if (disks == 4)
                  //loop = false;
               v=0;
            }
            //System.out.println(disks);
            int index = all.indexOf(frontier.get(i));
            heuristic = 4 - disks;
            System.out.println(heuristic);
            disks=0;
            heuristic = 0;
            }
      
      //}while (loop);
      }
   
}