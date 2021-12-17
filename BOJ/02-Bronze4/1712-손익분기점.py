a, b, c = map(int, input().split())
breakEvenPoint = 0

if c <= b:
    breakEvenPoint = -1;
else:
    breakEvenPoint = int(a / (c - b) + 1)

print(breakEvenPoint)