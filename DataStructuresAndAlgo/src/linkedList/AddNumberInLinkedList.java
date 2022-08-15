package linkedList;
//https://leetcode.com/problems/add-two-numbers/solution/

public class AddNumberInLinkedList {

	// Definition for singly-linked list.

	public static void main(String arg[]) {

		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);

		// Excellent technique via recurrsion
		// sumTwoElementRec(l1,l2,0);
		addTwoNumbers(l1, l2);

	}

	public static class ListNode {
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

	private static ListNode sumTwoElementRec(ListNode p, ListNode q, int carry) {
		ListNode l;
		// Boundry
		if (p == null && q == null) {
			if (carry > 0) {
				return new ListNode(carry);
			} else {
				return null;
			}
		}

		else {

			int p_val = p == null ? 0 : p.val;
			int q_val = q == null ? 0 : q.val;
			int sum = (p.val + q.val) % 10;
			int c = (p_val + q_val) / 10;
			l = new ListNode(sum);
			l.next = sumTwoElementRec(p.next, q.next, c);
			// return new ListNode(sum);
			// return sumTwoElementRec(p.next,q.next, c);
		}

		return l;

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = l1;
		ListNode q = l2;
		ListNode head = new ListNode();
		ListNode result = head;
		int carry = 0;

		while (p != null || q != null) {
			int val_p = (p != null) ? p.val : 0;
			int val_q = (q != null) ? q.val : 0;
			int sum = (val_p + val_q + carry) % 10;
			carry = (val_p + val_q + carry) / 10;
			ListNode temp = new ListNode(sum);
			result.next = temp;
			// To avoid null pointer when one of p and q is null
			p = (p != null) ? p.next : null;
			q = (q != null) ? q.next : null;
			result = result.next;
		}

		// Handling the corner case when we have only carry at last place no digit
		if (carry != 0) {
			result.next = new ListNode(carry);
		}

		return head.next;

	}

}
