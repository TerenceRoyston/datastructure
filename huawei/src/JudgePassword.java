import java.util.ArrayList;
import java.util.Scanner;

public class JudgePassword {
    public static void main(String[] args) {
        //System.out.println(judgePassword("021ABC9000"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (judgePassword(str)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
    }

    public static boolean judgePassword(String str) {
        int lowerCount = 0;
        int upperCount = 0;
        int digitCount = 0;
        int otherCount = 0;
        if (str.length() <= 8) return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerCount++;
            } else if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                otherCount++;
            }
        }
        if (!((lowerCount > 0 && upperCount > 0 && digitCount > 0) || (lowerCount > 0 && upperCount > 0 && otherCount > 0) || (lowerCount > 0 && otherCount > 0 && digitCount > 0) || (otherCount > 0 && upperCount > 0 && digitCount > 0))) {
            return false;
        }

        return judgeSameStr(str);


    }

    public static boolean judgeSameStr(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {           //获取所有子串
            for (int j = i + 1; j < str.length(); j++) {
                String tmpStr = str.substring(i, j);
                if (tmpStr.length() > 2) list.add(tmpStr);   //如果子串长度小于2，就进入list集合

            }
        }

        for (int k = 0; k < list.size(); k++) {            //遍历判断子串是否相等
            for (int temp = k + 1; temp < list.size(); temp++) {
                if (list.get(k).equals(list.get(temp))) return false;
            }
        }
        return true;
    }
}
