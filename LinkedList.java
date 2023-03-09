public class LinkedList {

	Node head;

	//node class 

	static class Node {

		int data;

		Node next;

		public Node(int data) {

			this.data = data;

		}

	}

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList l3 = new LinkedList();

		 
		l1.add(0);
		l1.add(1);
		l1.add(7);
		l1.add(13);

		l2.add(4);
		l2.add(5);
		l2.add(9);
 
 

		// reverse(l);
		//l1.reverseRecur(null, null);

	 

		  l3.mergeSortedList(l1, l2).print();

	}

	// A method that adds a node at the end of a given LinkedList
	void add(int data) {

		// initialize the node with its value
		Node n = new Node(data);

		if (head == null) {

			head = n;

		}

		else {

			Node curr = head;

			// find the end of the list
			while (curr.next != null) {

				curr = curr.next;

			}

			// add at the end of the list
			curr.next = n;

		}

	}

	// print the each node's vale
	void print() {

		System.out.print(head.data + " ");

		while (head.next != null) {

			System.out.print(head.next.data + " ");

			head = head.next;
		}

	}

	// delete a given node from the LinkedList
	void delete(int data) {

		if (head.data == data) {

			head = head.next;

		} else {

			Node curr = head;

			while (curr.next != null) {

				// when match if found
				if (curr.next.data == data) {

					// point to the node after the one that is to be deleted
					// in order to skip it
					if (curr.next.next != null) {
						curr.next = curr.next.next;

					}

					// when a match is found at the tail just make it null
					else {

						curr.next = null;
						break;
					}

				}

				curr = curr.next;

			}

		}

	}

	// finding the middle element
	int findTheMiddleElement() {

		Node slow = head;

		Node fast = head;

		// fast.next !=null works for odd length and fast.next.next !=null works for
		// even length
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;

			fast = fast.next.next;

		}

		return slow.data;

	}

	// reverse the LinkedList
	Node reverse() {

		Node prev = null;

		Node next = null;

		while (head != null) {

			// save the node next to head
			next = head.next;

			// point next node to previous
			head.next = prev;

			// make the previous node a head moving it along
			prev = head;

			// make the head next node moving it along also
			head = next;

		}

		// To print the reversed LinkedList
		System.out.print(prev.data + "---> ");

		while (prev.next != null) {

			System.out.print(prev.next.data + "---> ");

			prev = prev.next;
		}

		if (prev.next == null) {

			System.out.println("null");
		}
		return prev;
	}

	// reversing the list with recursion same as the iterative
	// method but but done with recursion
	void reverseRecur(Node prev, Node next) {

		next = head.next;

		head.next = prev;

		prev = head;

		head = next;

		if (head == null) {

			// To print the reversed LinkedList
			System.out.print(prev.data + "---> ");

			while (prev.next != null) {

				System.out.print(prev.next.data + "---> ");

				prev = prev.next;
			}

			if (prev.next == null) {

				System.out.println("null");
				return;
			}

		}

		reverseRecur(prev, next);
	}

	// Rearrange the list with odds and evens
	// not actual values but indexes (OOOOEEEE)
	// create odd and even lists and merge them
	Node oddEven(LinkedList l) {

		Node oddHead = head;
		Node evenHead = head.next;
		Node EvenH = evenHead;

		while (oddHead.next != null && evenHead.next != null) {

			// the next odd index is next even index
			oddHead.next = evenHead.next;

			// move the next odd index
			oddHead = oddHead.next;

			// the next even index is next odd index
			evenHead.next = oddHead.next;

			// move the next odd index
			evenHead = evenHead.next;

		}

		// tag on the even values after the odd ones
		oddHead.next = EvenH;

		return head;

	}

	// check if a the list is a palindrome
	// invert the left side from the half side
	// Compare with the right

	boolean isPalindrome() {

		boolean isitaPalindrome = true;

		Node fast = head;
		Node slow = head;

		// pointers to invert the left side
		Node prev = null;
		Node curr = head;
		Node next = head.next;

		while (fast.next != null && fast.next.next != null) {

			// fast moves twice as fast as the slow pointer
			fast = fast.next.next;
			slow = slow.next;

			// reverse the left side
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}

		// odd number of length
		if (fast.next == null) {

			if (prev.data != slow.next.data) {

				return false;

			}

			// prev moves to the left from half side
			// slow moves to the right side
			// comparing each side

			while (slow.next != null && prev.next != null) {

				// it needs to be done before if statement
				slow = slow.next;

				if (prev.next.data != slow.next.data) {

					return false;
				}

				prev = prev.next;

			}

			// even number of length
		} else {

			if (slow.data != slow.next.data) {

				return false;

			}

			slow = slow.next.next;

			// prev moves to the left from half side
			// slow moves to the right side
			// comparing each side
			while (slow != null && prev != null) {

				if (prev.data != slow.data) {

					return false;
				}

				slow = slow.next;
				prev = prev.next;

			}

		}

		return isitaPalindrome;

	}

	// Convert Binary Number in a Linked List to Integer
	int getDecimalValue(Node head) {

		int result = 0;

		int counter = 0;

		// if only one the head exists it will be the answer
		if (head.next == null) {

			return result += head.data;

		}

		// calculate the decimal value starting from the head
		while (head != null) {

			result += head.data * Math.pow(2, counter);

			counter++;
			head = head.next;

		}

		return result;

	}

	// Merge the two sorted lists in a one sorted list
	LinkedList mergeSortedList(LinkedList l1, LinkedList l2) {

		LinkedList l3 = new LinkedList(); // new linked list that will be returned

		l3.head = new Node(0); // assign a dummy head value to avoid nullpointerexception

		Node l3_curr = l3.head; // create a node for the current value

		while (l1.head != null && l2.head != null) {

			// when the value form the second linked list is greater
			if (l1.head.data < l2.head.data) {

				// assign current value from the first linked list
				l3_curr.next = l1.head;
				l1.head = l1.head.next;

				// when the value form the first linked list is greater
			} else if (l1.head.data > l2.head.data) {

				// assign current value from the second linked list
				l3_curr.next = l2.head;
				l2.head = l2.head.next;

				// when they are the same
			} else if (l1.head.data == l2.head.data) {

				// assign both values from the linked list for the current value
				l3_curr.next = l1.head;
				l1.head = l1.head.next;
				l3_curr = l3_curr.next;
				l3_curr.next = l2.head;
				l2.head = l2.head.next;

			}

			l3_curr = l3_curr.next;
		}

		// when all the first linked list values are matched
		// assign the rest of the second linked list to the current value
		if (l2.head != null) {

			l3_curr.next = l2.head;

			// when all the second linked list values are matched
			// assign the rest of the first linked list to the current value
		} else if (l1.head != null) {

			l3_curr.next = l1.head;
		}

		// The merged sort starts after the dummy head value
		l3.head = l3.head.next;

		return l3;

	}

}
