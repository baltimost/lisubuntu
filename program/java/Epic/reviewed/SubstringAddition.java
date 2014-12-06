public class SubstringAddition{
    public static int[] substringAddition(int[] arr, int sum){
        int tmpSum = 0;
        int[] output = new int[2];
        for(int i = 0, j = 0;j < arr.length;){
            if(tmpSum == sum){
                output[0] = i;
                output[1] = j;
                return output;
            }
            if(tmpSum > sum){
                tmpSum -= arr[i];
                i++;
                if(i > j) j = i;
            }
            else{
                tmpSum += arr[j];
                j++;
            }
        } 
        return output;
    }
    public static void main(String[] args){
        int[] input = {0,7,5,3,5,8,9};
        int[] rst = substringAddition(input, 16);
        System.out.println(rst[0] + "-" + rst[1]);
    }
}


