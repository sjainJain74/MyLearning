package linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListBasic {

	public static void main(String arg[]) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		// ListNode reversedUisngRec = reverseRec(l);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(3);
		l2.next.next.next = new ListNode(4);
		l2.next.next.next.next = new ListNode(5);
		// ListNode reversedUisngInteration = reverseList(l2);

		ListNode listIsPallindrome = new ListNode(1);
		listIsPallindrome.next = new ListNode(2);
		listIsPallindrome.next.next = new ListNode(3);
		listIsPallindrome.next.next.next = new ListNode(2);
		listIsPallindrome.next.next.next.next = new ListNode(1);

		// System.out.println(isPallindrome(listIsPallindrome));

		ListNode listIsPallindromeFlase = new ListNode(1);
		listIsPallindromeFlase.next = new ListNode(2);
		listIsPallindromeFlase.next.next = new ListNode(3);
		listIsPallindromeFlase.next.next.next = new ListNode(1);
		listIsPallindromeFlase.next.next.next.next = new ListNode(1);

		// System.out.println(isPallindrome(listIsPallindromeFlase));

		ListNode listIsPallindromeEven = new ListNode(1);
		listIsPallindromeEven.next = new ListNode(2);
		listIsPallindromeEven.next.next = new ListNode(2);
		listIsPallindromeEven.next.next.next = new ListNode(1);

		System.out.println(isPallindrome(listIsPallindromeEven));

	}

	public static boolean isPallindrome(ListNode head) {

		// 1->2->3->2->1
		ListNode current = head;
		ListNode slowP = current;
		ListNode fastPoint = current;

		// slowP =3 mid
		// fastPoint=1 last
		// Handle null pointer and odd even both scenario
		while (fastPoint != null && fastPoint.next != null) {
			slowP = slowP.next;
			fastPoint = fastPoint.next.next;
		}
		
		Set s = new HashSet();
		

		// 1->2->3<-2<-1
		// 1->2<-2<-1

		ListNode revHalf = reverseList(slowP);
		while (current != null && revHalf != null) {
			if (current.val != revHalf.val)
				return false;
			else {
				current = current.next;
				revHalf = revHalf.next;
			}
		}

		return true;

	}

	public  boolean void reorderList(ListNode head) {
			
		// When odd
			// 1->2->3->4->5 input 
			// 1->5->2->4->3 output
		
		// When Even
		    // 1->2->-4->5 input 
		   // 1->5->2->4 output
		
			ListNode current = head;
			ListNode slowP = current;
			ListNode fastPoint = current;
			
			//To reach the mid of linked list
			//Handle null pointer and odd even both scenario.Check once
			while (fastPoint!=null&& fastPoint.next != null) {
				slowP = slowP.next;
				fastPoint = fastPoint.next.next;
			}
			
			//Reverse Second half
			ListNode revHalf = reverseList(slowP);
			// 1->2->3->4->5 input 
			// 1->2->3<-4<-5 output
			//revHalf =5 (a head of reverse list)
			
			// 1->2->->4->5 input
			// 1->2->4<-5 output
			//revHalf =5 (a head of reverse list)
			
			//Now we have to merge 2 list
	
			//return true;
	
		}

	public static ListNode reverseRec(ListNode head) {

		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		} else {
			ListNode newHead = reverseRec(head.next);
			ListNode headNext = head.next;
			headNext.next = head;
			head.next = null;
			return newHead;
		}
	}

	public static ListNode reverseList(ListNode head) {

		ListNode current = head;
		ListNode prev = null;

		while (current != null) {

			ListNode tempNext = current.next;
			current.next = prev;
			prev = current;
			current = tempNext;
		}

		return prev;

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}