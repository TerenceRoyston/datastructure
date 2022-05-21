import java.util.Scanner;

public class BinaryCount1 {
    public static void main(String[] args) {
        //System.out.println(binaryCount1(5));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(binaryCount1(num));
        }
    }

    public static int binaryCount1(int num) {
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
