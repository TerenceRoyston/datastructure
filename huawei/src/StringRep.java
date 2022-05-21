import java.util.Scanner;

public class StringRep {
    public static void main(String[] args) {
        //System.out.println(repStr("Jkdi234klowe90a3"));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(repStr(str));
        }
    }

    public static String repStr(String str) {
        String resStr = "";
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= 48 && c <= 57)) {        //如果此字符不是数字，则先判断temp中是否为空，如果不为空，则将其两边加上数字
                if (!temp.isEmpty()) {
                    resStr += "*" + temp + "*";
                    temp = "";
                }
                resStr += c;                //处理完上述temp步骤后，正常将非数字字符加入resStr中
            } else {            //如果此字符为数字，则将其加入temp中
                temp += c;
            }
        }
        if (!temp.isEmpty()) {          //如果最后几位全是数字没有字母的话，在循环中无法将其处理，循环结束后判断temp是否为空，不为空手动将temp加*后返回
            resStr += "*" + temp + "*";
        }
        return resStr;
    }
}