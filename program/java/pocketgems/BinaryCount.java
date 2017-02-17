public  class BinaryCount {
    public static int count = 0;
    public static int count(int n) {
        helper(0, n, 0);
        return count;
    }
    public static void helper(int start, int n, int pre) {
        if(start == n) {
            count++;
            return;
        }
        if(pre == 0) {
            helper(start + 1, n, 0);
            helper(start + 1, n, 1);
        }
        else {
            helper(start + 1, n, 0);
        }
    }
    public static void main(String[] args) {
        System.out.println(count(6));
    }
}
