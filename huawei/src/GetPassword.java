import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetPassword {
    public static void main(String[] args) throws IOException {
/*        String str="vdfvdabcdefedcbakuikik";
        System.out.println(getPassword(str));*/
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str=bf.readLine())!=null){
            System.out.println(getPassword(str));
        }
    }

    public static int getPassword(String str){
        ArrayList list = getSubString(str);
        int maxLength=0;
        for (int i=0;i<list.size();i++){    //遍历集合，判断是否为回文数
            int length=((String)list.get(i)).length();
            if (isPalindrome((String)list.get(i))){
                maxLength=length>maxLength?length:maxLength;
            }else {
                continue;
            }

        }
        return maxLength;
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

    public static boolean isPalindrome(String str){
        if (str.length()%2==0){             //判断字符串长度为奇数还是偶数
            String tmp="";
            for (int i=str.length()/2-1;i>=0;i--){
                tmp+=str.charAt(i);                 //遍历字符串前半段并逆序
            }
            return tmp.equals(str.substring(str.length()/2))?true:false;    //判断前后是否相等
        }else {
            String tmp="";
            for (int i=(str.length()-1)/2-1;i>=0;i--){
                tmp+=str.charAt(i);
            }
            return tmp.equals(str.substring((str.length()-1)/2+1))?true:false;
        }
    }
}
