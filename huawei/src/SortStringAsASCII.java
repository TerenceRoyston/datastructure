import java.util.Arrays;
import java.util.Scanner;

public class SortStringAsASCII {
    public static void main(String[] args) {
        //System.out.println(sortASCII("Ihave1nose2hands10fingers"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(sortASCII(str));
        }
    }

    public static String sortASCII(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String resStr = "";
        for (char c : chars) {
            resStr += c;
        }
        return resStr;
    }
}
