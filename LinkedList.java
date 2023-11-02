class LinkedList {
    Node head; // head of list

    class Node {
        int data;
        Node next;

        // Next is by default initialized as null
        Node(int d) { data = d; }
    }

    // Method to print the LinkedList.
    public void printList()
    {
        // Check whether the list is empty or not
        if(this.head==null)
        {
            System.out.println("List is empty");
            return;
        }
        Node temp = this.head;
        System.out.print("\n"+"LinkedList: ");

        // Traverse through the LinkedList
        while (temp != null) {
             System.out.print(temp.data + " ");
            // Go to next node
            temp = temp.next;
        }
        System.out.print("\n");
    }

    // Method to search DATA in the LinkedList.
    public int search(int DATA)
    {
        int pos=-1;
        // Check whether the list is empty or not
        if(this.head==null)
        {
            System.out.println("List is empty");
            return pos;
        }
        Node temp = this.head;
        pos=0;

        // Traverse through the LinkedList
        while (temp != null) {
            if(temp.data==DATA){
                System.out.println("Data is found at postion: "+ pos);
                return pos;
            }
            pos++;
            // Go to next node
            temp = temp.next;
        }
        System.out.println("Data is not in the list \n");
        return pos;
    }

    public void insertFirst(int DATA)
    {
        // create a new node
        Node newNode = new Node(DATA);
        // if list head is null, then make new node as head
        if(this.head == null){
            newNode.next = null;
        }
        else {
            newNode.next=this.head;
        }
        this.head=newNode;
    }

    public void insertLast(int DATA)
    {
        // create a new node
        Node newNode = new Node(DATA);
        newNode.next=null;
        if (this.head==null)
            this.head=newNode;
        else
        {
            Node temp= head;
            while(temp.next!= null)
                temp=temp.next;
            temp.next=newNode;
        }
    }

    public void insertPosition(int DATA, int pos)
    {
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
        // create a new node
        Node newNode = new Node(DATA);
        newNode.next=temp.next;
        temp.next=newNode;
        System.out.println("node inserted \n");
    }

    public void deleteFirst()
    {
        if(this.head == null){
            System.out.println("Can't delete: list empty \n");
            return;
        }
        this.head=(this.head).next;
    }

    public void deleteLast()
    {
        Node temp=this.head;
        while((temp.next).next!=null)
            temp=temp.next;
        temp.next=null;
    }

    public void deletePosition(int pos)
    {
        Node temp=head;
        int j=1;
        while(j<pos){
           if(temp.next==null){
               System.out.println("list size is less than pos");
               return;
           }
           j++;
           temp=temp.next;
        }
        temp.next=(temp.next).next;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.insertLast(9);
        list.insertFirst(1);
        list.insertLast(5);
        list.insertLast(3);
        list.printList();
        list.insertPosition(20,2);
        list.printList();
        list.insertPosition(2,20);
        list.deleteLast();
        list.printList();
        list.deleteFirst();
        list.printList();
        list.search(5);
        list.deletePosition(2);
        list.printList();

    }
}