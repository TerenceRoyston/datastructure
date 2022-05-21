import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HJ01LastWord {
    /*public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = sb.readLine()) != null){
            System.out.println(getLastWord(str));
        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getLastWord(str));
    }

    public static int getLastWord(String str){
        String[] arr = str.split(" ");
        return arr[arr.length-1].length();
    }
}
