package stackAndQueue;

/**
 * 链表实现队列
 * @author Administrator
 * @param <E>
 */
class Node2<E>{
	Node2<E> next = null;
	E data;
	public Node2(E data) {
		this.data = data;
	}
}

public class MyQueue<E> {
	private Node2<E> head = null;
	private Node2<E> tail = null;
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public void put(E data) {
		Node2<E> newNode = new Node2<E>(data);
		if(head==null&&tail==null) {//队列为空
			tail = newNode;
			head = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public E pop() {
		if(this.isEmpty()) {
			return null;
		}
		E data = head.data;
		head = head.next;
		return data;
	}
	
	public int size() {
		Node2<E> tmp = head;
		int n = 0;
		while(tmp!=null) {
			n++;
			tmp = tmp.next;
		}
		return n;
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.put(1);
		q.put(2);
		q.put(3);
		
		System.out.println("队列长度："+q.size());
		System.out.println("队列首元素："+q.pop());
		System.out.println("队列首元素："+q.pop());
	}
}
