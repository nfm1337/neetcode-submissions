class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        first = self.climbStairs(n - 1)
        second = self.climbStairs(n - 2)
        return first + second