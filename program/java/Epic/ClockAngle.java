public class ClockAngle{
    public static double clockangle(int h, int m){
        double hdegree = (360.0 / 12 * h + 360.0 / 60 / 12 * m) % 360;
        double mdegree = (360.0 / 60 * m) % 360 ;
        double output = Math.abs(hdegree - mdegree);
        return output > 180 ? 360.0 - output : output;
    }
    public static void main(String[] args){
        System.out.println(clockangle(2,23));
        System.out.println(clockangle(6,0));
        System.out.println(clockangle(9,0));
        System.out.println(clockangle(2,20));
    }
}
