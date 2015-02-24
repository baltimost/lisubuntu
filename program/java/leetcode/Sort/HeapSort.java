import java.util.PriorityQueue;

public class HeapSort{
    public static void heapsortNav(int[] arr){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int x : arr)
            q.offer(x);
        for(int i = 0;i < arr.length;i++)
            arr[i] = q.poll();
    }
    public static void heapsort(int[] arr){
        //initialize heap
        for(int i = arr.length / 2 - 1;i >= 0;i--){
            heaptify(arr, i, arr.length);
        }
            for(int l = 0;l < arr.length;l = l * 2 + 1){
                for(int j = l;j < l * 2 + 1;j++)
                    System.out.print(arr[j] + " ");
                System.out.println();
            }

        for(int i = arr.length;i >= 1;i--){
            swap(arr, 0, i - 1);
            heaptify(arr, 0, i - 1);
            for(int l = 0;l < arr.length;l = l * 2 + 1){
                for(int j = l;j < l * 2 + 1;j++)
                    System.out.print(arr[j] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void heaptify(int[] arr, int s, int e){
        int i = s;
        int j = i * 2 + 1;
        while(j < e) {
            if(j + 1 < e && arr[j + 1] < arr[j])
                j++;
            if(arr[i] >= arr[j]) break;
            swap(arr, i, j);
            i = j;
            j = i * 2 + 1;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        //int[] arr = {7,12,3,15,5,2};
        int[] arr = {100,50,25,30,40,15,16,35,21,15,13,8,1,0,4};
        /*
        heapsortNav(arr);
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
        */
        heapsort(arr);
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}
