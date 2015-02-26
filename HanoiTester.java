import java.util.ArrayList;

public class HanoiTester
{
   public static void main(String[] args)
   {
      //whatsupp
      Tower t1 = new Tower(true, true, true, true, false);
      Tower t2 = new Tower(false, false, false, false, true);
      Tower t3 = new Tower(false, false, false, false, true);
      Tower [] smallest = new Tower [3];
      ArrayList <String> local = new ArrayList<String> (); //stores the children of 1 node
      ArrayList <ArrayList> relationships = new ArrayList<ArrayList>(); //stores the children of every node
      ArrayList <String> all = new ArrayList<String>();//stores every node 
      ArrayList <String> nodes = new ArrayList<String>();
      smallest[0]=t1;
      smallest[1]=t2;
      smallest[2]=t3;
      StateNode s1 = new StateNode(smallest);
      local = s1.getNeighbors();
      relationships.add(local);
      nodes = s1.getAll();
      all.addAll(nodes);
      for (int i = 0; i < relationships.size(); i++)
         for (int j = 0; j < local.size(); j++)
            System.out.println(relationships.get(i).get(j));
      for (int k =0; k<all.size();k++)
         System.out.println(all.get(k));
   }
}
