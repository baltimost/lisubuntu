public class WordSearch{
    public static boolean exist(char[][] board, String word){
        for(int i = 0;i < board.length;i++)
           for(int j = 0;j < board[0].length;j++) 
                if(helper(board, i, j, 0, word))
                    return true;
        return false;
    }
    private static boolean helper(
            char[][] board,
            int x,
            int y,
            int start,
            String word){
        if(start == word.length()){
            System.out.println("hao");
            return true;
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(start))
            return false;
        board[x][y] = '*';
        boolean rst = helper(board, x - 1, y, start + 1, word)
            || helper(board, x + 1, y, start + 1, word)
            || helper(board, x, y + 1, start + 1, word)
            || helper(board, x, y - 1, start + 1, word);
        board[x][y] = word.charAt(start);
        return rst;
    }
    public static void main(String[] args){
        char[][] input = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        System.out.println(exist(input, "ABCCFS"));
        System.out.println(exist(input, "ABCCFS"));
        /*
        System.out.println(exist(input, "DEE"));
        for(char[] x : input){
            for(char y : x)
                System.out.print(y + " ");
            System.out.println();
        }
        */
    }
}
