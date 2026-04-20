# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def check_balance(node):
            if not node: 
                return (True, 0)
            
            left_balanced, left_height = check_balance(node.left)
            right_balanced, right_height = check_balance(node.right)

            is_balanced = (left_balanced and right_balanced and
                            abs(left_height - right_height) <= 1)
            
            height = 1 + max(left_height, right_height)

            return (is_balanced, height)

        balanced, _ = check_balance(root)

        return balanced
