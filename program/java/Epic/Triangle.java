public class Triangle{
    /*
    private static void drawTri(int height, int width) { 
        for(int i=1; i<=height; i++){ 
            //for(int j=0; j<(i*(width/height)); j++){ 
            for(int j=0; j<(i*(width * 1.0/height)); j++){ 
                System.out.print("*"); 
            } 
            System.out.print("\n"); 
        } 
    }
    */
    public static void drawTriangle(int height) { 
        StringBuilder line = new StringBuilder();
        for(int i = 0;i < height;i++){
            line.append("*");
            System.out.println(line.toString());
        }
    }
    public static void main(String[] args){
        drawTriangle(10);
    }
}
