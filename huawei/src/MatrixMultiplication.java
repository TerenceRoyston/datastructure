import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[][] M = new int[x][y];
            int[][] N = new int[y][z];
            for (int i = 0; i < x; i++) {          //填充M矩阵
                for (int j = 0; j < y; j++) {
                    M[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < y; i++) {          //填充N矩阵
                for (int j = 0; j < z; j++) {
                    N[i][j] = scanner.nextInt();
                }
            }

            int[][] reformatN = reformatMatrix(N, y, z);    //N矩阵转置

            for (int i = 0; i < M.length; i++) {        //二维矩阵相乘
                for (int j = 0; j < reformatN.length; j++) {
                    if (j == reformatN.length - 1) {     //如果还没到最后一个数，输出加空格
                        System.out.print(mulArray(M[i], reformatN[j]));
                    } else {                         //如果到了最后一个数，直接输出不加空格
                        System.out.print(mulArray(M[i], reformatN[j]) + " ");
                    }
                }
                System.out.println();
            }

        }
    }

    public static int[][] reformatMatrix(int[][] arr, int row, int col) {      //将矩阵也就是规则化的二维数组行列调换
        int[][] reformatArr = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                reformatArr[i][j] = arr[j][i];
            }
        }
        return reformatArr;
    }

    public static int mulArray(int[] arr1, int[] arr2) {      //定义两个一维数组相乘，对应位置数相乘，结果相加
        int length = arr1.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += arr1[i] * arr2[i];
        }
        return count;
    }
}
