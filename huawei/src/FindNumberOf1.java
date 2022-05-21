import java.util.Scanner;

public class FindNumberOf1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(findNumberOf1(num));
        }
    }

    public static int findNumberOf1(int num) {
        String str = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 49) {
                count++;
            }
        }
        return count;
    }
}

