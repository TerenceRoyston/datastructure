import java.util.Scanner;

public class ClassificateString {
    static int engChar = 0;
    static int numChar = 0;
    static int blankChar = 0;
    static int otherChar = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            classificateString(str);
            System.out.println(engChar);
            System.out.println(blankChar);
            System.out.println(numChar);
            System.out.println(otherChar);
            engChar = 0;
            numChar = 0;
            blankChar = 0;
            otherChar = 0;
        }

    }

    public static void classificateString(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                engChar++;
            } else if (c >= 48 && c <= 57) {
                numChar++;
            } else if (c == 32) {
                blankChar++;
            } else {
                otherChar++;
            }
        }
    }
}
