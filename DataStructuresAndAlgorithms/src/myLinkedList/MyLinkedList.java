package myLinkedList;

import java.util.Hashtable;

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
	
	/**
	 * 从链表中删除重复数据
	 * @param head
	 */
	public void deleteDuplecate(Node head) {
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		Node tmp = head;
		Node pre = null;
		while(tmp!=null) {
			if(table.containsKey(tmp.data)) {
				pre.next = tmp.next;
			}else {
				table.put(tmp.data, 1);
				pre = tmp;
			}
			tmp = tmp.next;
		}
	}
	
	/**
	 * 找出单链表倒数第k个元素
	 * @param head
	 * @param k
	 * @return
	 */
	public Node finfElem(Node head,int k) {
		if(k<1) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;
		for(int i=0;i<k-1&&p1!=null;i++) {//前移k-1步
			p1 = p1.next;
		}
		if(p1 == null) {
			System.out.println("k不合法");
			return null;
		}
		while(p1.next!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	/**
	 * 实现链表反转
	 * @param head
	 */
	public void ReverseIteratively(Node head) {
		Node pReversedHead = head;
		Node pNode = head;
		Node pPrev = null;
		while(pNode!=null) {
			Node pNext = pNode.next;
			if(pNext == null) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		this.head = pReversedHead;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
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
		System.out.println("删除重复元素：");
		list.deleteDuplecate(list.head);
		System.out.println("链表长度："+list.length());
		list.printList();
		System.out.println("倒数第1个元素："+list.finfElem(list.head, 1).data);
		System.out.println("链表反转：");
		list.ReverseIteratively(list.head);
		list.printList();
	}
}

