import java.util.ArrayList;
import java.util.Scanner;

public class GetCommonStrLength {
    public static void main(String[] args) {
        /*String str1 = "asdfas";
        String str2 = "werasdfaswer";
        System.out.println(getCommonStrLength(str1, str2));*/

        Scanner sc = new Scanner(System.in);
        String str1 = "";
        String str2 = "";
        while (sc.hasNext()) {
            str1 = sc.next();
            str2 = sc.next();
            System.out.println(getCommonStrLength(str1, str2));
        }

    }

    public static int getCommonStrLength(String str1, String str2) {    //对比两个list，拿到相同的字符串放入新的list
        ArrayList<String> resList = new ArrayList<>();
        ArrayList list1 = getSubString(str1);
        ArrayList list2 = getSubString(str2);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                boolean isLike = ((String) list1.get(i)).equalsIgnoreCase((String) list2.get(j));
                if (isLike == true) {
                    resList.add((String) list2.get(j));
                }
            }
        }

        int maxLength = 0;
        String comSubstring = "";                   //遍历新的list，找到长度最长的子串
        for (int k = 0; k < resList.size(); k++) {
            if (((String) resList.get(k)).length() > maxLength) {
                maxLength = ((String) resList.get(k)).length();
                comSubstring = (String) resList.get(k);
            }
        }
        return comSubstring.length();
    }

    public static ArrayList getSubString(String str) {      //遍历字符串，拿到子串后放入list
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                list.add(substring);
            }
        }
        return list;
    }
}
