package DataStructure;

public class LinkedList {
	
	private ListNode head;		// head 라는 노드를 만든다
	public LinkedList() {		// head 초기화
		head = null;
	}
	
	public void insertMiddleNode(ListNode pre, String data) {
		ListNode newNode = new ListNode(data);				// data만 가진 newNode 생성
		newNode.link = pre.link;							// 
		pre.link = newNode;
	}
	
	public void insertLastNode(String data) {
		ListNode newNode = new ListNode(data);
		if(head==null) {
			this.head = newNode;
		}
		else {
			ListNode temp = head;
			while (temp.link != null) {
				temp = temp.link;
			}
			temp.link = newNode;
		}
	}
	
	public void deleteLastNode() {
		ListNode pre, temp;
		if (head==null)
			return;
		if (head.link==null)
			head = null;
		else {
			pre = head;
			temp = head.link;
			while (temp.link != null) {
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	
	public ListNode searchNode(String data) {
		ListNode temp = this.head;
		while (temp != null) {
			if (data == temp.getData())
				return temp;
			else
				temp = temp.link;
		}
		return temp;
	}
	
	public void reverseList() {
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		
		while (next != null) {
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	
	public void printList() {
		ListNode temp = this.head;
		System.out.print("L=(");
		
		while (temp != null) {
			System.out.print(temp.getData());
			temp = temp.link;
			if (temp != null) {
				System.out.print(", ");
			}
		}
		System.out.println(")");
	}
}
