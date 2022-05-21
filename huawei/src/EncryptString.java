import java.util.Scanner;

public class EncryptString {
    public static void main(String[] args) {
        //System.out.println(Encrypt("abcdefg125z"));
        //System.out.println(unEncrypt("BCDEFGH"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(Encrypt(str1));
            System.out.println(unEncrypt(str2));
        }
    }

    public static String Encrypt(String str) {
        String resStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 48 && c <= 56) {  //判断数字0-8
                resStr += (char) (c + 1);
                continue;
            }
            if (c == 57) {        //判断数字9
                resStr += '0';
                continue;
            }

            if (c >= 97 && c <= 121) {  //判断a-y
                resStr += (char) (c - 32 + 1);
                continue;
            }
            if (c == 122) { //判断z
                resStr += 'A';
                continue;
            }

            if (c >= 65 && c <= 89) {       //判断A-Y
                resStr += (char) (c + 32 + 1);
                continue;
            }

            if (c == 90) {      //判断Z
                resStr += 'a';
                continue;
            }
        }
        return resStr;
    }

    public static String unEncrypt(String str) {
        String resStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 49 && c <= 57) {  //判断数字0-8
                resStr += (char) (c - 1);
                continue;
            }
            if (c == 48) {        //判断数字9
                resStr += '9';
                continue;
            }

            if (c >= 98 && c <= 122) {
                resStr += (char) (c - 32 - 1);
                continue;
            }
            if (c == 97) {
                resStr += 'Z';
                continue;
            }

            if (c >= 66 && c <= 90) {
                resStr += (char) (c + 32 - 1);
                continue;
            }

            if (c == 65) {
                resStr += 'z';
                continue;
            }
        }
        return resStr;
    }
}
