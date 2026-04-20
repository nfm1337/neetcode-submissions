


class HashTable {

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }  

    private Pair[] arr;
    private int size;
    private int capacity;


    public HashTable(int capacity) {
        this.arr = new Pair[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(int key, int value) {
        int hash = hash(key);

        Pair pair = new Pair(key, value);

        int index = hash;
        while (true) {
            if (arr[index] == null) {
                arr[index] = pair;
                this.size++;
                if (this.size >= this.capacity / 2) {
                    this.resize();
                }
                return;
            } else if (arr[index].key == key) {
                arr[index].value = value;
                return;
            }

            index++;
            index %= this.capacity;
        }
    }

    public int get(int key) {
        int index = hash(key);

        while (arr[index] != null) {
            if (arr[index].key == key) {
                return arr[index].value;
            }
            index++;
            index %= this.capacity;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = hash(key);

        while (arr[index] != null) {
            if (arr[index].key == key) {
                arr[index] = null;
                this.size--;
                return true;
            }
            index++;
            index %= this.capacity;
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        Pair[] oldArr = this.arr;
        this.capacity *= 2;
        this.size = 0;
        this.arr = new Pair[this.capacity];

        for (Pair pair : oldArr) {
            if (pair != null) {
                insert(pair.key, pair.value);
            }
        }
    }

    private int hash(int key) {
        return key % this.capacity;
    }
}
