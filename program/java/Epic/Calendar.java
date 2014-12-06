public class Calendar{
    public static void printCalendar(int year){
        int maxDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            maxDays[1] = 29;
        for(int i = 0;i < maxDays.length;i++){
            for(int j = 0;j < maxDays[i];j++)
                System.out.print((i + 1) + "/" + (j + 1) + "/" + year + " ");
            System.out.println("\n");
        }
    }
    public static void main(String[] args){
        printCalendar(2015);
    }
}
