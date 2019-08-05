package myLinkedList;
/**
 * 第一如下的数据类存储结点信息
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
 * 实现单链表的基本操作
 * @author Administrator
 *
 */
public class MyLinkedList {
	
	Node head = null;	//链表头引用
	
	/**
	 * 向链表中插入数据
	 * @param d 数据内容
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
		//添加结点结束
		temp.next = newNode;
	}
	/**
	 * @param index 删除第index个元素
	 * @return
	 */
	public boolean deleteNode(int index) {
		//删除元素位置不合理
		if(index<1||index>length()) {
			return false;
		}
		//删除第一个元素
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
	 * 返回结点长度
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
	 * 对链表进行排序
	 * 返回排序后的头结点
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
	 * 打印链表
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
		
		System.out.println("链表长度："+list.length());
		System.out.println("排序前：");
		list.printList();
		System.out.println("删除第二个元素"+list.deleteNode(2));
		System.out.println("链表长度："+list.length());
		System.out.println("排序后：");
		list.orderList();
		list.printList();
	}
}

