import java.util.*;

public class PopulatingNextRightPointersinEachNodeII{
    /*
    public static void connect(TreeNode root){
        TreeNode parent = root;
        TreeNode leftmost = root.left != null? root.left : root.right; 
        while(leftmost != null){
            TreeNode curr = leftmost;
            while(parent != null){
                if(curr == parent.left && parent.right != null){
                    curr.next = parent.right;
                    curr = curr.next;
                }
                if(parent.next != null){
                    if(parent.next.left != null){
                        curr.next = parent.next.left;
                        curr = curr.next;
                    }
                    else if(parent.next.right != null){
                        curr.next = parent.next.right;
                        curr = curr.next;
                    }
                }
                parent = parent.next;
            }
            TreeNode n = leftmost;
            leftmost = null;
            for(;n != null;n = n.next){
                if(n.left != null){
                    parent = n;
                    leftmost = n.left;
                    break;
                }
                if(n.right != null){
                    parent = n;
                    leftmost = n.right;
                    break;
                }
            }
        }
    }
    */
    /**/
    public static void connect(TreeNode root){
        TreeNode p = root;
        TreeNode leftmost = p.left == null ? p.right : p.left; 
        while(leftmost != null){
            TreeNode curr = leftmost;
            while(p != null){
                if(curr == p.left && p.right != null){
                    curr.next = p.right;
                    curr = curr.next;
                }
                p = getNearestUnclewithchild(p.next);
                if(p != null){
                    curr.next = p.left == null ? p.right : p.left;
                    curr = curr.next;
                }
            }
            p = getNearestUnclewithchild(leftmost);
            if(p != null)
                leftmost = p.left == null ? p.right : p.left;
            else
                leftmost = null;
        }
    }
    
    private static TreeNode getNearestUnclewithchild(TreeNode uncle){
        while(uncle != null){
            if(uncle. left != null || uncle.right != null)
                return uncle;
            uncle = uncle.next;
        }
        return null;
    }
}
