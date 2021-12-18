n = int(input())
zeros = 0
ones = 0
for _ in range(n):
    x = int(input())
    if x == 0:
        zeros += 1
    else:
        ones += 1

print("Junhee is not cute!" if zeros > ones else "Junhee is cute!")