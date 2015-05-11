import java.util.*;

public class CommonTree {
    public static List<Node> getLargestCommonSubtrees(Node root) {
        HashMap<String, List<Node>> hm = new HashMap<String, List<Node>>();
        List<Node> output = new ArrayList<Node>();
        helper(root, hm, output);
        Set<String> s = hm.keySet();
        for(String x : s) {
            List<Node> list = hm.get(x);
            for(Node y : list) {
                System.out.print(y.id + " ");
            }
            System.out.println();
        }
        return output;
    }
    private static String helper(Node root, HashMap<String, List<Node>> hm, List<Node> output) {
        String serial;
        if(root.children.size() == 0) {
            serial = "0";
        }
        else {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for(int i = 0;i < root.children.size();i++) {
                sb.append(i + "[" + helper(root.children.get(i), hm, output) + "],");
                sum += root.children.get(i).sum;
            }
            root.sum += sum;
            serial = sb.toString();
        }
        if(hm.containsKey(serial)) {
            List<Node> value = hm.get(serial);
            value.add(root);
         
            if(output.size() == 0 || value.get(0).sum >= output.get(0).sum) {
                if(output.size() != 0 && value.get(0).sum > output.get(0).sum) {
                    output.clear();
                }
                output.addAll(value);
            }
        }
        else {
            List<Node> value = new ArrayList<Node>();
            value.add(root);
            hm.put(serial, value);
        }
        System.out.println(serial);
        return serial;
    }
    public static void main(String[] args) {
        /*
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        root.children.add(node1);
        root.children.add(node2);
        */
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n3.children.add(n5);
        n3.children.add(n6);
        n4.children.add(n7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        n5.children.add(n8);
        n6.children.add(n9);
        n7.children.add(n10);
        n7.children.add(n11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);
        Node n15 = new Node(15);
        Node n16 = new Node(16);
        n8.children.add(n12);
        n8.children.add(n13);
        n9.children.add(n14);
        n9.children.add(n15);
        n11.children.add(n16);
        Node n17 = new Node(17);
        Node n18 = new Node(18);
        n12.children.add(n17);
        n15.children.add(n18);



        List<Node> result = getLargestCommonSubtrees(n1); 
        System.out.println("Results:");
        for(Node n : result) {
            System.out.println(n.id);
        }
    }

    static class Node {
        private final int id;
        public final List<Node> children;
        public int sum; 

        Node(int id) {
            this.id = id;
            this.children = new ArrayList<>();
            sum = 1;
        }
    }

}
