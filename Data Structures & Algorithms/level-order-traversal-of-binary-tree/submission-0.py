# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []

        queue = deque()
        if root:
            queue.append(root)

        level = 0
        while len(queue) > 0:
            arr = []
            for i in range(len(queue)):
                pop = queue.popleft()
                arr.append(pop.val)
                if pop.left:
                    queue.append(pop.left)
                if pop.right:
                    queue.append(pop.right)
                level += 1
            result.append(arr)
        
        return result