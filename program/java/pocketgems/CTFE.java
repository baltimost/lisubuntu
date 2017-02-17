public class CTFE {
    public static TreeNode construct(String exp) {
        if(exp == null || exp.length() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(exp.charAt(0));
        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        for(int i = 1;i < exp.length();i += 2) {
            if(exp.charAt(i) == '?') {
                s.push(cur);
                cur.left = new TreeNode(exp.charAt(i + 1));
                cur = cur.left;
            }
            else {
                cur = s.pop();
                cur.right = new TreeNode(exp.charAt(i + 1));
                cur = cur.right;
            }
        }
        return root;
    }
}
