import java.util.Scanner;

public class JudgeStrMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(judgeMatching(str1, str2));
        }
    }

    public static boolean judgeMatching(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (!str2.contains(String.valueOf(c))) return false;
        }
        return true;
    }
}
