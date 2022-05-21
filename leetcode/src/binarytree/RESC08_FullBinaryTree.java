package binarytree;

/**
 * @author XuBowen
 * @date 2021/10/2 11:58
 *
 * 满二叉树概念：
 * 一棵树最大深度D,节点数N，需满足N=2^(D)-1
 */
public class RESC08_FullBinaryTree {
	public static void main(String[] args) {

	}

	public static boolean isFullBinaryTree(TreeNode head){
		if (head == null){
			return true;
		}
		ReturnType res = process(head);
		return res.nodeNums==Math.pow(2,res.height)-1;
	}

	public static ReturnType process(TreeNode x){
		if (x ==null){
			return new ReturnType(0,0);
		}

		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);

		int maxHeight=Math.max(leftData.height,rightData.height)+1;
		int nodeNums=leftData.nodeNums+rightData.nodeNums+1;

		/*
			这里其实不需要判断其左右子树是否为满二叉树，因为在最后计算节点数与高度关系时如果左右子树不是满二叉树
			那么整棵树也不可能是满二叉树

			那为什么其他二叉树需要判断左右子树的情况呢？因为其他二叉树仅凭最后结算无法判断各自情况
		 */


		return new ReturnType(maxHeight,nodeNums);

	}


	public static class ReturnType{
		int height;
		int nodeNums;

		public ReturnType(int height, int nodeNums) {
			this.height = height;
			this.nodeNums = nodeNums;
		}
	}
}
