import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            int m=str1.length();
            String str2 = scanner.nextLine();
            int n = str2.length();
            System.out.println(longestCommonSubsequence1(str1, str2, m, n));
            System.out.println(longestCommonSubsequence2(str1, str2, m, n));
        }
    }

    public static int longestCommonSubsequence1(String str1, String str2,int m,int n) {      //自下向上法

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c1 = str1.charAt(i), c2 = str2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //要么是str1往前退一格，要么是str2往前退一格，两个的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequence2(String str1, String str2,int m,int n){   //自上向下法
        if (m==0||n==0) return 0;
        char c1 = str1.charAt(m - 1);
        char c2 = str2.charAt(n - 1);
        if (c1==c2){
            return 1+longestCommonSubsequence2(str1,str2,m-1,n-1);
        }else {
            return Math.max(longestCommonSubsequence2(str1,str2,m-1,n),longestCommonSubsequence2(str1,str2,m,n-1));
        }
    }

}
