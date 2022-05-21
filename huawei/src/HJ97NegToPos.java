import java.util.ArrayList;
import java.util.Scanner;

public class HJ97NegToPos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            int negCount = 0, posCount = 0;
            while (num != 0) {
                int i = scanner.nextInt();
                if (i > 0) {
                    list.add(i);
                    posCount++;
                } else if (i < 0) {
                    negCount++;
                }
                num--;
            }

            double avg = 0;
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            //avg=(double) sum/posCount;  //这里根据提示需要一个强转操作
            avg = Double.parseDouble(String.format("%.1f", (double) sum / posCount));   //保留一位小数，四舍五入
            System.out.println(negCount + " " + avg);
        }
    }


}

