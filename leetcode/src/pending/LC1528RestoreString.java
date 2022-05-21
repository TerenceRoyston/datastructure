package pending;

/**
 * @author XuBowen
 * @date 2021/1/16 19:16
 */
public class LC1528RestoreString {
    public static void main(String[] args) {
        String s = "aiohn";
        int[] indices = {3, 1, 4, 2, 0};
        System.out.println(restoreString(s, indices));
    }

    public static String restoreString(String s, int[] indices) {
        String[] help = new String[indices.length];
        for (int i = 0; i < s.length(); i++) {
            help[indices[i]] = String.valueOf(s.charAt(i));
        }
        String resString = "";
        for (String str : help) {
            resString += str;
        }
        return resString;
    }
}
