public class GasStation{
    /*
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int remain = 0;
        int len = gas.length;
        for(int i = 0;i < len;){
            if(gas[i] >= cost[i]){
                int j = i + 1;
                for(;j % len != i;j++){ 
                    remain = remain + gas[(j + len - 1) % len] - cost[(j + len - 1) % len];
                    if(remain + gas[j % len] < cost[j % len])  
                        break;
                }
                if(j % len == i)
                    return i;
                else{
                    remain = 0;
                    i = j + 1;
                }
            }
            else
                i++;
        }
        return -1;
    }
    */
    public static int canCompleteCircuit(int[] gas, int[] cost){
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0)
            return -1;
        int remain = 0;
        int total = 0;
        int start = 0;
        for(int i = 0;i < gas.length;i++){
            remain += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(remain < 0){
                start = i + 1;
                remain = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
    public static void main(String[] args){
        int[] gas = {100,100,100,100};
        int[] cost = {1,1,300,1}; 
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
