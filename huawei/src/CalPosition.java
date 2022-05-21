import java.util.ArrayList;
import java.util.Scanner;

public class CalPosition {
    public static void main(String[] args) {
        //System.out.println(calPosition("A10;S20;W10;D30;X;A1A;B10A11;;A10;"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(calPosition(str));
        }
    }

    public static String calPosition(String str) {
        String[] elm = str.split(";");
        ArrayList<String> list = new ArrayList<>();
        for (String s : elm) {
            if (s.length() != 2 && s.length() != 3) continue;          //长度不为2或3，不要
            if (s.charAt(0) != 87 && s.charAt(0) != 65 && s.charAt(0) != 83 && s.charAt(0) != 68)
                continue; //首字母不在WASD中，不要
            if (s.length() == 2) {                      //如果长度为2，第二位不是数字的，不要
                if (s.charAt(1) >= 48 && s.charAt(1) <= 57) list.add(s);
            } else {
                if (s.charAt(1) >= 48 && s.charAt(1) <= 57) {               //如果长度为3，第二三位不是数字的，不要
                    if (s.charAt(2) >= 48 && s.charAt(2) <= 57) {
                        list.add(s);
                    }
                }
            }
        }

        int X = 0, Y = 0;
        for (int j = 0; j < list.size(); j++) {
            X += moveX(list.get(j));
            Y += moveY(list.get(j));
        }
        return X + "," + Y;
    }

    public static int moveX(String order) {
        if (order.charAt(0) == 87 || order.charAt(0) == 83) return 0;
        if (order.charAt(0) == 65) return -Integer.parseInt(order.substring(1));
        if (order.charAt(0) == 68) return Integer.parseInt(order.substring(1));
        return 0;
    }

    public static int moveY(String order) {
        if (order.charAt(0) == 65 || order.charAt(0) == 68) return 0;
        if (order.charAt(0) == 83) return -Integer.parseInt(order.substring(1));
        if (order.charAt(0) == 87) return Integer.parseInt(order.substring(1));
        return 0;
    }

}
