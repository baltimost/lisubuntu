public class AverageWithout{
    public static double averageWithoutMax3(int[] arr){
        if(arr == null || arr.length <= 3 || arr[0] == 0)
            return 0;
        int length = 1;
        int sum = arr[0];
        int three = 0;
        for(int i = 0;i < arr.length - 1 && arr[i + 1] != 0;i++){
            length++;
            sum += arr[i + 1];
            if(arr[i] > arr[i + 1]){
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        three = arr[length - 1];
        for(int i = 1;i < 3;i++){
            for(int j = 0;j < length - i - 1;j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            three += arr[length - 1 - i];
        }
        System.out.println(sum);
        System.out.println(three);
        System.out.println(length - 3);
        
        return (double)(sum - three) / (double)(length - 3);
    }
    public static void main(String[] args){
        //int[] input = {3,7,12,2,25,8,9,13,10,0,4,66,100};
        //System.out.println(averageWithoutMax3(input));
        int[] input = {3,7,12,2};
        System.out.println(averageWithoutMax3(input));
    }
}
