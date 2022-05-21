import java.util.ArrayList;
import java.util.Scanner;

public class HJ74ParamAnalyze {
    public static void main(String[] args) {
        //analyzeParam("xcopy /s c:\\\\ d:\\\\\n");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            analyzeParam(str);
        }
    }

    public static void analyzeParam(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 34) {
                for (int j = i + 1; j < str.length(); j++) {
                    char innerC = str.charAt(j);
                    if (innerC == 34) {            //将引号内部的空格全部换成+号，外部的空格不动，然后整体按照空格切割
                        break;
                    } else if (innerC == 32) {
                        str = str.substring(0, j) + "+" + str.substring(j + 1);
                    }
                }
            }
        }
        String[] split = str.split(" ");        //切割完后将所有的+号再换成空格
        System.out.println(split.length);
        for (String s : split) {
            s = s.replace("+", " ");
            System.out.println(s);
        }

    }
}
