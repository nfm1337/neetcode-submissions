class Solution:
    def maxArea(self, heights: List[int]) -> int:
        area = 0
        for i in range(len(heights)):
            for j in range(1, len(heights)):
                area = max((j - i) * min(heights[i], heights[j]), area)

        return area