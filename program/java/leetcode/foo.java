import java.util.*;

public class LRUCache{
    /*
    private int capacity;
    HashMap<Integer, Integer> hm;
    Queue<Integer> queue;
    public LRUCache(int capacity){
        this.capacity = capacity;
        hm = new HashMap<Integer, Integer>();
        queue = new LinkedList<Integer>();
    }
    public int get(int key){
        if(hm.get(key) == null)
            return -1;
        else{
            queue.remove(key);
            queue.offer(key);
            return hm.get(key);
        }
    }
    public void set(int key, int value){
        if(hm.get(key) == null){
            if(hm.size() == capacity)
                hm.remove(queue.poll());
        }
        else
            queue.remove(key);

        hm.put(key, value);
        queue.offer(key);
    }
    */
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    HashMap<Integer, Node> hm;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        hm = new HashMap<Integer, Node>();
        head = null; 
        tail = null;
    }

    public int get(int key){
        Node node = hm.get(key);
        if(node == null)
            return -1;
        else{
            if(node == head && node != tail)
                head = head.next;
            if(node != tail){
                node.prev.next = node.next;
                tail.next = node;
                node.next = null;
                node.prev = tail;
                tail = node;
            }
            return node.value;
        }
    }

    public void set(int key, int value){
        Node node = hm.get(key);
        if(node == null){
            node = new Node(key, value);
            if(head == null){
                head = node;
                tail = node;
            }
            if(hm.size() == capacity){
                hm.remove(head.key);
                head = head.next;
            }
        }
        else{
            if(node == head && node != tail)
                head = head.next;
            node.value = value; 
            if(node == tail){
                hm.put(key, node);
                return;
            }
            node.prev.next = node.next;
        }
        tail.next = node;
        node.next = null;
        node.prev = tail;
        tail = node;
        hm.put(key, node);
    }
    public void traverse(){
        /*
        Node cur = head;
        while(cur != null){
            System.out.println("key:"+cur.key+" value:"+cur.value);
            cur = cur.next;
        }
        System.out.println("___");
        */
    }

    public static void main(String[] args){
        LRUCache lrucache = new LRUCache(10);
        lrucache.set(10,13);
        lrucache.traverse();
        lrucache.set(3,17);
        lrucache.traverse();
        lrucache.set(6,11);
        lrucache.traverse();
        lrucache.set(10,5);
        lrucache.traverse();
        lrucache.set(9,10);
        lrucache.traverse();
        System.out.println(lrucache.get(13));
        lrucache.traverse();
        lrucache.set(2,19);
        lrucache.traverse();
        System.out.println(lrucache.get(2));
        lrucache.traverse();
        System.out.println(lrucache.get(3));
        lrucache.traverse();
        lrucache.set(5,25);
        lrucache.traverse();
        System.out.println(lrucache.get(8));
        lrucache.traverse();
        lrucache.set(9,22);
        lrucache.traverse();
        lrucache.set(5,5);
        lrucache.traverse();
        lrucache.set(1,30);
        lrucache.traverse();
        System.out.println(lrucache.get(11));
        lrucache.traverse();
        lrucache.set(9,12);
        lrucache.traverse();
        System.out.println(lrucache.get(7));
        lrucache.traverse();
        System.out.println(lrucache.get(5));
        lrucache.traverse();
        System.out.println(lrucache.get(8));
        lrucache.traverse();
        System.out.println(lrucache.get(9));
        lrucache.traverse();
        lrucache.set(4,30);
        lrucache.traverse();
        lrucache.set(9,3);
        lrucache.traverse();
        System.out.println(lrucache.get(9));
        lrucache.traverse();
        System.out.println(lrucache.get(10));
        lrucache.traverse();
        System.out.println(lrucache.get(10));
        lrucache.traverse();
        lrucache.set(6,14);
        lrucache.traverse();
        lrucache.set(3,1);
        lrucache.traverse();
        System.out.println(lrucache.get(3));
        lrucache.traverse();
        lrucache.set(10,11);
        lrucache.traverse();
        System.out.println(lrucache.get(8));
        lrucache.traverse();
        lrucache.set(2,14);
        lrucache.traverse();
        System.out.println(lrucache.get(1));
        lrucache.traverse();
        System.out.println(lrucache.get(5));
        lrucache.traverse();
        System.out.println(lrucache.get(4));
        lrucache.traverse();
        lrucache.set(11,4);
        lrucache.traverse();
        lrucache.set(12,24);
        lrucache.traverse();
        lrucache.set(5,18);
        lrucache.traverse();
        System.out.println(lrucache.get(13));
        lrucache.traverse();
        lrucache.set(7,23);
        lrucache.traverse();
        System.out.println(lrucache.get(8));
        lrucache.traverse();
        System.out.println(lrucache.get(12));
        lrucache.traverse();
        lrucache.set(3,27);
        lrucache.traverse();
        lrucache.set(2,12);
        lrucache.traverse();
        System.out.println(lrucache.get(5));
        lrucache.traverse();
        lrucache.set(2,9);
        lrucache.traverse();
        lrucache.set(13,4);
        lrucache.traverse();
        lrucache.set(8,18);
        lrucache.traverse();
        lrucache.set(1,7);
        lrucache.traverse();
        System.out.println(lrucache.get(6));
        lrucache.traverse();
    }
}
