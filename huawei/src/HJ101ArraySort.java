import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HJ101ArraySort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            while (num != 0) {
                int i = scanner.nextInt();
                list.add(i);
                num--;
            }
            int method = scanner.nextInt();
            String resStr = "";
            Collections.sort(list);
            if (method == 0) {
                for (Integer i : list) {
                    resStr += i + " ";
                }
            } else if (method == 1) {
                Collections.reverse(list);
                for (Integer i : list) {
                    resStr += i + " ";
                }
            }
            System.out.println(resStr.trim());
        }
    }
}
