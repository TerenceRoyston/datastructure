package pending;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class LC1323Maximum69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9969));
        System.out.println(maximum69Number2(9969));
        System.out.println(maximum69Number3(9969));
    }

    public static int maximum69Number (int num) {
        String str = String.valueOf(num);
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<str.length();i++){
           list.add(String.valueOf(str.charAt(i)));
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i).equals("6")){
                list.set(i,"9");
                break;
            }
        }
        return Integer.parseInt(StringUtils.join(list,"")); //list转String方法
    }

    public static int maximum69Number2 (int num) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        for (int i=0;i<arr.length;i++){
            if (arr[i]==54){
                arr[i]=57;
                break;
            }
        }
        String res="";
        for (char c : arr) {
            res+=c;
        }
        return Integer.parseInt(res);
    }

    public static int maximum69Number3 (int num) {
        String str = String.valueOf(num);
        return Integer.parseInt(str.replaceFirst("6", "9")); //注意这个方法
    }
}
