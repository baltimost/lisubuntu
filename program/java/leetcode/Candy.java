public class Candy{
    public static int candy(int[] ratings){
        if(ratings == null || ratings.length == 0)
            return 0;
        int[] d = new int[ratings.length];
        for(int i = 0;i < ratings.length;i++)
            d[i] = 1;
        for(int i = 1;i < ratings.length;i++){
            if(ratings[i] > ratings[i - 1])
                d[i] = d[i - 1] + 1;
        }
        int output = d[ratings.length - 1];
        for(int i = ratings.length - 2;i >= 0;i--){
            System.out.println("i=" + i);
            if(ratings[i] > ratings[i + 1] && d[i] <= d[i + 1])
                d[i] = d[i + 1] + 1;
            output += d[i];
        }
        return output;
    }
    public static void main(String[] args){
        int[] test = {4,2,3,4,1};
        //int[] test = {7,4,3,2,8,6,0,1};
        //int[] test = {2,2};
        System.out.println(candy(test));
    }
}
