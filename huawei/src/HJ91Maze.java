import java.util.Scanner;

public class HJ91Maze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){          //这里就是一个组合计算，总共要走m+n步，其中选择n步向下即可
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int sum=factorial(n+m);
            int div=factorial(m)*factorial(n);
            System.out.println(sum / div);
        }
    }

    public static int factorial(int num){           //定义一个阶乘方法
        if (num<=1){
            return 1;
        }else {
            return num*factorial(num-1);
        }
    }
}
