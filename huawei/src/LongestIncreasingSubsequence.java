import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    public static int getLength(int[] arr){

        int dp[] =new int[arr.length];
        if (dp.length==0) return 0;
        for (int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                if ((arr[i]>arr[j])&&(dp[j]+1>dp[i])){
                    dp[i]=dp[j]+1;
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}
