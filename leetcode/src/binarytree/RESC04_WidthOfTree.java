package binarytree;

import binarytree.utils.PrintBinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author XuBowen
 * @date 2021/8/31 7:56
 * <p>
 * 求二叉树的最大宽度
 * 我们依然给出两种方法，一种方法使用哈希表和队列
 * 另一种方法略微节省一点空间，只使用队列完成
 */
public class RESC04_WidthOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(10);
		root.right.right.right = new TreeNode(11);
		PrintBinaryTree.printTree(root);

		System.out.println(getWidthOfTree_1(root));
		System.out.println(getWidthOfTree_2(root));
	}

	/**
	 * 使用哈希表+队列
	 * 这里需要注意一种思维方式：我们需要一个哈希表记录每个节点及其对应的层数，
	 * 但是一开始我们只知道根节点在一层这个最基础的结论，其余我们一无所知
	 * 在逐渐遍历每一个节点的过程中，我们不断地往哈希表中加入节点，等于就是从根节点开始
	 * 不断地推导出所有的子节点，这其实是一种迭代的思想
	 */
	public static int getWidthOfTree_1(TreeNode head) {
		if (head != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(head);
			HashMap<TreeNode, Integer> map = new HashMap<>();
			map.put(head, 1);
			int maxWidth = Integer.MIN_VALUE;
			int currLevel = 1;
			int currLevelNodes = 0;
			while (!queue.isEmpty()) {
				// 依次从队列中取出节点，并到哈希表中查询对应的层数
				TreeNode curr = queue.poll();
				int currNodeLevel = map.get(curr);
				if (currNodeLevel == currLevel) {
					// 如果当前节点所在的层与指示层一直，当前层节点数+1，其他什么也不用做
					currLevelNodes++;
				} else {
					// 到这里知道当前节点已经到下一层了，因此开始结算上一层节点数
					maxWidth = Math.max(maxWidth, currLevelNodes);
					// 因为已经到下一层并且当前节点已经进入处理流程了，所以设置当前层节点数为1
					currLevelNodes = 1;
					// 上一层结算完毕，指示层加1
					currLevel++;
				}
				// 依次先将左节点加入队列，并在哈希表中记录对应层数
				if (curr.left != null) {
					queue.offer(curr.left);
					map.put(curr.left, currNodeLevel + 1);
				}
				// 然后将右节点加入队列，同样记录层数
				if (curr.right != null) {
					queue.offer(curr.right);
					map.put(curr.right, currNodeLevel + 1);
				}

			}

			// 走完最后一个节点实际上是没有结算的，就这样直接退出返回的maxWidth是上一阶段的结算结果，因此需要在返回时进行结算
			return Math.max(maxWidth, currLevelNodes);
		}
		return 0;
	}

	/**
	 * 只使用队列
	 */
	public static int getWidthOfTree_2(TreeNode head) {
		// 当前层最后一个节点
		TreeNode nodeCurrEnd = head;
		// 下一层最后一个节点
		TreeNode nodeNextEnd = null;
		// 当前层节点数
		int currLevelNodes = 0;
		int maxWidth = Integer.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			// 先将左节点放入队列，nextEnd更新
			if (head.left != null) {
				queue.offer(head.left);
				nodeNextEnd = head.left;
			}
			// 再将右节点放入队列，nextEnd更新。同样使用了迭代的思想，我们不能预先知道nextEnd到底是哪个节点，只能不断地更新推进
			if (head.right != null) {
				queue.offer(head.right);
				nodeNextEnd = head.right;
			}
			currLevelNodes++;
			// 这一步最重要，如果当前节点是最后一个节点了，开始结算，将nextEnd拷贝上去，设置为新的当前层最后一个节点
			// 并将节点数归0 nextEnd置空
			if (head == nodeCurrEnd) {
				maxWidth = Math.max(maxWidth, currLevelNodes);
				nodeCurrEnd = nodeNextEnd;
				currLevelNodes = 0;
				nodeNextEnd = null;
			}
		}
		return maxWidth;
	}

}
