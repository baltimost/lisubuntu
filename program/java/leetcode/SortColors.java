public class SortColors{
    public static void sortColors(int[] a){
        int l = 0;
        int r = a.length - 1;
        for(int i = 0;i <= r;){
            if(a[i] == 0){
                swap(a, l, i);
                l++;
                i++;
            }
            else if(a[i] == 2){
                swap(a, r, i);
                r--;
            }
            else
                i++;
        }
        System.out.println("l:"+l+"r:"+r);
    }
    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args){
        //int[] input = {1,2,0};
        int[] input = {0,1,0,0,1,2,0,1};
        sortColors(input);
        for(int x: input)
            System.out.print(x + " ");
        System.out.println();
    }
}
