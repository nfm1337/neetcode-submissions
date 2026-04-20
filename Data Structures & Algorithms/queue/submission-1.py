class ListNode:
    def __init__(self, val, next=None, prev=None):
        self.val = val
        self.next = next
        self.prev = prev

class Deque:
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = ListNode(-1, prev=self.head)
        self.head.next = self.tail

    def isEmpty(self) -> bool:
        return self.head.next == self.tail

    def append(self, value: int) -> None:
        node = ListNode(value, next=self.tail)
        tail = self.tail
        tail.prev.next = node
        node.prev = tail.prev
        tail.prev = node

    def appendleft(self, value: int) -> None:
        node = ListNode(value, prev=self.head)
        head = self.head
        head.next.prev = node
        node.next = head.next
        head.next = node

    def pop(self) -> int:
        if self.isEmpty(): return -1
        tail = self.tail
        poped = tail.prev
        poped.prev.next = tail
        tail.prev = poped.prev
        return poped.val

    def popleft(self) -> int:
        if self.isEmpty(): return -1
        head = self.head
        poped = head.next
        head.next = poped.next
        poped.next.prev = head
        
        return poped.val
