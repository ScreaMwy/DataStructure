public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] data;

    private int size;

    public ArrayStack(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayStack() {
        this(ArrayStack.DEFAULT_CAPACITY);
    }

    
}