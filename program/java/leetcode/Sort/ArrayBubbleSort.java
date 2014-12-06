public class ArrayBubbleSort{
    public static void arrayBubbleSort(int[] arr){
        //for(int i = arr.length;i > 0;i--){
        //    for(int j = 0; j < i - 1;j++){
        for(int i = 0;i < arr.length;i++){
            for(int j = 0; j < arr.length - i - 1;j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] input = {3,7,12,2,25,8,9,13,10,0};
        arrayBubbleSort(input);
        for(int x : input)
            System.out.print(x + " ");
        System.out.println();
    }
}
