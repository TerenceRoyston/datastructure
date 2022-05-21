import java.util.Scanner;

public class HJ61Apple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(count(m, n));
        }
        //System.out.println(count(7, 3));
    }

    public static int count(int m, int n) {
        if (m < 0)
            return 0;
        if (m == 0 || n == 1)
            return 1;
        return count(m, n - 1) + count(m - n, n);
    }
}
