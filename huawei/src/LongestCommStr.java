import java.util.Scanner;

public class LongestCommStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            if (str1.length() >= str2.length()) {
                System.out.println(getCommStr(str1, str2));
            } else {
                System.out.println(getCommStr(str2, str1));
            }
        }
    }

    public static String getCommStr(String str1, String str2) {
        int tempLength = 0;
        String resStr = "";
        for (int i = 0; i < str2.length(); i++) {
            for (int j = i; j < str2.length(); j++) {
                if (str1.contains(str2.substring(i, j + 1)) && (j - i + 1) > tempLength) {
                    resStr = str2.substring(i, j + 1);
                    tempLength = j - i + 1;
                }
            }
        }
        return resStr;
    }
}
