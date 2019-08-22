/** generic SLList */

public class SLList<T> {
    public class Node {
        public T item;
        public Node next;
        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }

    /* The first node in the list is now sentinel.next */
    public Node sentinel; 
    public int size;

    /* create an empty SLList */
    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T x) {
        sentinel = new Node(x, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }    

    /** Retrieves the front item from the list. */
    public T getFirst() {
        return sentinel.next.item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds an item to the end of the list. */
    public void addLast(T x) {
        size += 1;
        Node p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
    }

    /** Gets the ith item of the list. */
    public T get(int i) {
		if (i == 0) {
			return getFirst();
		}
		Node currentNode = sentinel.next.next;
		while (i > 1 && currentNode.next != null) {
			i -= 1;
			currentNode = currentNode.next;
		}
		return currentNode.item;
	}

    /** Crashes when you call addLast on an empty SLList. Fix it. */
    public static void main(String[] args) {
        SLList<String> x = new SLList();
        x.addLast("b");
        x.addLast("bbbb");
        System.out.println(x.size());
    }
}