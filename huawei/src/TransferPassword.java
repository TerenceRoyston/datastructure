import java.util.Scanner;

public class TransferPassword {
    public static void main(String[] args) {
        //System.out.println(transferPassword("YUANzhi1987"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(transferPassword(str));
        }
    }

    public static String transferPassword(String str) {
        String resStr = "";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c >= 65 && c <= 89) {
                resStr += (char) (c + 32 + 1);
            } else if (c == 90) {
                resStr += 'a';
            } else if (c == 'a' || c == 'b' || c == 'c') {
                resStr += "2";
            } else if (c == 'd' || c == 'e' || c == 'f') {
                resStr += "3";
            } else if (c == 'g' || c == 'h' || c == 'i') {
                resStr += "4";
            } else if (c == 'j' || c == 'k' || c == 'l') {
                resStr += "5";
            } else if (c == 'm' || c == 'n' || c == 'o') {
                resStr += "6";
            } else if (c == 'p' || c == 'q' || c == 'r' || c == 's') {
                resStr += "7";
            } else if (c == 't' || c == 'u' || c == 'v') {
                resStr += "8";
            } else if (c == 'w' || c == 'x' || c == 'y' || c == 'z') {
                resStr += "9";
            } else {
                resStr += c;
            }
        }
        return resStr;
    }
}
