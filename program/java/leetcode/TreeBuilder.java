import java.util.*;

public class TreeBuilder{
    //char[] input = {'A','B','C',' ',' ','D','E',' ','G',' ',' ','F',' ',' ',' '}; 
    //public TreeNode create(char[] input){
    static int[] input;
    static int i = 0;
    public static TreeNode create(int[] input){
        if(input[i] == ' '){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(input[i]);
        i++;
        root.left = create(input);
        root.right = create(input);
        return root;
    }
    public static void main(String[] args){
        TreeBuilder tb = new TreeBuilder();
        int[] commonArr = {1,2,4,' ',' ',5,' ',' ',3,6,' ',' ',7,' ',' '}; 
        TreeNode commonRoot =  tb.create(commonArr);

        /*Populating*/
        /*
        int[] input1 = {'A','B','C',' ',' ','D','E',' ','G',' ',' ','F',' ',' ',' '}; 
        int[] input2 = {'A','B','C',' ',' ','D','E',' ','G',' ',' ','F',' ',' ',' '}; 
        int[] populating = {'1','2','4',' ',' ','5',' ',' ','3','6',' ',' ','7',' ',' '}; 
        //int[] populatingII = {1,2,4,' ',' ',5,' ',' ',3,' ',7,' ',' '}; 
        int[] populatingII = {1,2,3,' ',' ',' ',4,' ',5,' ',6,' ',' '}; 
        TreeNode root =  tb.create(populatingII);
        PopulatingNextRightPointersinEachNodeII.connect(root);
        TreeNode h = root;
        //System.out.println((char)h.val);
        while(h != null){
            TreeNode n = h;
            while(n != null){
                System.out.print(n.val + " ");
                n = n.next;
            } System.out.println();
            h = h.left;
        }
        */
        /*
        */
        /*Populating*/


        //ArrayList<Integer> output = BinaryTreePreorderTraversal.preorderTraversal(root); 
        //ArrayList<Integer> output = BinaryTreeInorderTraversal.inorderTraversal(root); 
        //ArrayList<Integer> output = BinaryTreePostorderTraversal.postorderTraversal(root); 
        //ArrayList<Integer> output = BinaryTreeLevelorderTraversal.levelOrderTraversal(root); 
        /*
        for(Integer x:output){
            int tmp = x.intValue();
            System.out.println((char)tmp);
        }
        */
        /*Level Order

        ArrayList<ArrayList<Integer>> output = BinaryTreeLevelorderTraversal.levelOrder(commonRoot); 
        for(ArrayList<Integer> x:output){
            for(Integer y:x){
                int tmp = y.intValue();
                System.out.print(tmp);
            }
            System.out.println();
        }
        Level Order*/
        ArrayList<ArrayList<Integer>> output = BinaryTreeZigzagLevelorderTraversal.zigzagLevelOrder(commonRoot); 
        for(ArrayList<Integer> x:output){
            for(Integer y:x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
        /* IsSameTree?
        TreeNode root2 =  tb.create(input2);
        System.out.println(SameTree.isSameTree(root,root2));
        */
        /*BalancedBinaryTree*/
        //char[] input1 = {'A','B','C',' ',' ','D','E',' ','G',' ',' ','F',' ',' ',' '}; 
        //char[] input1 = {'A','B','C',' ',' ',' ','D',' ','E',' ',' '};
        /*
        char[] input1 = {'1',' ','2',' ','3',' ',' '}; 
        TreeNode root = tb.create(input1);
        System.out.println(BalancedBinaryTree.isBalanced(root));
        */
        /*BalancedBinaryTree*/
        
        /*Recover Binary Search Tree*/
        /*
        //char[] input1 = {'4','2','1',' ',' ','3',' ',' ','5','6',' ',' ','8','7',' ',' ','9',' ',' '};
        int[] input1 = {1, 2,4,' ', ' ',5,' ',' ',3,' ',' '};
        TreeNode root = tb.create(input1);
        ArrayList<Integer> output = BinaryTreeInorderTraversal.inorderTraversal(root); 
        for(Integer x:output){
            int tmp = x.intValue();
            System.out.print((char)tmp + " ");
        }
        System.out.println();

        //RecoverBinarySearchTree.recoverTree(root);
        System.out.println("root=" + root.val);


        output.clear();
        output = BinaryTreeInorderTraversal.inorderTraversal(root); 
        for(Integer x:output){
            int tmp = x.intValue();
            System.out.print((char)tmp + " ");
        }
        System.out.println();
        /*Recover Binary Search Tree*/

        //PathSumII
        /*
        int[] input = {5,4,11,7,' ',' ',2,' ',' ',' ', 8,13,' ',' ',4,5,' ',' ',1,' ',' '};
        //int[] input = {5,4,' ',' ',8,' ',' '};
        TreeNode root = tb.create(input);
        List<Integer> output1 = BinaryTreePreorderTraversal.preorderTraversal(root); 
        for(Integer x: output1)
            System.out.print(x + " ");
        System.out.println();
        List<List<Integer>> output = PathSumII.pathSum(root, 22);
        for(List<Integer> x: output){
            for(Integer y: x)
                System.out.print(y + " ");
            System.out.println();
        }
        */
        //PathSumII
        
        //Flatten
        /*
        int[] input = {1,2,3,' ',' ',4,' ',' ',5,' ',6,' ',' '};
        TreeNode root = tb.create(input);
        FlattenBinaryTreetoLinkedList.flatten(root);
        System.out.println("=======");
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println("=======");
        */
        //Flatten
        //Binary Tree Maximum path sum
        /*
        int[] input = {63,1,8,1009,' ',' ',700,' ',2000,' ',' ',7,9999,' ',' ',' ',13,1000,' ',3,' ',' ',100,' ',705,' ',' '};
        //int[] input = {1,2,' ',' ',3,' ',' '}; 
        //int[] input = {1,' ',' '};

        TreeNode root = tb.create(input);
        List<Integer> output = BinaryTreePreorderTraversal.preorderTraversal(root); 
        for(Integer x: output)
            System.out.print(x + " ");
        System.out.println();
        System.out.println(BinaryTreeMaximumPathSum.maxPathSum(root));
        */

        //Binary Tree Maximum path sum
        
        //Validate BinarySearchTree
        /*
        int[] input = {20,10,5,3,' ',' ',7,' ',' ',15,' ',20,' ',' ',30,' ',' '};
        //int[] input = {2,2,' ',' ',' '};
        //int[] input = {2,' ',2,' ',' '};
        TreeNode root = tb.create(input);
        System.out.println(ValidateBinarySearchTree.isBinarySearchTree(root));
        */
        //Validate BinarySearchTree

        //Sum Root to Leaf
        /*
        int[] input = {0,1,' ',' ',3,' ',' '};
        //int[] input = {0,1,' ',' ',' '};
        //int[] input = {1,2,' ',' ',3,' ',' '};
        TreeNode root = tb.create(input);
        SumRoottoLeafNumbers srln = new SumRoottoLeafNumbers();
        System.out.println(srln.sumNumbers(root));
        */
        //Sum Root to Leaf
    }
}
