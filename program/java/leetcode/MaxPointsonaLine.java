import java.util.*;

class Point{
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class MaxPointsonaLine{
    public static int maxPoints(Point[] points){
        if(points == null || points.length == 0)
            return 0;
        Map<Double, Integer> m = new HashMap<Double, Integer>();
        int output = Integer.MIN_VALUE;
        int dup = 0;
        for(int i = 0;i < points.length;i++){
            m.clear();
            dup = 0;
            m.put(Double.MIN_VALUE, 1);
            for(int j = i + 1;j < points.length;j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    dup++;
                    continue;
                }

                double k;
                if(points[j].x - points[i].x == 0)
                    k = Integer.MAX_VALUE;
                else{
                    k = 0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                }
                if(m.containsKey(k))
                    m.put(k, m.get(k) + 1);
                else
                    m.put(k, 2);
            }
            for(Integer x: m.values()){
                output = Math.max(output, x + dup);
            }
        }
        return output;
    }
    public static int maxPointsAlt(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        Map<Double, Integer> m = new HashMap<Double, Integer>();
        int output = 1;
        int dup = 0;
        int con = 0; 
        double k = 0;
        for(int i = 0;i < points.length;i++){
            m.clear();
            dup = 0;
            con = 0;
            for(int j = i + 1;j < points.length;j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                    dup++;
                else {
                    if(points[i].x == points[j].x)
                        k = Double.MAX_VALUE;
                    else
                        k = 0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                        
                    m.put(k, m.get(k) == null ? 1 : m.get(k) + 1);
                }
                con = Math.max(con, m.get(k) == null ? 0 : m.get(k));
            }
            output = Math.max(output, con + dup + 1);
        }
        return output;
    }
    public static void main(String[] args){
        //Point[] test = {new Point(2,1), new Point(3,2), new Point(4,3), new Point(1,4), new Point(5,1)};
        //Point[] test = {new Point(2,3), new Point(3,3), new Point(-5,3)};
        /*
        Point[] test2 = {new Point(1,1), new Point(1,1)};

        System.out.println(maxPoints(test2));
        System.out.println(maxPointsAlt(test2));

        Point[] test = {new Point(0,0), new Point(1,1), new Point(0,0)};
        System.out.println(maxPoints(test));
        System.out.println(maxPointsAlt(test));

        Point[] test3 = {new Point(0,0)};
        System.out.println(maxPoints(test3));
        System.out.println(maxPointsAlt(test3));
        */

        Point[] test4 = {new Point(560,248), new Point(210,103),new Point(700,306),new Point(-106,-146),new Point(560,248)};
        System.out.println(maxPoints(test4));
        System.out.println(maxPointsAlt(test4));
    }
}
