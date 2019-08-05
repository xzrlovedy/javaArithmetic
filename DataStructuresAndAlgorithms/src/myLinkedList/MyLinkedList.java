package myLinkedList;
/**
 * ��һ���µ�������洢�����Ϣ
 * @author Administrator
 *
 */
class Node{
	Node next = null;
	int data;
	public Node(int data) {
		this.data = data;
	}
}
/**
 * ʵ�ֵ�����Ļ�������
 * @author Administrator
 *
 */
public class MyLinkedList {
	
	Node head = null;	//����ͷ����
	
	/**
	 * �������в�������
	 * @param d ��������
	 */
	public void addNode(int d) {
		Node newNode = new Node(d);
		if(head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		//��ӽ�����
		temp.next = newNode;
	}
	/**
	 * @param index ɾ����index��Ԫ��
	 * @return
	 */
	public boolean deleteNode(int index) {
		//ɾ��Ԫ��λ�ò�����
		if(index<1||index>length()) {
			return false;
		}
		//ɾ����һ��Ԫ��
		if(index==1) {
			head = head.next;
			return true;
		}
		int i = 2;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode!=null) {
			if(i==index) {
				preNode.next=curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	/**
	 * ���ؽ�㳤��
	 * @return
	 */
	public int length() {
		int length = 0;
		Node tmp = head;
		while(tmp!=null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	/**
	 * �������������
	 * ����������ͷ���
	 */
	public Node orderList() {
		Node nextNode = null;
		int temp = 0;
		Node curNode = head;
		while(curNode.next!=null) {
			nextNode = curNode.next;
			while(nextNode!=null) {
				if(curNode.data>nextNode.data) {
					temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	
	/**
	 * ��ӡ����
	 */
	public void printList() {
		Node tmp = head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		list.addNode(3);
		
		System.out.println("�����ȣ�"+list.length());
		System.out.println("����ǰ��");
		list.printList();
		System.out.println("ɾ���ڶ���Ԫ��"+list.deleteNode(2));
		System.out.println("�����ȣ�"+list.length());
		System.out.println("�����");
		list.orderList();
		list.printList();
	}
}

