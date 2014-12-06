public MaxDepthofBinaryTree{
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        else{
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            int d = ((l > r) ? l : r) +1;
            return d;
        }
    }
    public static void main(String[] args){
        ;
    }
}
