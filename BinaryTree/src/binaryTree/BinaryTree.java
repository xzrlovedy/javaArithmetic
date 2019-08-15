package binaryTree;
/**
 * ���������ȣ��У���������
 * @author Administrator
 *
 */
public class BinaryTree {
	private Node root;
	public BinaryTree() {
		root = null;
	}
	
	//����data����������
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
		}else {
			Node current = root;
			Node parent;
			while(true) {//Ѱ�Ҳ����λ��
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
	
	//����ֵ���빹��������
	public void buildTree(int[] data) {
		for(int i = 0;i<data.length;i++) {
			insert(data[i]);
		}
	}
	
	//�������
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
	
	//�������
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
	
	//�������
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
		System.out.print("�������:");
		biTree.inOrder();
		System.out.print("\n�������:");
		biTree.preOrder();
		System.out.print("\n�������:");
		biTree.postOrder();
		
	}
}
