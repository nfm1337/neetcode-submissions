class LRUCache {
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new LinkedList<>();
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        list.remove((Integer) key);
        list.add(key);
        return map.get(key);
}

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
        }
        map.put(key, value);
        list.add(key);
        if (list.size() > capacity) {
            int removed = list.removeFirst();
            map.remove(removed);
        }
    }
}
