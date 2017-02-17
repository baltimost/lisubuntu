public class Hello {
    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        System.out.println(a < 0);
        System.out.println(a == Math.abs(a));
        System.out.println(Math.abs(a));
    }
}
