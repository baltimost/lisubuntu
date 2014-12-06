import java.util.List;
import java.util.ArrayList;

public class SquarePermutation{
    public static List<Point[]> squarePerm(Point O, int area){
        List<Point[]> output = new ArrayList<Point[]>();
        List<Point> squares = findSquareNum(area);
        List<Point> factors = findMultiplier(area);
        int offsX = O.getX();
        int offsY = O.getY();
        //Generate All point group from square;
        for(Point square : squares){
            for(int c = 0;c < 2;c++){
                Point curr = square;
                if(c == 1){
                    if(curr.getX() == curr.getY()) break;
                    curr = new Point(square.getY(), square.getX());
                }
                for(int i = 0;i < 4;i++){
                    output.add(sPoint2Three(curr, offsX, offsY));
                    curr = output.get(output.size() - 1)[2];
                }
            }
        }
        //Generate All point group from factor;
        for(Point factor : factors){
            for(int c = 0;c < 2;c++){
                Point curr = factor;
                if(c == 1){
                    if(curr.getX() == curr.getY()) break;
                    curr = new Point(factor.getY(), factor.getX());
                }
                output.add(fPoint2Three(curr, offsX, offsY));
                output.add(fPoint2Three(new Point(curr.getX(), -curr.getY()), offsX, offsY));
                output.add(fPoint2Three(new Point(-curr.getX(), -curr.getY()), offsX, offsY));
                output.add(fPoint2Three(new Point(-curr.getX(), curr.getY()), offsX, offsY));
            }
        }
        return output;
    }
    public static Point[] sPoint2Three(Point square, int offsX, int offsY){
        Point[] output = new Point[3];
        int x = square.getX();
        int y = square.getY();
        output[0] = new Point(x + offsX, y + offsY);
        output[1] = new Point(x + y + offsX, y - x + offsY);
        output[2] = new Point(y + offsX, - x + offsY);
        return output;
    }
    public static Point[] fPoint2Three(Point factor, int offsX, int offsY){
        Point[] output = new Point[3];
        int x = factor.getX();
        int y = factor.getY();
        output[0] = new Point(x + offsX, y + offsY);
        output[1] = new Point(x + offsX, 0 + offsY);
        output[2] = new Point(0 + offsX, y + offsY);
        return output;
    }
    
    private static List<Point> findSquareNum(int area){
        List<Point> output = new ArrayList<Point>();
        for(int i = 1;i <= area / 2;i++){
            if(isSquareNum(i) && isSquareNum(area - i))
                output.add(new Point((int)Math.sqrt(i), (int)Math.sqrt(area - i)));
        }
        return output;
    }
    private static boolean isSquareNum(int number){
        int root = (int)Math.sqrt(number);
        return root * root == number;
    }

    private static List<Point> findMultiplier(int area){
        List<Point> output = new ArrayList<Point>();
        for(int i = 1;i <= area / i;i++){
            if(area % i == 0)
                output.add(new Point(i, area / i));
        }
        return output;
    }
    public static void main(String[] args){
        Point origin = new Point(0, 0);
        List<Point[]> rst = squarePerm(origin, 18);
        for(Point[] x : rst){
            for(Point y : x)
                System.out.print(y.getX()+","+y.getY()+"   ");
            System.out.println();
        }
    }
}

class Point{
    int x, y;
    public Point(int x, int y){ 
        this.x = x;
        this.y = y;
    }
    public int getX(){ return x;}
    public int getY(){ return y;}
}
