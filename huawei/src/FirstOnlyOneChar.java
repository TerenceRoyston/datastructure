import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FirstOnlyOneChar {
    public static void main(String[] args) {
        //System.out.println(getFirstOnlyOneChar("asdfasdfo"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(getFirstOnlyOneChar(str));
        }
    }

    public static String getFirstOnlyOneChar(String str) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {               //使用LinkedHashMap按顺序添加键值对
            String key = String.valueOf(str.charAt(i));
            linkedHashMap.put(key, linkedHashMap.getOrDefault(key, 0) + 1);
        }

        for (String s : linkedHashMap.keySet()) {       //找出第一个值为1的key返回
            if (linkedHashMap.get(s) == 1) {
                return s;
            }
        }
        return "-1";
    }
}
