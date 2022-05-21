import java.util.Scanner;

/**
 * @author XuBowen
 * @date 2020/10/30 11:38
 */
public class HJ02CalNumOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String sym = scanner.next();
        System.out.println(numOfChar(str, sym));
    }

    /**
     * @param str 输入字符串
     * @param sym 目标字符
     * @return 字符串中含有目标字符的个数
     */
    public static int numOfChar(String str, String sym) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (sym.equalsIgnoreCase(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        return count;
    }
}
