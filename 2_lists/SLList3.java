public class SLList3 {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first node in the list is now sentinel.next */
    private IntNode sentinel; 
    private int size;

    /* create an empty SLList */
    public SLList3() {
        sentinel = new IntNode(255, null);
        size = 0;
    }

    public SLList3(int x) {
        sentinel = new IntNode(255, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }    

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Crashes when you call addLast on an empty SLList. Fix it. */
    public static void main(String[] args) {
        SLList3 x = new SLList3();
        x.addLast(5);
        x.addLast(10);
        System.out.println(x.size());
    }
}