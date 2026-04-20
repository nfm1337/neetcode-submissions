class Solution:
    def findMin(self, nums: List[int]) -> int:
        minimal = nums[0]
        l, r = 0, len(nums) - 1

        while l <= r:
            mid = (l + r) // 2

            if nums[mid] > minimal:
                l = mid + 1
            elif nums[mid] < minimal:
                minimal = min(minimal, nums[mid])
                r = mid - 1
            else:
                l = mid + 1

        return minimal