import java.util.Scanner;

public class GetKListNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[num];
            int index = 0;
            while (num != 0) {
                arr[index++] = scanner.nextInt();
                num--;
            }
            int k = scanner.nextInt();
            System.out.println(getKthFromEnd(arr, k));
        }
    }

    public static int getKthFromEnd(int[] arr, int k) {
        if (k == 0) return 0;
        return arr[arr.length - k];
    }
}
