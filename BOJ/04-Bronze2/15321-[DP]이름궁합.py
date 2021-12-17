from collections import deque
cnts = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]

A = list(input())
B = list(input())

nameset = deque()
for i in range(len(A)):
    nameset.append(cnts[ord(A[i])-ord('A')])
    nameset.append(cnts[ord(B[i])-ord('A')])

cnt = 0
while cnt < 3:
    cnt += 1
    size = len(nameset)
    print(size)
    for _ in range(size-1):
        print(nameset)
        x = nameset.popleft()
        y = nameset[0]
        nameset.append(x+y)
        print(nameset)
    if len(nameset) == 2:
        break
print(nameset)
