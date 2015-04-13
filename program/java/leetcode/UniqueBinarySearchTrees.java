public class UniqueBinarySearchTrees{
    public static int numTrees(int n){
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2;i < d.length;i++){
            for(int j = 0;j < i;j++){
                int left = d[j];
                int right = d[i - j - 1];
                d[i] += left * right; 
            }
        }
        return d[d.length - 1];
    }
    public static void main(String[] args){
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
    }
}
