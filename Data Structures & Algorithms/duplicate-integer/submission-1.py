class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        mask = {}
        for num in nums:
            mask[num] = mask.get(num, 0) + 1
            if mask[num] > 1:
                return True
                
        return False