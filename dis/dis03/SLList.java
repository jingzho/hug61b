 public class SLList {
  private class IntNode {
    public int item;
    public IntNode next;
    public IntNode(int item, IntNode next) {
      this.item = item; this.next = next;
    }
  }

  private IntNode first;

  public void addFirst(int x) {
    first = new IntNode(x, first);
  }

  /** 
   * @param item 
   * @param position
   * inserts x at the given position
   * If position is after the end of the list, insert the new node at the end
   * @return newList
 */
  public void insert(int item, int position) {
    /* have to make sure it is not null, or first(null) does not have .next */
    if (first == null || position == 0) {
      addFirst(item);
      return;
    }

    /* find where to insert */
    IntNode currentNode = first;
    for (int i = 1; i < position && currentNode.next != null; i += 1) {
      currentNode = currentNode.next;
    }
    /* insert and connect the prev and next with new node */
    currentNode.next = new IntNode(item, currentNode.next);

  }

  public void reverse() {
    /** if 0 or 1 item in the list, no need to reverse */
    if (first == null || first.next == null) {
      return;
    }

    IntNode currentNode = first.next;
    first.next = null; 

    while (currentNode != null) {
      addFirst(currentNode.item);
      currentNode = currentNode.next;
    }
  }

  public static void main(String[] args) {
    SLList a = new SLList();
    a.insert(0, 2); 
    a.addFirst(3);
    a.addFirst(4);
    a.insert(0, 2); 
    a.insert(0, 10);
    a.reverse();
  }
}