import java.util.Scanner;

public class ToApproximateValue {
    public static void main(String[] args) {
        //System.out.println(toApproximateValue(5.5));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double num = scanner.nextDouble();
            System.out.println(toApproximateValue(num));
        }
    }

    public static int toApproximateValue(double num) {
        int head = (int) num;
        head = (num - head) >= 0.5 ? head + 1 : head;
        return head;
    }
}
