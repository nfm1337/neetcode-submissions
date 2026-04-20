class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) <= 1: return False
        parentheses = {')': '(', ']': '[', '}':'{'}
        stack = []

        for c in s:
            if c in parentheses.values():
                stack.append(c)
            else:
                if len(stack) < 1:
                    return False
                pop = stack.pop()
                if pop not in parentheses.keys() and pop != parentheses[c]:
                    return False
        if len(stack) > 0: return False
        return True