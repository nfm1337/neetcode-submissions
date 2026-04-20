# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        
        self.inorder_helper(root, result)
        return result
        
    def inorder_helper(self, root, res):
        if not root:
            return
        
        self.inorder_helper(root.left, res)
        res.append(root.val)
        self.inorder_helper(root.right, res)

