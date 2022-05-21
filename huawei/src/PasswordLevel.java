import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordLevel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int score = 0;
        while ((str = br.readLine()) != null) {
            score = getPwdSecurityLevel(str);

            if (score >= 0 && score < 25) {
                System.out.println("VERY_WEAK");
            } else if (score >= 25 && score < 50) {
                System.out.println("WEAK");
            } else if (score >= 50 && score < 60) {
                System.out.println("AVERAGE");
            } else if (score >= 60 && score < 70) {
                System.out.println("STRONG");
            } else if (score >= 70 && score < 80) {
                System.out.println("VERY_STRONG");
            } else if (score >= 80 && score < 90) {
                System.out.println("SECURE");
            } else if (score >= 90) {
                System.out.println("VERY_SECURE");
            }
        }
    }

    public static int getPwdSecurityLevel(String passwordStr) {
        int score = 0;
        int upperCount = 0;   //判断大写字母数量
        int lowerCount = 0;   //判断小写字母数量
        int numCount = 0;     //判断数字数量
        int symCount = 0;     //判断符号数量
        boolean letterflag = false;   //是否出现字母
        boolean numflag = false;  //是否出现数字
        boolean symflag = false;  //是否出现符号
        if (passwordStr.length() <= 4) {
            score += 5;
        } else if (passwordStr.length() >= 5 && passwordStr.length() <= 7) {
            score += 10;
        } else {
            score += 25;
        }

        for (int i = 0; i < passwordStr.length(); i++) {   //遍历每一个字符，按照种类放入分组
            char c = passwordStr.charAt(i);
            if (c >= 97 && c <= 122) {
                lowerCount += 1;
                letterflag = true;
            } else if (c >= 65 && c <= 90) {
                upperCount += 1;
                letterflag = true;
            } else if (c >= 48 && c <= 57) {
                numCount += 1;
                numflag = true;
            } else {
                symCount += 1;
                symflag = true;
            }
        }

        if (lowerCount > 0 && upperCount > 0) {        //统计字母组情况
            score += 20;
        } else if (lowerCount == 0 && upperCount == 0) {
            score += 0;
        } else {
            score += 10;
        }

        if (numCount == 0) {       //统计数字组情况
            score += 0;
        } else if (numCount == 1) {
            score += 10;
        } else {
            score += 20;
        }

        if (symCount == 0) {       //统计符号组情况
            score += 0;
        } else if (symCount == 1) {
            score += 10;
        } else {
            score += 25;
        }

        if (letterflag == true && numflag == true && symflag == false) {    //统计额外奖励情况
            score += 2;
        } else if (lowerCount > 0 && upperCount > 0 && numflag == true && symflag == true) {
            score += 5;
        } else if (letterflag == true && numflag == true && symflag == true) {
            score += 3;
        }
        return score;

    }
}

/*
符号：32-47 58-64 91-96 123-126
大写字母：65-90
小写字母：97-122
数字：48-57
*/