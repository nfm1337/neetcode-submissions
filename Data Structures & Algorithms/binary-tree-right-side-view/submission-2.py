# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        queue = deque()

        if root:
            queue.append(root)

        while len(queue) > 0:
            arr = []
            for i in range(len(queue)):
                curr = queue.popleft()
                arr.append(curr)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
                
            result.append(arr[-1].val)
        return result