import java.util.List;
import java.util.ArrayList;

public class FindSquares{
    public static List<Pair> findSquares(int number){
        List<Pair> output = new ArrayList<Pair>();
        for(int i = 1;i <= number / 2;i++){
            if(isSquareNum(i) && isSquareNum(number - i))
                output.add(new Pair((int)Math.sqrt(i), (int)Math.sqrt(number - i)));
        }
        return output;
    }
    public static boolean isSquareNum(int number){
        int root = (int)Math.sqrt(number);
        return root * root == number;
    }
    public static void main(String[] args){
        for(int i = 1;i < 100000;i++){
            List<Pair> rst = findSquares(i);
            if(rst.size() >= 9){
                System.out.println(i);
                for(Pair x : rst)
                    System.out.println(x.getX() + "," + x.getY());
                System.out.println();
            }
        }
    }
}
class Pair{
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){ return x;}
    public int getY(){ return y;}
}
