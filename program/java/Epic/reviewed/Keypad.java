public class Keypad{
    public static boolean isAllowed(int[] code, int[] enter){
        if(enter == null || enter.length == 0 || enter.length != code.length)
            return false;
        boolean once = false; 
        for(int i = 0;i < code.length;i++){
            if(code[i] != enter[i]){
                if(once) return false;
                once = true;
                if(((code[i] - 1) / 3 != (enter[i] - 1) / 3) && (code[i] % 3 != enter[i] % 3))
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] code = {1,4,7,8};
        int[] enter = {1,1,8,8};
        System.out.println(isAllowed(code, enter));
    }
}
