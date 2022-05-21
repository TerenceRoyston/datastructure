import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/*public class AliTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String S = in.nextLine();
        String T = in.nextLine();
        int res = helper(S, T);
        System.out.println(res);
    }

    public static int helper(String S, String T) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {//i为起点
            for (int j = 1; j <= S.length() - i; j++) {//j为子串长度
                if (isSub(S.substring(i, i + j), T)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static boolean isSub(String S, String T) {
        int i = 0;
        int j = 0;
        while (i < S.length() && j < T.length()) {
            if (S.charAt(i) == T.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == S.length())
            return true;
        return false;
    }
}*/


public class AliTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String S=scanner.next();
            String T=scanner.next();
            HashSet<String> subStrSet = new HashSet<>();
            subStrSet=getSubStr(S);
            int count=0;
            for (String str : subStrSet) {
                boolean flag = judgeSubSeq(str, T);
                if (flag!=true){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static HashSet getSubStr(String str) {      //获取子字符串，此方法测试后正确
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                hashSet.add(substring);
            }
        }
        return hashSet;
    }

    public static boolean judgeSubSeq(String str1,String str2){

        boolean flag=false;
        for (int i=0;i<str1.length();i++){
            String s = String.valueOf(str1.charAt(i));
            if (str2.contains(s)){
                str2=str2.substring(str2.indexOf(s)+1);
            }else {
                flag=true;
                break;
            }
        }
        return flag;
    }
}

