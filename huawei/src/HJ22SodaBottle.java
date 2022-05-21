import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ22SodaBottle {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while ((str=scanner.nextLine())!=null){
            int nums = Integer.parseInt(str);
            if (nums==0) {
                break;
            }else {
                int drinks = calBottles(nums);
                System.out.println(drinks);
            }
        }
    }*/

    public static void main(String[] args)  throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str=bf.readLine())!=null){
            int nums = Integer.parseInt(str);
            if (nums==0) {
                break;
            }else {
                int drinks = calBottles(nums);
                System.out.println(drinks);
            }
        }
    }

    public static int calBottles(int nums){
        if (nums<2) return 0;
        if (nums==2) return 1;
        int count=nums/3;
        int empty=nums%3;
        return count+calBottles(count+empty);
    }
}
