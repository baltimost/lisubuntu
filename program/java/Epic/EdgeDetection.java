import java.util.List;
import java.util.ArrayList;

class Point{
    private int x;
    private int y; 
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
public class EdgeDetection{
    public static List<Point> findEdgePoints(int[] image, int h, int threshold){
        int w = image.length / h;
        HashSet<Point> output = new HashSet<Point>();
        boolean[][] found = new boolean[w][h];
        for(int i = 0;i < w;i++){
            for(int j = 0;j < h;j++){
                if(found[i][j]) continue;
                int index = i * h + j;
                if(i + 1 < w){
                    int d = (i + 1) * h + j;
                    if(Math.abs(image[d] - image[index]) >= threshold){
                        output.add(new Point(i, j));
                        if(!found[i + 1][j])
                            output.add(new Point(i + 1, j));
                        found[i][j] = true;
                        found[i + 1][j] = true;
                    }
                }  
                if(j + 1 < h){
                    int r = (j + 1) * h + j;
                    if(Math.abs(image[r] - image[index]) >= threshold){
                        output.add(new Point(i, j));
                        if(!found[i][j + 1])
                            output.add(new Point(i, j + 1));
                        found[i][j] = true;
                        found[i][j + 1] = true;
                    }
                }  
            }
        }
        return output;
    }
    public static void main(String[] args){
        int[] input = {3,3,3,3,8,0,3,3,3};
        //int[] input = {1,3,4,5,2,4,6,3,5,6,7,3,8,7,6,5};
        List<Point> rst = findEdgePoints(input, 3, 3); 
        for(Point x : rst){
            System.out.println(x.getX() + "," + x.getY());
        }
    }
}


