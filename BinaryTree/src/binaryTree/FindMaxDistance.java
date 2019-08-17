package binaryTree;
/**
 * ��������н���������
 * @author Administrator
 *
 */
class NodeMax extends Node{
	public NodeMax left;
	public NodeMax right;
	public int leftMaxDistance;		//���������������������
	public int rightMaxDistance;	//���������������������
	
	public NodeMax(int data) {
		super(data);
	}
}

public class FindMaxDistance {
	private int maxLen = 0;
	private int max(int a,int b) {
		return a>b?a:b;
	}
	public int findMaxDistance(NodeMax root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null) {
			root.leftMaxDistance = 0;
		}
		if(root.right == null) {
			root.rightMaxDistance = 0;
		}
		if(root.left != null) {
			findMaxDistance(root.left);
		}
		if(root.right != null) {
			findMaxDistance(root.right);
		}
		
		//�����������о��������������
		if(root.left != null) {
			root.leftMaxDistance = max(root.left.leftMaxDistance,root.left.rightMaxDistance)+1;
		}
		//�����������о��������������
		if(root.right != null) {
			root.rightMaxDistance = max(root.right.leftMaxDistance,root.right.rightMaxDistance)+1;
		}
		//��ȡ���������н���������
		if(root.leftMaxDistance+root.rightMaxDistance > maxLen) {
			maxLen = root.leftMaxDistance+root.rightMaxDistance;
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		FindMaxDistance find = new FindMaxDistance();
		NodeMax root = new NodeMax(1);
		NodeMax n1 = new NodeMax(2);
		NodeMax n2 = new NodeMax(3);
		NodeMax n3 = new NodeMax(4);
		NodeMax n4 = new NodeMax(5);
		NodeMax n5 = new NodeMax(6);
		
		root.left = n1;
		n1.left = n2;
		n1.right = n3;
		root.right = n4;
		n4.left = n5;
		
		System.out.println(find.findMaxDistance(root));
	}
}
