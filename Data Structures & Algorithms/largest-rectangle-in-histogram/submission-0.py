class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        max_s = 0
        for i in range(len(heights)):
            cur_height = heights[i]
            l, r = i, i
            while l > 0 and heights[l - 1] >= cur_height:
                l -= 1

            while r + 1 < len(heights) and heights[r + 1] >= cur_height:
                r += 1
            
            max_s = max(max_s, (r - l + 1) * cur_height)
                
        return max_s