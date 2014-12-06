import java.util.*;

class UndirectedGraphNode{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class CloneGraph{
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        hm.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            for(UndirectedGraphNode x: current.neighbors){
                if(!hm.containsKey(x)){
                    queue.offer(x);
                    hm.put(x, new UndirectedGraphNode(x.label));
                }
                hm.get(current).neighbors.add(hm.get(x));
            }
        }
        /*
        for(Iterator i = hm.keySet().iterator();i.hasNext();){
            UndirectedGraphNode key = (UndirectedGraphNode)i.next();
            for(UndirectedGraphNode x: key.neighbors){
                hm.get(key).neighbors.add(hm.get(x));
            }
        }
        */
        return hm.get(node);
    }
    public static void graphTraversal(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> hs = new HashSet<UndirectedGraphNode>();
        hs.add(node);
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            System.out.println(current.label);
            for(UndirectedGraphNode x: current.neighbors){
                if(!hs.contains(x)){
                    queue.offer(x);
                    hs.add(x);
                }
            }
        }
    }
    public static void main(String[] args){
        String sgraph = "0123#1234#26#35#4#56#6"; 
        String[] node = sgraph.split("#");
        HashMap<Integer, UndirectedGraphNode> nodelist = new HashMap<Integer, UndirectedGraphNode>();
        for(int i = 0;i < node.length;i++){
            int label = node[i].charAt(0) - '0';
            if(nodelist.get(label) == null)
                nodelist.put(label, new UndirectedGraphNode(label));
            for(int j = 1;j < node[i].length();j++){
                int neighbor = node[i].charAt(j) - '0';
                System.out.println("node:"+label+" neigbor:"+neighbor);
                if(nodelist.get(neighbor) == null)
                    nodelist.put(neighbor, new UndirectedGraphNode(neighbor));
                nodelist.get(label).neighbors.add(nodelist.get(neighbor));
                nodelist.get(neighbor).neighbors.add(nodelist.get(label));
            }
        }
        graphTraversal(nodelist.get(0));

        UndirectedGraphNode output = cloneGraph(nodelist.get(0));
        System.out.println("..");
        graphTraversal(output);
        System.out.println("..");
    }
}
