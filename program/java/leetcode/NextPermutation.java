public class NextPermutation{
    public static void nextPermutation(int[] num){
        int i;
        for(i = num.length - 2;i >= 0 && num[i] > num[i + 1];i--);
        if(i != -1){
            int j = i + 1;
            for(;j < num.length && num[j] > num[i];j++);
            j--;
            swap(num, i, j);

        System.out.println("i:"+i +","+num[i]);
        System.out.println("j:"+j +","+num[j]);

        }
        reverse(num, i + 1);
    }
    public static void reverse(int[] num, int i){
        int e = num.length - 1;
        while(i < e){
            swap(num, i, e);
            i++;
            e--;
        }
    }
    public static void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args){
        //int[] input = {1, 2, 3};
        //int[] input = {2,3,6,5,4,1};
        //int[] input = {2,3,6,5,1};
        //int[] input = {2,4,3,1};
        int[] input = {4,5,3,2};
        nextPermutation(input);
        for(int x: input)
            System.out.print(x + " ");
        System.out.println();
    }
}
