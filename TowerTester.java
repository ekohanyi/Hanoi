   public class TowerTester
   {
      public static void main(String[] args)
      {
      StateNode [] tree = new StateNode[200];
      Tower [] smallest = new Tower [3];
      
      Tower t1 = new Tower(true, true, true, true, false);
      Tower t2 = new Tower(false, false, false, false, true);
      Tower t3 = new Tower(false, false, false, false, true);
      
      System.out.println(t1.getSmallest());
      System.out.println(t2.getSmallest());
      System.out.println(t3.getSmallest());
      
      System.out.println(t1.getTowers().length());
     System.out.println(t1.getTowers());
      
      
      }
      
   }