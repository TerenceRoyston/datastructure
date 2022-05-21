package junior.day01;

/**
 * @author XuBowen
 * @date 2020/12/30 15:30
 */
public class FindOddTimes {
    public static void main(String[] args) {
        int[] arr = {1, 7, 7, 2, 2, 7, 4, 4, 0, 0, 0, 0};
        printOddTimesNum(arr);
    }

    public static void printOddTimesNum(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;         //eor为出现奇数次的两种数异或a^b
        }
        int rightOne = eor & (~eor + 1); //取得eor二进制最右边的数字1，而且在这个位置上，a和b必然不相同，因为如果相同，根据异或定理，那这个位置是0。因此这个rightOne就可以作为基点
        int onlyOne = 0;    //onlyOne就是a或者是b
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {    //相&主要是为了检测出a或b，至于其他数，不管是在哪半边甚至其他数都被分到一边其实都可以，最后异或都会变成0
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
