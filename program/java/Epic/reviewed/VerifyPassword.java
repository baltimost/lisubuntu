import java.util.HashMap;

public class VerifyPassword{
    public static boolean isValidPassword(String password){
        //if(password.length() < 5 || password.length() > 12) return false;
        boolean hasNum = false;
        boolean hasLow = false;
        for(int i = 0;i < password.length();i++){
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
                hasNum = true;
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                hasLow = true;
            for(int j = 1; i - j >= 0 && i + j <= password.length();j++){
                String l = password.substring(i - j, i);
                String r = password.substring(i, i + j);
                if(l.equals(r)) return false;
            } 
        }
        return hasNum && hasLow;
    }

    public static void invalidPassword(String str){
        for(int i = 1;i <= str.length();i++){ HashMap<String,Integer[]> strMap = new HashMap<String, Integer[]>();
            for(int j = 0; j + i <= str.length();j++){
                String key = str.substring(j, j+i);
                //System.out.println(" "+str.substring(j, j+i)+" "+j+" "+(j+i-1));
                if(strMap.get(key) == null){
                    Integer indices[] = {j, (j+i-1)};
                    strMap.put(key,indices);
                }
                else{
                    Integer indices[] = strMap.get(key);
                    if(j == indices[1]+1){
                        System.out.println("Repeat");
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        //String input = "123123qs";
        //String input = "123qs123";
        //String input = "1acabcdghabc";
        //String input = "1310213102a";
        //String input = "124123123qs";
        //String input = "1310213102a";
        String input = "abcdefghijklmnopqrstu+09842!~vwxyz1234567890a1b2c3d4e5f6g7h8i9j0klmnopqrstuvwxyz1234567890jklmnopq67890a1b2c3df6g7h8i9j0klmnopqrstuvwxyz12345,:*&^%$#@XABCDEFGHIJzabcefgijklnorstuvwXyxzKLMNOPQRSTUVWXYZ1234567890,.abcedcMnQxhiwxbnwioghxoqKxPqEdxbQWq;982471-8473xabcdeoqKxPqEdx9023oqKxPqEdxjkLMNOPQRSTUVWYXZcdefFkKiIoOwW0)8*3*2@1`gow[Xqxjhqd4e5f6g7h8i9j0klmnopqrstuvwxyz1234567890jklmnopq67890a1b2,.abcedcMnQxhiwxbnwioghxoqKxPqEdxbQWq;982471-8473xabcdeoqKxPqEdx9023oqKxPqEdxjkLMN+_(&%@EX;[]}{kK^%$#@!+_(^OPQRSTUVWYXZcdefFkKiIoOwW0)8*3*2@1`gow[Xqxjhqd4e5f6g7h8i9j0klmnopqrstuvwxyz1";
        long before = System.currentTimeMillis();
        System.out.println(isValidPassword(input));//30ms
        //invalidPassword(input);//100ms
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
