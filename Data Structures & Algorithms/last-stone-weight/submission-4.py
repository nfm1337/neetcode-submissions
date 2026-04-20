class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = [-x for x in stones]
        heapq.heapify(heap)

        while len(heap) > 1:
            x = heapq.heappop(heap)
            y = heapq.heappop(heap)
            
            if y > x:
                heapq.heappush(heap, x - y)
            
        heap.append(0)
        return abs(heap[0])