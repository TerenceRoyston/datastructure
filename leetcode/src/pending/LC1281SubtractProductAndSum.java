package pending;

public class LC1281SubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }


    public static int subtractProductAndSum(int n) {
        String str = String.valueOf(n);
        int sum=0;
        int acc=1;
        for (int i=0;i<str.length();i++){
            String s = String.valueOf(str.charAt(i));
            int num = Integer.parseInt(s);
            sum+=num;
            acc*=num;
        }
        return acc-sum;
    }
}
