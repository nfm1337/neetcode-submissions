class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1
        r = max(piles)
        res = sys.maxsize
        while l <= r:
            speed = (l + r) // 2

            total_time = 0
            for pile in piles:
                total_time += math.ceil(pile / speed)

            if total_time > h:
                l = speed + 1
            else:
                r = speed - 1
                res = min(res, speed)
            
        return res
