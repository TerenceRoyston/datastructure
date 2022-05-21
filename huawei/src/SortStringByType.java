import java.util.ArrayList;
import java.util.Arrays;

public class SortStringByType {
    public static void main(String[] args) {
        System.out.println(sortString("A Famous Saying: Much Ado About Nothing (2012/8)."));
    }

    public static String sortString(String str){
        Character[] strArray = new Character[str.length()];
        ArrayList<Character> list = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (Character.isLetter(c)){
                list.add(c);
            }else {
                strArray[i]=c;
            }
        }

        ArrayList<Character> resList = new ArrayList<>();
        for (int j=0;j<26;j++){
            for (int k=0;k<list.size();k++){
                Character c = list.get(k);
                if (c==65+j||c==97+j) resList.add(c);
            }
        }

        for (int m=0;m<list.size();m++){
            if (strArray[m]==null){
                strArray[m]=list.get(m);
            }
        }
        return Arrays.toString(strArray);
    }
}
