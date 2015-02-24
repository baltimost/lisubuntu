import java.util.*;

public class Tools{
    public static void print(int[] arr){
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
    public static void print(List<Integer> entry){
        for(Integer x : entry)
            System.out.print(x + " ");
        System.out.println();
    }
    public static void printll(List<List<Integer>> output){
        for(List<Integer> x : output){
            for(Integer y : x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
    public static void print(ListNode head) {
        ListNode n = head;
        while(n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }
    public static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> entry = new ArrayList<Integer>();
        entry.add(1);
        entry.add(2);
        entry.add(3);
        output.add(new ArrayList<Integer>(entry));
        entry.clear();
        entry.add(5);
        entry.add(8);
        entry.add(9);
        output.add(new ArrayList<Integer>(entry));

        print(entry);
        System.out.println("========");
        printll(output);
    }
}
