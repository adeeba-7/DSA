import java.util.*;

class DoublyLinkedList {
    Node head; // head of list
    Node tail; // tail of list
    int num = 0;

    class Node {
        int data;
        Node next = null;
        Node prev = null;

        Node(int d) {
            data = d;
        }
    }

    public void insertEmpty(int data) {
        Node newNode = new Node(data);
        this.head = newNode;
        this.tail = newNode;
        this.num++;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
        this.num++;
    }

    public void insertPosition(int data, int pos) {
        if (pos < 0 || pos > this.num) {
            System.out.println("Invalid position");
            return;
        }
            // initialize temp node for traversal
            Node temp=head;
            int j=0; // initial position
            while(j<pos-1){
                // return if position is out of bounds
                if(temp.next==null || pos<0){
                    System.out.println("list size is less than pos \n");
                    return;
                }
                j++;
                temp=temp.next;
            }
            if (temp==null){
                System.out.println("list size is less than pos \n");
                return;
            }
            // create a new node
            else {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                newNode.prev = temp;

                temp.next = newNode;
                (newNode.next).prev = newNode;

                this.num++;
            }
        }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        newNode.prev = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        this.num++;
    }

    public void deleteFirst() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        }

        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        } else {
            this.tail = null;
        }

        this.num--;
    }

    public void deleteLast() {
        if (this.tail == null) {
            System.out.println("List is empty");
            return;
        }

        this.tail = this.tail.prev;
        if (this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null;
        }

        this.num--;
    }

    public void deletePosition(int pos)
    {
        Node temp=head;
        int j=0;
        while(j<pos-1){
            if(temp.next==null){
                System.out.println("list size is less than pos");
                return;
            }
            j++;
            temp=temp.next;
        }
        temp.next=(temp.next).next;
        (temp.next).prev=temp;
        this.num--;
    }

    public void printList() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();
        dlist.insertEmpty(1);
        dlist.printList();
        dlist.insertFirst(2);
        dlist.insertFirst(3);
        dlist.printList();
        dlist.insertPosition(4, 2);
        dlist.printList();
        dlist.insertPosition(5, 2);
        dlist.printList();
        dlist.insertLast(6);
        dlist.printList();
        dlist.deleteFirst();
        dlist.printList();
        dlist.deletePosition(2);
        dlist.printList();
        dlist.deleteLast();
        dlist.printList();
    }
}
