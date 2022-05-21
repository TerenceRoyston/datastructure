import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String resStr = reverseString(str);
        System.out.println(resStr);
    }

    public static String reverseString(String str) {
        String resStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            resStr += str.charAt(i);
        }
        return resStr;
    }
}

//https://www.nowcoder.com/questionTerminal/e45e078701ab4e4cb49393ae30f1bb04