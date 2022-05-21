package binarytree;

/**
 * @author XuBowen
 * @date 2021/10/3 11:04
 *
 * 折痕问题，微软面试题
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后
 * 展开。此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。
 * 如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有三条折痕，从
 * 上到下依次是下折痕、下折痕和上折痕。
 * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次。请从上到下打印所有折痕的方向。
 *
 * 折痕顺序其实就是对应一棵树的中序遍历
 * 解法虽然没有用到二叉树，但是用的是中序遍历递归思想
 */
public class RESC12_PaperFolding {
	public static void main(String[] args) {
		printFoldPaper(3);
	}

	public static void printFoldPaper(int N) {
		foldProcess(1, N, true);
	}

	public static void foldProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}

		foldProcess(i + 1, N, true);
		System.out.println(down ? "凹" : "凸");
		foldProcess(i + 1, N, false);
	}
}
