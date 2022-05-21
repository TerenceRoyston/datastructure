import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheDay {
    public static void main(String[] args) throws IOException {
        //System.out.println(calTheDay(2012, 12, 31));
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str=bf.readLine())!=null){
            String[] time = str.split(" ");
            int year=Integer.parseInt(time[0]);
            int month=Integer.parseInt(time[1]);
            int day=Integer.parseInt(time[2]);
            System.out.println(calTheDay(year, month, day));
        }
    }

    public static int calTheDay(int year, int month, int day) {
        int[] dayNumscomm = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayNumsLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 1) {
            return day;
        }
        if (!isLeapYear(year)) {
            int count = 0;
            for (int i = 0; i < month - 1; i++) {
                count += dayNumscomm[i];
            }
            count += day;
            return count;
        } else {
            int count = 0;
            for (int i = 0; i < month - 1; i++) {
                count += dayNumsLeap[i];
            }
            count += day;
            return count;
        }

    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
