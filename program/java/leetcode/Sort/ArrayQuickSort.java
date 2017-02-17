public class ArrayQuickSort{
    public static int[] quickSort(int[] arr){
        helper(arr, 0, arr.length - 1);
        return arr;
    }
    public static void helper(int[] arr, int h, int t){
        if(h > t)
            return;
        int i = h;
        int j = t;
        int pivot = arr[i];
        while(i < j){
            while(pivot <= arr[j] && i < j)
                j--;
            if(i < j){
                arr[i] = arr[j];
                i++;
            }
                
            while(arr[i] <= pivot && i < j)
                i++;
            if(i < j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = pivot;
        helper(arr, h, i - 1);
        helper(arr, j + 1, t);
    }
    
    public static void quicksortAlt(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int l, int h) {
        if(l >= h) {
            return;
        }
        int pivot = arr[l];
        int i = l, j = h;
        while(i < j) {
            while(i < j && pivot <= arr[j]) {
                j--;
            }
            if(i < j) {
            //Why this sentence? consider 50 20 10 23 5 100 75, after first exchange
            //5 20 10 23 50 100 75, then i++
            //  i        j 
            //5 20 10 23 50 100 75, 
            //           j  i
            //see the problem now?
            System.out.println("before first swap" + "i:"+i+" j:"+j);
                swap(arr, i, j);
                i++;
            }
            while(i < j && arr[i] <= pivot) {
                i++;
            }
            if(i < j) {
            System.out.println("before second swap" + "i:"+i+" j:"+j);
                swap(arr, i, j);
                j--;
            }
        }
        partition(arr, l, i - 1);
        partition(arr, i + 1, h);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    
    public static void main(String[] args){
        //int[] test = {60, 71, 49, 11, 82, 49, 3, 66};
        //int[] test = {1,2,3,4,5,6};
        //int[] test = {0,1,0,0,1,2,0,1};
        int[] test = {5, 20, 10, 23, 50, 100, 75};

        for(int x: test)
            System.out.print(x + " ");
        System.out.println();
        quicksortAlt(test);
        for(int x: test)
            System.out.print(x + " ");
        System.out.println();
    }
}
