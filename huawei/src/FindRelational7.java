import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FindRelational7 {
    public static void main(String[] args) {
        //System.out.println(find7(15929));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(find7(num));
        }
    }

    public static int find7(int num) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <=num; i++) {     //判断能否被7整除
            if (i % 7 == 0) {
                hashSet.add(i);
                continue;
            }

            String str = String.valueOf(i);         //判断是否包含7
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 55) hashSet.add(i);
            }
        }
        return hashSet.size();
    }
}
