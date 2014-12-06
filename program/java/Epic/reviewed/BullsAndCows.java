import java.util.HashMap;

public class BullsAndCows{
    public static int[] bullsAndCows(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0;i < s1.length();i++){
            Character current = s1.charAt(i);
            hm.put(current, hm.get(current) == null ? 1 : hm.get(current) + 1);
        }
        for(int i = 0;i < s2.length();i++){
            Character current = s2.charAt(i);
            if(i < s1.length() && s1.charAt(i) == current)
                bulls++;
            if(hm.get(current) != null && hm.get(current) >= 1){
                cows++;
                hm.put(current, hm.get(current) - 1);
            }
        }
        cows = cows - bulls;
        return new int[]{bulls, cows};
    }
    public static void main(String[] args){
        //int[] rst = bullsAndCows("Picture", "Epic");
        //int[] rst = bullsAndCows("aauuua", "uauuu");
        //int[] rst = bullsAndCows("auuua", "uuauu");
        int[] rst = bullsAndCows("dusts", "studs");
        System.out.println("bulls:" + rst[0] + " cows:" + rst[1]);
    }
}
