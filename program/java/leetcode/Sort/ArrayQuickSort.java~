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
    public static void main(String[] args){
        //int[] test = {60, 71, 49, 11, 82, 49, 3, 66};
        //int[] test = {1,2,3,4,5,6};
        int[] test = {0,1,0,0,1,2,0,1};

        for(int x: test)
            System.out.print(x + " ");
        System.out.println();
        quickSort(test);
        for(int x: test)
            System.out.print(x + " ");
        System.out.println();
    }
}
