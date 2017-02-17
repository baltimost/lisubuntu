import java.util.*;

public class SlidingWindow {
    public static int[] slidingMax(int[] A, int w) {  
        int n = A.length;  
        w = Math.min(n, w);  
        int k = n - w + 1;  
        int[] max = new int[k];  
        Deque<Integer> deq = new ArrayDeque<>();  
        for(int i=0; i<n; i++) {  
            while(!deq.isEmpty() && A[deq.getLast()] <= A[i]) { // A[deq.getLast()] >= A[i] for slidingMin  
                deq.removeLast();  
            }  
            deq.addLast(i);  
            if(i < w-1) continue;  
            while(!deq.isEmpty() && i-w>=deq.getFirst()) {  
                deq.removeFirst();  
            }  
            max[i-w+1] = A[deq.getFirst()];  
        }  
        return max;  
    }  
    
    public static void maxSlidingWindow(int A[], int n, int w, int B[]) {
        Deque<Integer> Q = new ArrayDeque<Integer>();
        for(int i = 0;i < w;i++) {
            while(Q.size() > 0 && A[i] <= A[Q.peekLast()])
                Q.pollLast();
            Q.addLast(i);
        }
        for(int i = w;i < n;i++) {
            B[i - w] = A[Q.peekFirst()];
            while(Q.size() > 0 && A[i] <= A[Q.peekLast()])
                Q.pollLast();
            while(Q.size() > 0 && Q.peekFirst() <= i - w)
                Q.pollFirst();
            Q.addLast(i);
        }
        B[n - w] = A[Q.peekFirst()];
    }

    public static int[] max(int A[], int w) {
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] output = new int[A.length];
        for(int i = 0;i < A.length;i++) {
            while(!deque.isEmpty() && A[deque.peekLast()] <= A[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i < w - 1) continue;
            if(!deque.isEmpty() && deque.peekFirst() == i - w) {
                deque.pollFirst();
            }
            output[i - w + 1] = A[deque.peekFirst()];
        }
        for(int i = A.length;i < A.length + w - 1;i++) {
            if(!deque.isEmpty() && deque.peekFirst() == i - w) {
                deque.pollFirst();
            }
            output[i - w + 1] = A[deque.peekFirst()];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        //int[] A = {9,8,7,6,5,4,3,2,1};
        //int[] A = {9,8,7,6,5,4,3,2,1};
        //int[] A = {4,4,7,5,3,2,6,1,3};
        //int[] A = {1,3,5,7,3,4,2,9};
        for(int x : A) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] rst = slidingMax(A, 3);
        for(int x : rst) {
            System.out.print(x + " ");
        }
        System.out.println("======================");

        int[] rst2 = max(A, 3); 
        for(int x : rst2) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
