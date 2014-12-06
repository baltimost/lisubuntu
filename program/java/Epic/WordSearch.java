import java.util.List;
import java.util.ArrayList;
public class WordSearch{
    public List<List<Coor>> wordSearch(char[][] matrix, String str){
        List<List<Coor>> output = new ArrayList<List<Coor>>();
        List<Coor> entry = new ArrayList<Coor>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++)
                helper(matrix, str, 0, i, j, entry, output); 
        }
        return output;
    }
    private void helper(char[][] matrix, String str, int start, int x, int y, List<Coor> entry, List<List<Coor>> output){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != str.charAt(start))
            return;
        entry.add(new Coor(x, y));
        if(start == str.length() - 1){
            output.add(new ArrayList<Coor>(entry));
            entry.remove(entry.size() - 1);
            return;
        }
        matrix[x][y] = '*';
        helper(matrix, str, start + 1, x - 1, y, entry, output); 
        helper(matrix, str, start + 1, x + 1, y, entry, output); 
        helper(matrix, str, start + 1, x, y - 1, entry, output); 
        helper(matrix, str, start + 1, x, y + 1, entry, output);
        entry.remove(entry.size() - 1);
        matrix[x][y] = str.charAt(start);
    }
    public static void main(String[] args){
        char[][] matrix = {
            {'a','b','c','d'},
            {'e','f','j','h'},
            {'i','j','n','o'},
            {'m','n','o','p'}
        };
        WordSearch ws = new WordSearch();
        List<List<Coor>> rst = ws.wordSearch(matrix, "fjn");
        for(List<Coor> list : rst){
            for(Coor coor : list)
                System.out.print(coor.x + "," + coor.y + " ");
            System.out.println();
        }
    }
}

class Coor{
    public int x, y;
    public Coor(int x, int y){
        this.x = x;
        this.y = y;
    }
}
