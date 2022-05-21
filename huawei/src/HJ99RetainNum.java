import java.util.Scanner;

public class HJ99RetainNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int range = scanner.nextInt();
            int count = 0;
            for (int i = 0; i <= range; i++) {
                if (judgeRetainNum(i)) count++;
            }
            System.out.println(count);
        }
    }

    public static boolean judgeRetainNum(int num) {
        String str = String.valueOf(num * num);
        int index = str.indexOf(String.valueOf(num));
        if (index == str.length() - String.valueOf(num).length()) {
            return true;
        } else {
            return false;
        }
    }
}

