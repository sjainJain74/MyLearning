package linkedList;

public class Adding2Numbers {

	// Definition for singly-linked list.
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

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode head = new ListNode();
			ListNode current = head;
			int carry = 0;

			
			
			while (l1 != null || l2 != null) {
				int l1_value;
				int l2_value;

				if (l2 == null) {
					l2_value = 0;
				} else {
					l2_value = l2.val;
				}

				if (l1 == null) {
					l1_value = 0;
				} else {
					l1_value = l1.val;

				}
				current.next = new ListNode((l1_value + l2_value + carry) % 10);
				carry = (l1_value + l2_value + carry) / 10;
				current = current.next;

				if (l1 != null) {
					l1 = l1.next;
				}
				if (l2 != null) {
					l2 = l2.next;
				}

			}
			
			//9
			// 8-->9
			// 98+9 =107 Corner case
			if(carry>0) {
				current.next = new ListNode(carry);
			}

			return head.next;

		}
	}
}
