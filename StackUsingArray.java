import static java.lang.System.exit;

class StackUsingArray
{
    int top=-1;
    int arr[]=new int[10];

    void push(int data)
    {
        this.top++;
        this.arr[this.top]=data;
    }

    void pop()
    {
        System.out.println(this.arr[this.top]);
        this.top--;
    }

    void printStack()
    {
        for(int i=0; i<=this.top; i++)
            System.out.print(this.arr[i] + " ");
    }

    public static void main(String[] args)
    {
        StackUsingArray st = new StackUsingArray();
        st.push(1);
        st.push(2);
        st.push(3);
        st.printStack();
        st.pop();
        st.push(4);
        st.printStack();

    }
}