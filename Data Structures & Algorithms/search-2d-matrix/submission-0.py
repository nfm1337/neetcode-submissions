class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        L, R = 0, len(matrix) - 1
        while L <= R:
            M = (L + R) // 2
            curArr = matrix[M]
            if target > curArr[len(curArr) - 1]:
                L = M + 1
            elif target < curArr[0]:
                R = M - 1
            else:
                return self.binary_search(curArr, target) > -1

        return False

    def binary_search(self, arr, target) -> int:
        L, R = 0, len(arr) - 1
            
        while L <= R:
            M = (L + R) // 2
            if target > arr[M]:
                L = M + 1
            elif target < arr[M]:
                R = M - 1
            else:
                return M
        return -1
