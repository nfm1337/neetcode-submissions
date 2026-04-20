class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        res = []
        for i in range(len(nums)):
            difference = target - nums[i]
            if difference in hashmap:
                res = [hashmap[difference], i]
                break
            else:
                hashmap[nums[i]] = i

        return res