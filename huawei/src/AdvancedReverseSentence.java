import java.util.Scanner;

public class AdvancedReverseSentence {
    public static void main(String[] args) {
        /*String str="$bo*y gi!r#l #";
        System.out.println(reverseSentence(str));*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(reverseSentence(str));
        }
    }

    public static String reverseSentence(String str) {
        String resStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {       //如果当前字符不是字母，则有两种可能
                if (Character.isLetter(str.charAt(i + 1))) {    //如果下一位是字母，则当前位置空格传给resStr
                    resStr += " ";
                } else {                        //如果下一位仍然不是字母，则当前位置空格传给resStr,直接跳过下一位，相当于把两个非字母置为一个空格
                    resStr += " ";
                    i += 1;
                }
            } else {
                resStr += c;
            }
        }
        resStr = resStr.trim();     //修剪两端空格

        String[] split = resStr.split(" ");
        String sentence = "";
        for (int i = split.length - 1; i >= 0; i--) {
            sentence += split[i] + " ";
        }
        return sentence.trim();
    }
}
