class DynamicArray {

    private int[] array;
    private int size = 0;

    public DynamicArray(int capacity) {
        array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == array.length) {
            resize();
        }
        array[size++] = n;
    }

    public int popback() {
        return array[--size];
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}