package assignment;

public class Week6 {
	

    int data;
    Week6 left, right;
  
    Week6(int d)
    {
        data = d;
        left = right = null;
    }
}
  
// A wrapper class used to modify height across
// recursive calls.
class Height {
    int height = 0;
}
  
class BinaryTree {
  
	Week6 root;
  
    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(Week6 root, Height height)
    {
        /* If tree is empty then return true */
        if (root == null) {
            height.height = 0;
            return true;
        }
  
        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height();
        boolean l = isBalanced(root.left, lheight);
        boolean r = isBalanced(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;
  
        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = (lh > rh ? lh : rh) + 1;
  
        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if (Math.abs(lh - rh) >= 2)
            return false;
  
        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else
            return l && r;
    }
  
    public static void main(String args[])
    {
        Height height = new Height();
  
        BinaryTree tree = new BinaryTree();
        tree.root = new Week6(1);
        tree.root.left = new Week6(4);
        tree.root.right = new Week6(5);
        tree.root.left.right = new Week6(3);
        tree.root.right.left = new Week6(2);
        tree.root.right.right = new Week6(9);
        tree.root.right.right.left = new Week6(8);
        tree.root.right.right.right = new Week6(7);
  
        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

}
