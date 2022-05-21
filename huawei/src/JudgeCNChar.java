import java.util.Scanner;

public class JudgeCNChar {
    public static void main(String[] args) {
        //System.out.println(judgeCNChar("我ABC汉DEF", 6));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int length = scanner.nextInt();
            System.out.println(judgeCNChar(str, length));
        }
    }

    public static String judgeCNChar(String str, int length) {
        int count = 0;
        String resStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {     //判断字符串是否为汉字
                if (count <= length - 2) {                              //如果是汉字
                    resStr += c;
                    count += 2;
                } else {
                    return resStr;
                }
            } else {                        //如果是字母
                if (count < length) {
                    resStr += c;
                    count += 1;
                } else {
                    return resStr;
                }
            }
        }
        return resStr;
    }
}
