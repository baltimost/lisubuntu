public class Strstr {
    public static int strstr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();
        if(M > N) {
            return -1;
        }
        if(M == 0) {
            return 0;
        }
        int i, j;
        for(i = 0, j = 0;i < N - M && j < M;) {
            if(haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            else {
                j = 0;
                i++;
            }
        }
        return j == M ? i : -1;
    }
    public static void main(String[] args) {
        System.out.println(strstr("haynedlestack", "needle"));
    }
}
