public class PrintWeek{
    public static void printWeek(int m, int d, int y, int w){
        int[] maxDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] weekDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
            maxDays[1] = 29;
        if(m <= 0 || m > 12 || d < 1 || d > maxDays[m - 1]){
            System.out.println("Invalid input");
            return;
        }
        for(int i = w - 1;i >= 0;i--){
            if(d == 1){
                if(m == 1){
                    m = 12;
                    y--;
                }
                else
                    m--;
                d = maxDays[m - 1];
            }
            else
                d--;
        }
        for(int i = 0;i < 7;i++){
            System.out.println(weekDay[i] + " " + m + "/" + d + "/" + y);
            if(d == maxDays[m - 1]){
                if(m == 12){
                    m = 1;
                    y++;
                }
                else
                    m++;
                d = 1;
            }
            else
                d++;
        }
    }
    public static void main(String[] args){
        int m = 2, d = 26, y = 2012, weekday = 1;
        System.out.println("Today is : " +  weekday + " " + m + "/" + d + "/" + y);
        printWeek(m,d,y,weekday);
    }
}
