/**
 *
 */
public class Array<T> {
    private static final int DEFUAL_CAPACITY = 10;

    private T[] arrays;

    private int size;

    /**
     * @param capacity
     */
    public Array(int capacity) {
        this.arrays = (T[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(Array.DEFUAL_CAPACITY);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.arrays.length;
    }

    public boolean isEmpty() {
        return (0 == this.size) ? true : false;
    }

    /**
     * @return int[]
     */
    private void realloc(int newCapacity ) {
        T[] newArrays = (T[]) new Object[newCapacity];
        for (int i = 0; i < this.arrays.length; i++) {
            newArrays[i] = arrays[i];
        }
        this.arrays = newArrays;
    }

    /**
     * @param e
     */
    public void add(T e) {
        if (this.size == this.arrays.length) {
            realloc(this.arrays.length * 2);
        }
        this.arrays[size++] = e;
    }

    /**
     * @param e
     * @param location
     * @throws Exception
     */
    public void add(T e, int location) throws Exception{
        if (location < 1 || location > this.arrays.length) {
            throw new IllegalArgumentException("Location what input by user is illegal.(1 < location < array.length)");
        }

        int index = --location;
        for (int i = size; i > index; i--) {
            this.arrays[i] = this.arrays[i - 1];
        }
        this.arrays[index] = e;
        this.size++;
    }

    /**
     * @param e
     * @param low
     *
     * @param high
     * @return
     */
    private int search(T e, int low, int high) {
        for (int i = low; i <= high; i++) {
            if (e.equals(this.arrays[i])) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(T e, int low, int high) {
        int mid = 0;
        if (low <= high) {
            mid = (low + high) / 2;
            binarySearch(e, low, mid);
            binarySearch(e, mid + 1, high);
            search(e, low, high);
        }
        return -1;
    }

    /**
     * @param e
     * @return
     */
    public boolean remove(T e) {
        int targetIndex = binarySearch(e, 0, this.size);
        if (targetIndex > 0) {
            for (int i = targetIndex; i < this.size; i++) {
                this.arrays[i] = this.arrays[i + 1];
            }
            this.size--;
            this.arrays[size] = null;

            if (this.size == this.arrays.length / 4 && 0 != this.arrays.length / 2) {
                realloc(this.arrays.length / 2);
            }
        }
        return false;
    }

    /**
     * @param e
     * @param location
     */
    public void set(T e, int location) {

    }

    public int get(T e) {
        return this.binarySearch(e, 0, this.size);
    }

    public void display() {
        String str = toString();
        System.out.printf("%s", str);
    }

    @Override
    public String toString() {
        if (null == this.arrays) {
            return "null";
        }

        if (0 == this.size) {
            return "[]";
        }

        int max = this.size - 1;
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; ; i++) {
            str.append(this.arrays[i]);
            if (max == i) {
                return str.append(']').toString();
            }
            str.append(", ");
        }
    }
}
