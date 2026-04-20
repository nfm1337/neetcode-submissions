class TreeNode:
    def __init__(self, key = None, val = None):
        self.key = key
        self.val = val
        self.left = None
        self.right = None

class TreeMap:
    
    def __init__(self):
        self.root = None

    def insert(self, key: int, val: int) -> None:
        new_node = TreeNode(key, val)

        if not self.root:
            self.root = new_node
            return

        curr = self.root
        while True:
            if key < curr.key:
                if not curr.left:
                    curr.left = new_node
                    return
                curr = curr.left
            elif key > curr.key:
                if not curr.right:
                    curr.right = new_node
                    return
                curr = curr.right
            else:
                curr.val = val
                return
                    
    def get(self, key: int) -> int:
        if not self.root:
            return -1
        
        curr = self.root

        while True:
            if key < curr.key:
                if not curr.left:
                    return -1
                curr = curr.left
            if key > curr.key:
                if not curr.right:
                    return -1
                curr = curr.right
            else:
                return curr.val

    def getMin(self) -> int:
        curr = self.findMin(self.root)
        return curr.val if curr else -1

    def findMin(self, node):
        while node and node.left:
            node = node.left
        return node

    def getMax(self) -> int:
        curr = self.root
        while curr and curr.right:
            curr = curr.right
        return curr.val if curr else -1

    def remove(self, key: int) -> None:
        self.root = self.remove_helper(self.root, key)
                
    def remove_helper(self, curr, key) -> TreeNode:
        if not curr:
            return None
        
        if key > curr.key:
            curr.right = self.remove_helper(curr.right, key)
        elif key < curr.key:
            curr.left = self.remove_helper(curr.left, key)
        else:
            if not curr.left:
                return curr.right
            elif not curr.right:
                return curr.left
            else:
                minNode = self.findMin(curr.right)
                curr.key = minNode.key
                curr.val = minNode.val
                curr.right = self.remove_helper(curr.right, minNode.key)
        return curr

    def getInorderKeys(self) -> List[int]:
        result = []
        self.inorder_traversal(self.root, result)
        return result
    
    def inorder_traversal(self, root, result):
        if root:
            self.inorder_traversal(root.left, result)
            result.append(root.key)
            self.inorder_traversal(root.right, result)
