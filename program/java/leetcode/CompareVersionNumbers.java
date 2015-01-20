public class CompareVersionNumbers{
    public static int compareVersion(String version1, String version2){
        int i, j, k, l;
        int len1 = version1.length();
        int len2 = version2.length();
        for(i = 0, j = 0, k = 0, l = 0;j < len1 || l < len2;){
            while(j < len1 && version1.charAt(j) != '.') j++;
            while(l < len2 && version2.charAt(l) != '.') l++;
            int v1 = i < len1 ? Integer.parseInt(version1.substring(i, j)) : 0;
            int v2 = k < len2 ? Integer.parseInt(version2.substring(k, l)) : 0;

            if(v1 != v2) 
                return v1 - v2 > 0 ? 1 : -1;

            j++;
            i = j;
            l++;
            k = l;
        }
        return 0;
    }
    public static void main(String[] args){
        String v1 = "1.0.0.0.1";
        String v2 = "1";
        System.out.println(compareVersion(v1, v2));
    }
}
