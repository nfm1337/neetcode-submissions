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
        new_node = ListNode(value)
        last_node = self.tail.prev

        last_node.next = new_node
        new_node.prev = last_node
        new_node.next = self.tail
        self.tail.prev = new_node 

    def appendleft(self, value: int) -> None:
        new_node = ListNode(value)
        first_node = self.head.next

        first_node.prev = new_node
        new_node.next = first_node
        new_node.prev = self.head
        self.head.next = new_node

    def pop(self) -> int:
        if self.isEmpty(): 
            return -1
        last_node = self.tail.prev
        value = last_node.val
        prev_node = last_node.prev

        prev_node.next = self.tail
        self.tail.prev = prev_node
        return value

    def popleft(self) -> int:
        if self.isEmpty(): 
            return -1
        first_node = self.head.next
        value = first_node.val
        next_node = first_node.next
        next_node.prev = self.head
        self.head.next = next_node
        return value
