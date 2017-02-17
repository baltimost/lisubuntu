public class Solution {
    public static int strStr(String haystack, String needle) {
        int i, j;
        for(i = 0, j = 0;i <= haystack.length() - needle.length() && j < needle.length();) {
            if(haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
                System.out.println("hao");
            }
            else {
                i = i + j + 1;
                j = 0;
                System.out.println("buhao");
            }
        }
        if(j == needle.length()) {
            return i;
        }
        else {
            return -1;
        }
    }

    public static int strStrAlt(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();
        int[][] kmptable = new int[256][M];
        /*
        for(int[] x : kmptable) {
            for(int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        */
        genKmp(kmptable, needle);
        int i, j;
        for(i = 0, j = 0;i < N && j < M;i++) {
            j = kmptable[haystack.charAt(i)][j];
        }
        System.out.println("j:" + j);
        if(j == M) {
            return i - M;
        }
        else {
            return -1;
        }
    }

    public static void genKmp(int[][] kmptable, String pattern) {
        kmptable[pattern.charAt(0)][0] = 1;
        System.out.println(pattern.charAt(0) + "," + kmptable[pattern.charAt(0)][0]);
        for(int j = 1, x = 0;j < pattern.length();j++) {
            for(int i = 0;i < 256;i++) {
                kmptable[i][j] = kmptable[i][x];
            }
            kmptable[pattern.charAt(j)][j] = kmptable[pattern.charAt(j - 1)][j - 1] + 1;
            x = kmptable[pattern.charAt(j)][x];
        }
    }
    public static void main(String[] args) {
        System.out.println(strStrAlt("hay", "needlel"));
        //System.out.println(strStrAlt("hayneedlestack", "needlel"));
        //System.out.println(strStrAlt("mississippi", "issip"));
    }
}
