import java.util.Scanner;

public class SequenceNumStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(getSequenceNum(str));
        }
    }

    public static String getSequenceNum(String str) {
        String repStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                repStr += 'a';
            } else {
                repStr += c;
            }
        }
        String[] strs = repStr.split("a");
        int maxLength = 0;
        for (String s : strs) {
            maxLength = Math.max(maxLength, s.length());
        }

        String res = "";
        for (String s : strs) {
            if (s.length() == maxLength) res += s;
        }
        return res + "," + maxLength;
    }
}
