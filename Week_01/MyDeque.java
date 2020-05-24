class MyDeque {
    private class ListNode {
        ListNode next;
        ListNode previous;
        int value;
        ListNode(int x) {
            value = x;
        }
    }
    private ListNode head;
    private ListNode tail;
    private int size;
    private int initialSize;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyDeque(int k) {
        this.initialSize = k;
        ListNode listNode = new ListNode(0);
        if (k == 1) {
            this.head = listNode;
            this.tail = listNode;
        } else if (k > 1){
            this.head = listNode;
            ListNode curr = listNode;
            for (int i = k; i > 1; i--) {
                ListNode next = new ListNode(0);
                listNode.next = next;
                next.previous = listNode;
                curr = listNode.next;
            }
            this.tail = curr;
        }
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.isFull())
            return false;
        if (this.isEmpty()) {
            ListNode item = new ListNode(value);
            head = item;
            tail = item;
            size = 1;
            return true;
        }
        ListNode item = new ListNode(value);
        head.previous = item;
        item.next = head;
        head = item;
        size = size + 1;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.isFull())
            return false;
        if (this.isEmpty()) {
            ListNode item = new ListNode(value);
            head = item;
            tail = item;
            size = 1;
            return true;
        }
        ListNode item = new ListNode(value);
        tail.next = item;
        item.previous = tail;
        tail = item;
        size = size + 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == initialSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */