
class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None

class LinkedList:
    def __init__(self):
        self.head: ListNode | None = None
        self.tail: ListNode | None = None
        self.size = 0
    
    def get(self, index: int) -> int:
        if index >= self.size: return -1
        cur = self.head
        for _ in range(index):
            cur = cur.next
        return cur.val

    def insertHead(self, val: int) -> None:
        new_node = ListNode(val)
        if self.head is None:
            self.head = self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.size += 1
        
    def insertTail(self, val: int) -> None:
        if self.head is None:
            self.insertHead(val)
        else:
            node = ListNode(val)
            self.tail.next = self.tail = node            
            self.size += 1
        
    def remove(self, index: int) -> bool:
        if index >= self.size: return False
        if index == 0:
            self.head = self.head.next if self.head else None
            if self.head is None:
                self.tail = None
            self.size -= 1
            return True
        
        prev = self.head
        for _ in range(index - 1):
            prev = prev.next
        
        to_delete = prev.next
        prev.next = to_delete.next if to_delete else None
        if to_delete is self.tail:
            self.tail = prev
        
        self.size -= 1
        return True

    def getValues(self) -> List[int]:
        cur = self.head
        res = list()
        while cur is not None:
            res.append(cur.val)
            cur = cur.next
        return res