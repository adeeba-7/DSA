public class array {
    private int[] arr;
    private int size;

    public array(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    // Add an element to the end of the array
    public void insertfirst(int element) {
        int index=0;
        if (size < arr.length) {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
            size++;
        } else {
            // You can implement resizing logic here if needed
            System.out.println("Array is full. Cannot add more elements.");
        }
    }

    public void insertLast(int element) {
        if (size < arr.length) {
            arr[size] = element;
            size++;
        } else {
            System.out.println("Array is full. Cannot insert at the last position.");
        }
    }

    public void insertPOS(int element, int index) {
        if (index < 0 || index > size || size == arr.length) {
            System.out.println("Invalid index or array is full.");
        } else {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
            size++;
        }
    }

    // Delete an element at a specific index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
        } else {
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }
    }

    public void deleteFirst() {
        if (size > 0) {
            delete(0);
        } else {
            System.out.println("Array is empty. Nothing to delete.");
        }
    }

    public void deleteLast() {
        if (size > 0) {
            delete(size - 1);
        } else {
            System.out.println("Array is empty. Nothing to delete.");
        }
    }

    // Get the size of the array
    public int size() {
        return size;
    }

    // Display the elements in the array
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        array customArray = new array(5);

        customArray.insertfirst(10);
        customArray.insertLast(20);
        customArray.insertfirst(30);
        customArray.insertLast(40);
        customArray.insertPOS(60, 2);

        customArray.display(); // Output: 10 20 60 30 40

        customArray.delete(3); // Delete the element at index 3

        customArray.display(); // Output: 10 20 40
    }
}
