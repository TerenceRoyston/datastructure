package binarytree;

/**
 * @author XuBowen
 * @date 2021/10/1 23:08
 * <p>
 * 平衡二叉树：对于任意一个节点，其左节点与右节点的高度差不超过1
 *
 * 递归思路判断平衡二叉树思路：
 * 针对一个节点：我们需要知道其左子树(是否是平衡二叉树，左子树高度)，其右子树(是否是平衡二叉树，右子树高度)
 * 我需要返回两个信息（当前节点所在树高度，当前节点所在树是否是平衡二叉树）
 * 其实并不需要具体知道到底是怎样一个计算过程，只需要关心我当前需要什么，返回什么就可以了
 *
 */
public class RESC07_BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left=new TreeNode(4);
		root.left.left.left=new TreeNode(5);

		System.out.println(process(root).isBalanced);
	}

	public static ReturnType process(TreeNode head) {
		if (head == null) {
			return new ReturnType(true, 0);
		}

		ReturnType leftData = process(head.left);
		ReturnType rightData = process(head.right);

		int height = Math.max(leftData.height, rightData.height) + 1;
		boolean isBalanced = leftData.isBalanced && rightData.isBalanced && Math.abs(leftData.height - rightData.height) < 2;

		return new ReturnType(isBalanced, height);
	}

	public static class ReturnType {
		public boolean isBalanced;
		public int height;

		public ReturnType(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
}
