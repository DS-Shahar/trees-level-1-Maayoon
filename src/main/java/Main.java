import java.util.*;
public class Main 
{	
    
    static Scanner reader = new Scanner(System.in);
    



    public static void printTree(BinNode<Integer> t) 
    {
        if (t.getValue() > 0)
        {
            printPositive(t);
        }
        else
        {
           printLeft(t);
        }
    }
    


  
	public static void printOdd(BinNode<Integer> t) 
	{

		if (t != null) 
		{
			printOdd(t.getLeft());

			int value = t.getValue();

			if (value < 0)
				System.out.println(value);

			printOdd(t.getRight());
		}
	}




    public static void printLeft(BinNode<Integer> t) 
    {
        if (t != null)
        {
            BinNode<Integer> leftChild = t.getLeft();
            
            if (leftChild != null) 
            {
                System.out.println(leftChild.getValue());
            }
    
            printLeft(t.getLeft());  
            printLeft(t.getRight());
        }
    }
    



	public static void printPositive(BinNode<Integer> t) 
	{

		if (t != null) 
		{
			printOdd(t.getLeft());

			int value = t.getValue();

			if (value > 0)
				System.out.println(value);

			printOdd(t.getRight());
		}
	}
	
	
	
	public static void tree11a (BinNode<Integer> t) 
	{
        if (t == null) 
            return;
        
        if (t.getValue() % 2 == 0) 
        {
            boolean hasEvenChild = false;

            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (t.hasRight() && t.getRight().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (!hasEvenChild) 
                System.out.println(t.getValue());
        }
        tree11a(t.getLeft());
        tree11a(t.getRight());
	}
	
	
	
	
	
	
	public static int tree11b (BinNode<Integer> t) 
	{
        if (t == null) 
            return 0;
        
        int count=0;
        
        if (t.getValue() % 2 == 0) 
        {
            boolean hasEvenChild = false;

            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (t.hasRight() && t.getRight().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (!hasEvenChild) 
                count=1;
        }
        return count + tree11b(t.getLeft()) + tree11b(t.getRight());
	}
	
	
	
	
    public static boolean tree11c(BinNode<Integer> t)
    {
        if (t == null)
            return false;
    
        boolean bool = false;
    
        if (t.getValue() % 2 == 0)
        {
            boolean hasOddChild = false;
    
            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1)
                hasOddChild = true;
    
            if (t.hasRight() && t.getRight().getValue() % 2 == 1)
                hasOddChild = true;
    
            if (!hasOddChild)
                bool = true;
        }
        return bool || tree11c(t.getLeft()) || tree11c(t.getRight());
    }
    
    
   
    
    public static boolean tree11d(BinNode<Integer> t)
    {
        if (t == null)
            return false;   
    
        boolean bool = true;
    
        if (t.getValue() % 2 == 0)
        {
            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1)
                bool = false;
    
            if (t.hasRight() && t.getRight().getValue() % 2 == 1)
                bool = false;
        }
        return bool && tree11d(t.getLeft()) && tree11d(t.getRight());
    }
	


    


    public static int between10and100(BinNode<Integer> t)
    {
        if (t == null) 
            return 0;
        
        int count=0;
            
        if (t.getValue() < 100 && t.getValue() >= 10) 
            count=1;
            
        return count + between10and100(t.getLeft()) + between10and100(t.getRight());
    }
    
    
    
    
    public static int numLeaves (BinNode<Integer> t) 
	{
        if (t == null) 
            return 0;
        
        int count=0;
            
        if (!t.hasRight() && !t.hasLeft()) 
            count=1;
            
        return count + numLeaves(t.getLeft()) + numLeaves(t.getRight());
	}
    
    
    
    
    public static double hasTwoSons (BinNode<Integer> t) 
	{
        if (t == null) 
            return 0;
        
        double sum=0;
            
        if (t.hasRight() && t.hasLeft()) 
            sum = t.getValue();
            
        return sum + hasTwoSons(t.getLeft()) + hasTwoSons(t.getRight());
	}
	
	
	
	
	public static int twoSonsNotLeaves (BinNode<Integer> t) 
	{
        if (t == null) 
            return 0;
        
        int count = 0;
            
        if (t.hasRight() && t.hasLeft())
        {
            if ((t.getLeft().hasLeft() || t.getLeft().hasRight()) && (t.getRight().hasRight() || t.getRight().hasLeft()))
                count = 1;
        }
        return count + twoSonsNotLeaves(t.getLeft()) + twoSonsNotLeaves(t.getRight());
	}





    public static boolean allLeavesEven(BinNode<Integer> t)
    {
        if (t == null)
            return true;   
    
        if (!t.hasRight() && !t.hasLeft()) 
        {
            if (t.getValue() % 2 != 0)
            {
                return false;
            }
        }
        return allLeavesEven(t.getLeft()) && allLeavesEven(t.getRight());
    }
    
    
    
    
    
    
    public static boolean allLeftHaveRight(BinNode<Integer> t)
    {
        if (t == null)
            return true;   
    
        if (t.hasRight()) 
        {
            if (!t.hasLeft())
            {
                return false;
            }
        }
        return allLeftHaveRight(t.getLeft()) && allLeftHaveRight(t.getRight());
    }
    
    
    
    
    
    public static int numNodes(BinNode<Integer> t)
    {
        if (t == null)
            return 0;   
        
        else 
            return numNodes(t.getLeft()) + numNodes(t.getRight()) + 1;
    }
    
    
    
    
    
    
    public static void everyNodeEqualsSons(BinNode<Integer> t)
    {
        if (t == null)
            return;   
        
        if (!(t.hasLeft() && t.hasRight()))
            t.setValue(1);
        
        else 
        {
            t.setValue(numNodes(t.getLeft()) + numNodes(t.getRight()));
        }
        everyNodeEqualsSons(t.getRight());
        everyNodeEqualsSons(t.getLeft());
    }
    
    
    
    
    
    public static boolean containsAll(BinNode<Integer> t1, BinNode<Integer> t2)
    {
        if (t2 == null)
            return true;
    
        if (t1 == null)
            return false;
    
        if (!exists(t1, t2.getValue()))
            return false;
    
        return containsAll(t1, t2.getLeft()) &&
               containsAll(t1, t2.getRight());
    }
    
    
        
    
    public static boolean from1ToN(BinNode<Integer> t, int n)
    {
        for (int i = 1; i <= n; i++)
        {
            if (!exists(t, i))
                return false;
        }
    
        return countNodes(t) == n;
    }


    
//helper functions   
/////////////////////////////////////////////////////////////////////////////////////////////
    private static boolean exists(BinNode<Integer> t, int x)
    {
        if (t == null)
            return false;
    
        if (t.getValue() == x)
            return true;
    
        return exists(t.getLeft(), x) ||
               exists(t.getRight(), x);
    }
    


    private static int countNodes(BinNode<Integer> t)
    {
        if (t == null)
            return 0;
    
        return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    


	
	public static void main(String [] args)
	{
	    
		BinNode<Integer> t15 = new BinNode<Integer>(15);
		BinNode<Integer> t14 = new BinNode<Integer>(14);
		BinNode<Integer> tree = new BinNode<Integer>(t15, 3, t14);
		BinNode<Integer> t9 = new BinNode<Integer>(9);
		tree.getLeft().setLeft(new BinNode<Integer>(t9, 6, new BinNode<Integer>(7)));
		tree.getLeft().setRight(new BinNode<Integer>(new BinNode<Integer>(34), 56, new BinNode<Integer>(12)));
		
		//printOdd(tree);
		//printLeft(tree);
		
		//tree11a(tree);
		//System.out.println(tree11b(tree));
		//System.out.println(tree11c(tree));
		//System.out.println(tree11d(tree));
		//System.out.println(between10and100(tree));
		//System.out.println(numLeaves(tree));
		//System.out.println(hasTwoSons(tree));
		//System.out.println(twoSonsNotLeaves(tree));
		//System.out.println(allLeavesEven(tree));
		//System.out.println(allLeftHaveRight(tree));
		
		everyNodeEqualsSons(tree);
		printTree(tree);
	  System.out.println(containsAll(tree, tree));

	    
	    
	}
	

}   




