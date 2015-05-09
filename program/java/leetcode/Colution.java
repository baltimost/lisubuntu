public class Colution {
    TreeNode cursor;
    public Colution(TreeNode root) {
        cursor = root;
    }

    public boolean hasNext() {
        return cursor != null;
    }

    public TreeNode next() {
        if(!hasNext()) {
            return null;
        }

        TreeNode pre = null
        while(true) {
            if(cursor.left != null) {
                pre = cursor.left;
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = cursor;
                    cursor = cursor.left;
                }
                else {
                    TreeNode output = cursor;
                    cursor = cursor.right;
                    pre.right = null;
                    return output;
                }
            }
            else {
                TreeNode output = cursor;
                cursor = cursor.right;
                return output;
            }
        }
    }
}
