import java.util.ArrayList;
import java.util.Scanner;

public class HJ105NegToPos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int negCount = 0, posCount = 0;
        int num = 0;
        while (scanner.hasNext()) {
            num = scanner.nextInt();
            if (num == 0) break;
            if (num >= 0) {
                list.add(num);
                posCount++;
            } else {
                negCount++;
            }
        }

        int sum = 0;
        double avg = 0;
        for (Integer i : list) {
            sum += i;
        }
        avg = Double.parseDouble(String.format("%.1f", (double) sum / posCount));   //保留一位小数，四舍五入
        System.out.println(negCount);
        if (posCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(avg);
        }
    }
}
