import java.util.OptionalInt;

public class LinkedListDeque<T> {
    public class Node {
        public Node prev;
        public T item;
        public Node next;
        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public Node sentinel;
    public int size;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Creates a deep copy of other.
     * @param other
     */
    public LinkedListDeque(LinkedListDeque other) {

    }

    /** Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the end of the deque */
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentinel.prev == sentinel;
    }

    /**
     *  Returns the number of items in the deque
     *  take constant time
     */
    public int size() {
        return size;
    }

    /**
    * Prints the items in the deque from first to last, separated by a space.
    * Once all the items have been printed, print out a new line.
    */
    public void printDeque() {
        Node copyNode = sentinel;
        while(copyNode.next != sentinel) {
            System.out.print(copyNode.next.item + " ");
            copyNode = copyNode.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque
     * If no such item exists, returns null
     */
    public T removeFirst() {
        if (!isEmpty()) {
            T firstNode = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return firstNode;
        } else {
            return null;
        }
    }
    /**
     * Removes and returns the item at the back of the deque
     * If no such item exists, returns null
     */
    public T removeLast() {
        if (sentinel.prev != sentinel) {
            T lastNode = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return lastNode;
        } else {
            return null;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * iteration
     */
    public T get(int index) {
        int length = size();
        if (length > index) {
            Node copyNode2 = sentinel;
            for (int i = 0; i < index; i++) {
                copyNode2 = copyNode2.next;
            }
            return copyNode2.item;
        } else {
            return null;
        }
    }

    /**
     * recursion
     * index-1 and .next until find the target index and return value of item
     */
    public T getRecursive(int index) {
        int length = size();
        Node copyNode3 = sentinel;
        if (length > index) {
            return transverse(copyNode3, index);
        } else {
            return null;
        }
    }

    public T transverse(Node node, int i) {
        if (i == 0) {
            return node.item;
        }
        return transverse(node.next, i - 1);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> LLD = new LinkedListDeque<>();
        System.out.println("is empty? " + LLD.isEmpty());
        LLD.addFirst(4);
        LLD.addFirst(2);
        LLD.addLast(6);
        LLD.addLast(8);
        System.out.println("is empty? " + LLD.isEmpty());
        System.out.println("size is " + LLD.size());
        LLD.printDeque();
        LLD.removeFirst();
        LLD.removeLast();
        LLD.printDeque();
        System.out.println(LLD.get(1));
        System.out.println(LLD.getRecursive(2));
    }
}
