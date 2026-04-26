class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        l, r = 0, 1

        while l < r and r < len(prices):
            profit = max(prices[r] - prices[l], profit)

            if prices[l] > prices[r]:
                l = r
                r += 1
            else:
                r += 1

        return profit
