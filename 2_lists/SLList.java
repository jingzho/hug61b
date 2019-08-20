/** SLList is composed of IntNode(s) */
public class SLList {
	public class IntNode {
			public int item;
			public IntNode next;
			public IntNode(int i, IntNode n) {
					item = i;
					next = n;
			}
	}

	private IntNode first; 

	public SLList(int x) {
			first = new IntNode(x, null);
	}

	/** Adds an item to the front of the list. */
	public void addFirst(int x) {
			first = new IntNode(x, first);
	}    

	/** Retrieves the front item from the list. */
	public int getFirst() {
			return first.item;
	}

	/** Adds an item to the end of the list. */
	public void addLast(int x) {
		// must create a new L, or the original SLList will be changed forever
		IntNode L = first;
		// move L until it reachs the end of SLList
		if (L.next != null) {
			L = L.next;
		}
		// add x (IntNode) to the end of SLList
		L.next = new IntNode(x, null);

	}

	private static int size(IntNode p) {
		// reach the end of SLList, return 1
		while (p.next == null) {
			return 1;
		}
		return 1 + size(p.next);
	}

	/** Returns the number of items in the list using recursion. */
	public int size() {
		return size(first);
	}

	public static void main(String[] args) {
		SLList S  = new SLList(5);
		S.addFirst(3);
		S.addLast(7);
		System.out.println(S.size());
	}

}