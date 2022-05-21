package binarytree;

/**
 * @author XuBowen
 * @date 2021/10/2 20:16
 *
 * 获取一个节点的后继节点
 * 概念：在中序遍历中，当前节点的下一个节点就是当前节点的后继节点
 * 如果是普通解法的话只需要中序遍历就可以了，时间复杂度为O(N)
 *
 * 但现在新加一个条件：每一个节点都新增一个指向父节点的指针
 * 那么就有一种方法使得时间复杂度降为O(k)
 * 对于寻找一个节点的后继节点有两种情况：
 * （1）当前节点有右子树，那么后继节点就是右子树的zuizuojiedian
 * （2）当前节点无右子树，那么就迭代此节点向上查找，直到找到某一节点是其父节点的左节点
 * 		如果一直找不到，那么返回空
 */
public class RESC10_SuccessorNode {
	public static void main(String[] args) {

	}

	public static ParentTreeNode getSuccessorNode(ParentTreeNode node){
		if (node == null){
			return null;
		}

		// 当前节点有右子树
		if (node.right != null){
			return getLeftMost(node.right);
		}else {
			// 当前节点没有右子树
			ParentTreeNode parent=node.parent;
			// 这一个判断就能包含两种情况了，很巧妙
			while (parent !=null && parent.left!=node){
				node=parent;
				parent=node.parent;
			}
			return parent;
		}
	}

	public static ParentTreeNode getLeftMost(ParentTreeNode node){
		if (node == null){
			return null;
		}

		while (node.left!=null){
			node=node.left;
		}

		return node;
	}

	public static class ParentTreeNode{
		public int value;
		public ParentTreeNode left;
		public ParentTreeNode right;
		public ParentTreeNode parent;

		public ParentTreeNode(int value, ParentTreeNode left, ParentTreeNode right, ParentTreeNode parent) {
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
}
