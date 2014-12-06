public class EditDistance{
    public static int minDistance(String word1,String word2){
        int[][] d = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0;i < d[0].length;i++)
            d[0][i] = i;
        for(int i = 0;i < d.length;i++)
            d[i][0] = i;
        for(int i = 1;i < d.length;i++){
            for(int j = 1;j < d[0].length;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    d[i][j] = d[i - 1][j - 1];
                else{
                    d[i][j] = Math.min(d[i - 1][j], d[i][j - 1]);
                    d[i][j] = Math.min(d[i][j], d[i - 1][j - 1]);
                    d[i][j]++;
                }
            }
        }
        return d[word1.length()][word2.length()];
    }
    public static void main(String[] args){
        System.out.println(minDistance("a", "a"));
    }
}
