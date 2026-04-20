class MinStack:

    def __init__(self):
        self.arr = []
        self.pref = []

    def push(self, val: int) -> None:
        self.arr.append(val)
        if self.pref:
            self.pref.append(min(self.pref[-1], val))
        else:
            self.pref.append(val)

    def pop(self) -> None:
        self.arr.pop()
        self.pref.pop()

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return self.pref[-1]
