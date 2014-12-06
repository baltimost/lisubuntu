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
            if(node != tail){
                if(node == head){
                    head = head.next;
                    head.prev = null;
                }
                else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            traverse();
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
                head = head == tail ? node : head.next;
                head.prev = null;
            }
        }
        else{
            node.value = value;
            if(node != tail){
                if(node == head){
                    head = head.next;
                    head.prev = null;
                }
                else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
            }
        }
        if(node != tail){
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        hm.put(key, node);
        traverse();
    }
    public void traverse(){
        /*
        Node cur = head;
        while(cur != null){
            try{
                Thread.sleep(100);
            }catch(Exception e){
                ;
            }
            System.out.println("key:"+cur.key+" value:"+cur.value);
            cur = cur.next;
        }
        System.out.println("___");
        */
    }

    public static void main(String[] args){
        LRUCache lrucache = new LRUCache(10);
        lrucache.set(10,13);
        lrucache.set(3,17);
        lrucache.set(6,11);
        lrucache.set(10,5);
        lrucache.set(9,10);
        System.out.println(lrucache.get(13));
        lrucache.set(2,19);
        System.out.println(lrucache.get(2));
        System.out.println(lrucache.get(3));
        lrucache.set(5,25);
        System.out.println(lrucache.get(8));
        lrucache.set(9,22);
        lrucache.set(5,5);
        lrucache.set(1,30);
        System.out.println(lrucache.get(11));
        lrucache.set(9,12);
        System.out.println(lrucache.get(7));
        System.out.println(lrucache.get(5));
        System.out.println(lrucache.get(8));
        System.out.println(lrucache.get(9));
        lrucache.set(4,30);
        lrucache.set(9,3);
        System.out.println(lrucache.get(9));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(10));
        lrucache.set(6,14);
        lrucache.set(3,1);
        System.out.println(lrucache.get(3));
        lrucache.set(10,11);
        System.out.println(lrucache.get(8));
        lrucache.set(2,14);
        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(5));
        System.out.println(lrucache.get(4));
        lrucache.set(11,4);
        lrucache.set(12,24);
        lrucache.set(5,18);
        System.out.println(lrucache.get(13));
        lrucache.set(7,23);
        System.out.println(lrucache.get(8));
        System.out.println(lrucache.get(12));
        lrucache.set(3,27);
        lrucache.set(2,12);
        System.out.println(lrucache.get(5));
        lrucache.set(2,9);
        lrucache.set(13,4);
        lrucache.set(8,18);
        lrucache.set(1,7);
        System.out.println(lrucache.get(6));
        /*
        LRUCache lrucache = new LRUCache(1);
        lrucache.set(2,1);
        System.out.println(lrucache.get(2));
        lrucache.set(3,2);
        System.out.println(lrucache.get(2));
        System.out.println(lrucache.get(3));
        */
    }
}
