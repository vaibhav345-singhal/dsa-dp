package LinkedList;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(T value) {
        Node<T> node = new Node<T>(value);
        head = node;
        tail = node;
        length = 1;
    }

    public void append(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            head = node;
            tail = node;
            length++;
            return;
        }
        tail.next = node;
        tail = node;
        length++;
    }

    public void prepend(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            head = node;
            tail = node;
            length++;
            return;
        }
        node.next = head;
        head = node;
        length++;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > length) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            prepend(value);
            return;
        }

        if (index == length) {
            append(value);
            return;
        }

        Node<T> node = new Node<>(value);
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        length++;
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index out of bounds");
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }
        if (index == (length - 1)) {
            return removeLast();
        }

        Node<T> temp = head;
        Node<T> pre = null;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            pre = temp;
        }
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node<T> removeLast() {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        }
        Node<T> ans = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }

            tail = temp;
            tail.next = null;
        }
        length--;
        return ans;
    }

    public Node<T> removeFirst() {
        Node<T> ans = head;
        if (head == null) return null;
        else if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            head = head.next;
            temp.next = null;

        }
        length--;
        return ans;
    }

    public T get(int index) {
        if (index < 0 || index >= length) return null;
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= length) return;
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
    }

    public Node<T> findKthFromLast(int k){
        Node<T> fast = head;
        Node<T> slow = head;

        for(int i=0; i<k; i++){
            if(fast == null) return null; // doesn't have enough elements
            else fast = fast.next;
        }
        // when fast will reach at the end slow pointer will always be k steps behind
        // from fast so we will get kth node from last
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void reverse(){

    }

    public void print() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void printAll() {
        extracted();
    }

    private void extracted() {
        getHead();
        getTail();
        getLength();
        print();
    }

    public void getLength() {
        System.out.println("Length " + length);
    }

    public void getHead() {
        System.out.println("Head " + (head != null ? head.value : null));
    }

    public void getTail() {
        System.out.println("Tail " + (tail != null ? tail.value : null));
    }
}
