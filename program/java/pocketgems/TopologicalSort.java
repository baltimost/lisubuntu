import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        GraphList gl = new GraphList();
        //String[] strs = {"ab","bc","cd"};
        //String[] strs = {"fbz", "bj", "ebj"};
        //String[] strs = {"cba", "bd", "ce", "ed"};
        String[] strs = {"5231","50","40","41"};
        System.out.println(sort(strs));
    }

    public static String sort(String[] strs) {
        Map<Character, GraphNode> m = new GraphList().create(strs);
        Stack<GraphNode> s = new Stack<GraphNode>();
        for(Character c : m.keySet()) {
            helper(m.get(c), s);
        }
        StringBuilder output = new StringBuilder();
        while(!s.isEmpty()) {
            output.append(s.pop().val);
        }
        return output.toString();
    }

    public static void helper(GraphNode node, Stack<GraphNode> s) {
        if(node.visited) {
            return;
        }
        node.visited = true;
        for(GraphNode n : node.adjacent) {
            if(!n.visited) {
                helper(n, s);
            }
        }
        s.push(node);
    }
}

class GraphNode {
    char val;
    Set<GraphNode> adjacent;
    boolean visited;
    public GraphNode(char val) {
        this.val = val;
        adjacent = new HashSet<GraphNode>();
    }
}

class GraphList {
    Map<Character, GraphNode> m;
    public GraphList() {
        m = new HashMap<Character, GraphNode>();
    }

    public Map<Character, GraphNode> create(String[] strs) {
        for(String str : strs) {
            if(str == null || str.length() == 0) {
                continue;
            }
            char c = str.charAt(0);
            GraphNode n = m.containsKey(c) ? m.get(c) : new GraphNode(c);
            m.put(c, n);
            for(int i = 1;i < str.length();i++) {
                c = str.charAt(i);
                GraphNode cur = m.containsKey(c) ?
                    m.get(c) : new GraphNode(c);
                n.adjacent.add(cur);
                n = cur;
                m.put(c, n);
            }
        }
        return m;
    }
}
