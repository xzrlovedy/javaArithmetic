package binaryTree;
/**
 * 二叉树的先，中，后序排序
 * @author Administrator
 *
 */
public class BinaryTree {
	private Node root;
	public BinaryTree() {
		root = null;
	}
	
	//插入data到二叉树中
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
		}else {
			Node current = root;
			Node parent;
			while(true) {//寻找插入的位置
				parent = current;
				if(data<current.data) {
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return;
					}
				}else {
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	//将数值输入构建二叉树
	public void buildTree(int[] data) {
		for(int i = 0;i<data.length;i++) {
			insert(data[i]);
		}
	}
	
	//中序遍历
	public void inOrder(Node localRoot) {
		if(localRoot!=null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.right);
		}
	}
	public void inOrder() {
		this.inOrder(this.root);
	}
	
	//先序遍历
	public void preOrder(Node localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.data+" ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder() {
		this.preOrder(this.root);
	}
	
	//后序遍历
	public void postOrder(Node localRoot) {
		if(localRoot!=null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data+" ");
		}
	}
	public void postOrder() {
		this.postOrder(this.root);
	}
	
	public static void main(String[] args) {
		BinaryTree biTree = new BinaryTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		biTree.buildTree(data);
		System.out.print("中序遍历:");
		biTree.inOrder();
		System.out.print("\n先序遍历:");
		biTree.preOrder();
		System.out.print("\n后序遍历:");
		biTree.postOrder();
		
	}
}
