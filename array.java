public class array {
    private int[] arr;
    private int size;

    public array(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    // Add an element to the end of the array
    public void insert(int element) {
        if (size < arr.length) {
            arr[size] = element;
            size++;
        } else {
            // You can implement resizing logic here if needed
            System.out.println("Array is full. Cannot add more elements.");
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

        customArray.insert(10);
        customArray.insert(20);
        customArray.insert(30);
        customArray.insert(40);
        customArray.insertPOS(60, 2);

        customArray.display(); // Output: 10 20 60 30 40

        customArray.delete(3); // Delete the element at index 3

        customArray.display(); // Output: 10 20 40
    }
}
