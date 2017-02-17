public class TwoFS {
    public void DFS(Node root) {
        if(root == null) {
            return;
        }
        visit(root);
        root.visited = true;
        for(Node n : root.adjacent) {
            if(!n.visited) {
                DFS(n);
            }
        }
    }

    public void BFS(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if(root == null) {
            return;
        }
        visit(root);
        root.visited = true;
        q.push(root);
        while(!q.isEmpty()) {
            Node r = q.poll();
            for(Node n : r.adjacent) {
                if(!n.visited) {
                    visit(n);
                    n.visited = true;
                    q.offer(n);
                }
            }
        }
    }
}
