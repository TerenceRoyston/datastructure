import java.util.Arrays;
import java.util.Scanner;

public class OneToKAsc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[num];
            int i = 0;
            while (i != num) {
                arr[i] = scanner.nextInt();
                i++;
            }
            Arrays.sort(arr);
            for (int j = 0; j < k; j++) {
                if (j < k - 1) System.out.print(arr[j] + " ");
                else System.out.print(arr[j]);
            }
            System.out.println();
        }
    }
}
