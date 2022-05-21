import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String resStr = reverseInteger(num);
        System.out.println(resStr);
    }

    public static String reverseInteger(int num) {
        String str = String.valueOf(num);
        String resStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            resStr += str.charAt(i);
        }
        return resStr;
    }
}

//  https://www.nowcoder.com/questionTerminal/ae809795fca34687a48b172186e3dafe