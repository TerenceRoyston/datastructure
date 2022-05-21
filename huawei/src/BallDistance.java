import java.util.Scanner;

public class BallDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int initHeight = scanner.nextInt();
            System.out.println(calDistance(initHeight, 5));
            System.out.println(calRebackDistance(initHeight, 5));
        }

    }

    public static double calDistance(int initHeight, int k) {
        double distance = 0;
        for (int i = 1; i < k; i++) {
            distance += 2 * initHeight / Math.pow(2, i);    //推导一下公式即可
        }
        return initHeight + distance;
    }

    public static double calRebackDistance(int initHeight, int k) {
        return initHeight / Math.pow(2, k);
    }
}
