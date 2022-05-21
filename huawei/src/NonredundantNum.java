import java.util.ArrayList;
import java.util.Scanner;

public class NonredundantNum {
    public static void main(String[] args) {
        //System.out.println(nonredundantNum(9876673));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            System.out.println(nonredundantNum(num));
        }
    }

    public static int nonredundantNum(int num) {
        ArrayList<String> list = new ArrayList<>();
        String str = String.valueOf(num);
        for (int i = str.length() - 1; i >= 0; i--) {
            String s = String.valueOf(str.charAt(i));
            if (!list.contains(s)) {
                list.add(s);
            }
        }

        String resStr = "";
        for (String s : list) {
            resStr += s;
        }
        return Integer.parseInt(resStr);
    }
}
