import java.io.IOException;
import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if (m <= n) {
            int common = leastCommonMultiple(m, n);
            System.out.println(common);
        } else {
            int common = leastCommonMultiple(n, m);
            System.out.println(common);
        }


    }

    public static int leastCommonMultiple(int m, int n) {
        int i = 1;
        while ((n * i) % m != 0) {
            i++;
        }
        return n * i;
    }
}
