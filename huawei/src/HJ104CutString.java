import java.util.Scanner;

public class HJ104CutString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            while (num != 0) {
                String str = scanner.next();
                cutString(str);
                num--;
            }
        }
    }

    public static void cutString(String str) {
        if (str.length() <= 8) {
            int diff = 8 - str.length();
            while (diff != 0) {
                str += "0";
                diff--;
            }
            System.out.println(str);
        } else {
            System.out.println(str.substring(0, 8));
            cutString(str.substring(8));
        }
    }
}
