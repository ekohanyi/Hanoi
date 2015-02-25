import java.util.ArrayList;
public class StateNodeTester
   {
      public static void main(String[] args)
      {
      Tower t1 = new Tower(true, true, true, true, false);
      Tower t2 = new Tower(false, false, false, false, true);
      Tower t3 = new Tower(false, false, false, false, true);
      Tower [] state = new Tower [3];
      Tower [] test = new Tower[3];
      ArrayList <String> local = new ArrayList<String> (4);
      state[0]=t1;
      state[1]=t2;
      state[2]=t3;
      StateNode s2 = new StateNode(state);
      s2.findChildren();
      local = s2.getChildren();
      }
  }