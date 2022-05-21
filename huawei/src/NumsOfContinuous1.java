import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumsOfContinuous1 {

    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = sb.readLine()) != null) {
            int num = Integer.parseInt(str);
            System.out.println(calNumsOf1((byte) num));
        }
    }

    public static int calNumsOf1(Byte num) {
        if (num == 0) return 0;
        String str = Integer.toBinaryString((num & 0xFF) + 0x100).substring(1);
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 49) {
                count++;
                list.add(count);
            } else {
                list.add(count);
                count = 0;
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    //似乎输入int型也可以

    /*public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while ((str=sb.readLine())!=null){
            int num = Integer.parseInt(str);
            System.out.println(calNumsOf1(num));
        }
    }
    public static int calNumsOf1(int num){
        if (num==0) return 0;
        String str = Integer.toBinaryString(num);
        int count=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==49){
                count++;
                list.add(count);
            }else {
                list.add(count);
                count=0;
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }*/
}
