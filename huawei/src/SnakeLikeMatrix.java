import java.util.Scanner;

public class SnakeLikeMatrix {
    public static void main(String[] args) {
        //snakeLikeMatrix(6);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            snakeLikeMatrix(num);
        }
    }

    public static void snakeLikeMatrix(int num) {
        int head = 1;
        for (int i = 1; i <= num; i++) {
            head = head + i - 1;
            int temp = head;
            for (int j = i + 1; j <= num + 1; j++) {
                if (j <= num) {
                    System.out.print(temp + " ");
                    temp += j;
                } else {
                    System.out.print(temp);
                }
            }
            System.out.println();
        }
    }
}
