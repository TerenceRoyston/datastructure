import java.util.ArrayList;
import java.util.Scanner;

public class DNARatio {
    public static void main(String[] args) {
        //System.out.println(getRatio("AACTGTGCACGACCTGA", 5));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            int length = scanner.nextInt();
            System.out.println(getRatio(str, length));
        }
    }

    public static String getRatio(String str, int length) {
        ArrayList<String> resList = new ArrayList<>();
        double MaxRatio = 0;
        ArrayList subList = getSubStr(str);
        for (int i = 0; i < subList.size(); i++) {
            String s = String.valueOf(subList.get(i));
            if (s.length() == length) {                 //符合长度要求的加入list，同时计算最高GC比例
                MaxRatio = Math.max(MaxRatio, calGCRatio(s));
                resList.add(s);
            }
        }

        for (String s : resList) {
            if (calGCRatio(s) == MaxRatio) return s;
        }

        return null;
    }

    public static ArrayList getSubStr(String str) {      //获取子字符串，此方法测试后正确
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                list.add(substring);
            }
        }
        return list;
    }

    public static double calGCRatio(String str) {   //计算GC比例
        int Gcount = 0;
        int Ccount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 67) {
                Ccount++;
            } else if (c == 71) {
                Gcount++;
            }
        }

        return (double) (Gcount + Ccount) / str.length();  //特别注意类型转换
    }
}
