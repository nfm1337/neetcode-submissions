class ListNode:
    def __init__(self, key: int = -1, value: int = -1):
        self.key = key
        self.value = value
        self._next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def add(self, node: ListNode):
        cur = self.head
        existed = self.get(node.key)
        if not existed:
            self.head = node
            self.head._next = cur
        else:
            existed.value = node.value

    def get(self, key: int) -> ListNode | None:
        cur = self.head
        while cur:
            if cur.key == key:
                return cur
            cur = cur._next
        return None

    def remove(self, key: int):
        dummy = ListNode()
        dummy._next = self.head
        cur = self.head
        prev = dummy

        while cur:
            if cur.key == key:
                prev._next = cur._next
                self.head = dummy._next
                return
            prev = cur
            cur = cur._next



class MyHashMap:

    def __init__(self, size: int = 16):
        self.size = size
        self.buckets = [LinkedList() for _ in range(self.size)]

    def _hash(self, key: int) -> int:
        return key % self.size

    def put(self, key: int, value: int) -> None:
        node = ListNode(key, value)
        self.buckets[self._hash(key)].add(node)

    def get(self, key: int) -> int:
        node = self.buckets[self._hash(key)].get(key)
        return node.value if node else -1

    def remove(self, key: int) -> None:
        self.buckets[self._hash(key)].remove(key)


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)