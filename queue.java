
class Deque<Base> {
  private class Node {
    private Base object;
    private Node left;
    private Node right;

    private Node (Base object, Node left, Node right) {
      this.object = object;
      this.left   = left;
      this.right  = right; 
    }    
  }

  private Node head;
  public Deque() {
    head        = new Node (null, null, null);
    head.left   = head;
    head.right  = head;
  }

  public void enqueueFront(Base object) {
    Node newNode    = new Node(object, head, head.right);
    head.right.left = newNode;
    head.right      = newNode;     
  }

  public void enqueueRear(Base object) {
    Node newNode    = new Node(object, head.left, head);
    head.left.right = newNode;
    head.left       = newNode;
  }

  public Base dequeueFront() {
    if (isEmpty()) {
        throw new IllegalStateException("empty");
    }
    else {
        Node temp       = head.right;
        head.right      = temp.right;
        temp.right.left = head;

        return temp.object;
    }
  }

  public Base dequeueRear() {
    if (isEmpty()) {
        throw new IllegalStateException("empty");
    }
    else {
        Node temp       = head.left;
        head.left       = temp.left; 
        temp.left.right = head;
    
        return temp.object;
    }
  }

  public boolean isEmpty() {
    return head.right == head && head.left == head;
  }
}

