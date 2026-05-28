class MyHashSet:

    def __init__(self):
        self.buckets = [set() for _ in range(16)]

    def _hash(self, key: int) -> int:
        return key % 16

    def add(self, key: int) -> None:
        k_hash = self._hash(key)
        self.buckets[k_hash].add(key)

    def remove(self, key: int) -> None:
        k_hash = self._hash(key)
        if self.contains(key):
            self.buckets[k_hash].remove(key)
        

    def contains(self, key: int) -> bool:
        k_hash = self._hash(key)
        return key in self.buckets[k_hash]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)