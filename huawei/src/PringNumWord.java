import java.util.Scanner;

public class PringNumWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            long num = scanner.nextLong();
            if (num==0) System.out.println("zero");
            String str = String.valueOf(num);
            if (str.length()>=1&&str.length()<=3){
                System.out.println(readNumWord(str));
            }else if (str.length()>=4&&str.length()<=6){
                String sub1 = str.substring(0, str.length() - 3);
                String sub2 = str.substring(str.length() - 3);
                System.out.println(readNumWord(sub1) +" thousand "+readNumWord(sub2));
            }else if (str.length()>=7&&str.length()<=9){
                String sub1 = str.substring(0, str.length() - 6);
                String sub2 = str.substring(str.length() - 6,str.length() - 3);
                String sub3 = str.substring(str.length() - 3);
                System.out.println(readNumWord(sub1) +" million "+readNumWord(sub2)+" thousand "+readNumWord(sub3));
            }else {
                System.out.println("error");
            }
        }
    }

    /*public static void main(String[] args) {
        for (int i=0;i<10000;i++){
            if (i==0) {
                System.out.println("zero");
                continue;
            }
            String str = String.valueOf(i);
            if (str.length()>=1&&str.length()<=3){
                //readNumWord(str)
                System.out.println(readNumWord(str));
            }else if (str.length()>=4&&str.length()<=6){
                String sub1 = str.substring(0, str.length() - 3);
                String sub2 = str.substring(str.length() - 3);
                //String s = readNumWord(sub1) + " thousand " + readNumWord(sub2);
                System.out.println(readNumWord(sub1) +" thousand "+readNumWord(sub2));
            }else if (str.length()>=7&&str.length()<=9){
                String sub1 = str.substring(0, str.length() - 6);
                String sub2 = str.substring(str.length() - 6,str.length() - 3);
                String sub3 = str.substring(str.length() - 3);
                //String s = readNumWord(sub1) + " million " + readNumWord(sub2) + " thousand " + readNumWord(sub3);
                System.out.println(readNumWord(sub1) +" million "+readNumWord(sub2)+" thousand "+readNumWord(sub3));
            }else {
                System.out.println("error");
            }
        }
    }*/

    public static String readNumWord(String word){      //读取一个三位数

        String[] oneToTen={"one","two","three","four","five","six","seven","eight","nine"};
        String[] tenToTwenty={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tenToHundred={"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        if (word.length()==1) {
            int num = Integer.parseInt(word);
            return oneToTen[num-1];
        }else if (word.length()==2){
            int num = Integer.parseInt(word);
            if (num>=10&&num<20){
                return tenToTwenty[num-10];
            }else {
                if (num%10==0) return tenToHundred[num/10-1];
                return tenToHundred[num/10-1]+" "+oneToTen[num%10-1];
            }
        }else if (word.length()==3){
            int num = Integer.parseInt(word);
            if (num%100==0) return oneToTen[num/100-1]+" hundred ";
            return oneToTen[num/100-1]+" hundred and "+readNumWord(String.valueOf(num%100));
        }else {
            return "error";
        }
    }
}
