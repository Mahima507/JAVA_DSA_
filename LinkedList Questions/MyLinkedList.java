// 707. Design Linked List
class MyLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    private ListNode head;
    private int length;
    
    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= length)
            return -1;
        
        ListNode curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        
        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        length++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }
        
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > length)
            return;
        
        if (index <= 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++)
                curr = curr.next;
            
            ListNode newNode = new ListNode(val);
            newNode.next = curr.next;
            curr.next = newNode;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length)
            return;
        
        if (index == 0) {
            head = head.next;
        } else {
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++)
                curr = curr.next;
            
            curr.next = curr.next.next;
        }
        
        length--;
    }
}

