  import java.util.ArrayList;
  
   public class StateSearchTree
   {
      public StateNode root;
    
   
      public void StateSearchTree()
      {
         root = null;
      }
   
      public void makeEmpty()
      {
         root = null;
      }
   
      public boolean isEmpty()
      {
         return( root == null );
      }
   
      public StateNode insert(int n, Tower [] state,  int dpth, StateNode pt, StateNode [] tree)
      {
         if (pt == null )
         { 
            StateNode newnode = new StateNode(n, state, dpth, pt, null);
            return (newnode);
         }
        else if ((state[0].getSmallest() < state[1].getSmallest()) && (state[0].getSmallest() > 0))
         {
            int temp = state[0].getSmallest();
            state[0].removeDisc(temp);
            state[1].placeDisc(temp);
            StateNode newnode = new StateNode(n+1, state, dpth+1, pt, null);
            tree[n] = newnode;
            return (newnode);
        }
        else if (state[1].getSmallest() < state[2].getSmallest())
        {
        int temp = state[1].getSmallest();
            state[1].removeDisc(temp);
            state[2].placeDisc(temp);
            StateNode newnode = new StateNode(n+1, state, dpth+1, pt, null);
            return (newnode);
        }
        else if (state[0].getSmallest() < state[2].getSmallest())
        {
            int temp = state[0].getSmallest();
            state[0].removeDisc(temp);
            state[2].placeDisc(temp);
            StateNode newnode = new StateNode(n+1, state, dpth+1, pt, null);
            return (newnode);
        }
        else if (state[2].getSmallest() < state[0].getSmallest())
        {
            int temp = state[2].getSmallest();
            state[2].removeDisc(temp);
            state[0].placeDisc(temp);
            StateNode newnode = new StateNode(n+1, state, dpth+1, pt, null);
            return (newnode);
        }
        else if (state[2].getSmallest() < state[1].getSmallest())
        {
            int temp = state[2].getSmallest();
            state[2].removeDisc(temp);
            state[1].placeDisc(temp);
            StateNode newnode = new StateNode(n+1, state, dpth+1, pt, null);
            return (newnode);
        }
        else if (state[1].getSmallest() < state[0].getSmallest())
        {
            int temp = state[1].getSmallest();
            state[1].removeDisc(temp);
            state[0].placeDisc(temp);
            StateNode newnode = new StateNode(n+1, state, dpth+1, pt, null);
            return (newnode);
        }
        else 
         return (pt);
       }
   }
