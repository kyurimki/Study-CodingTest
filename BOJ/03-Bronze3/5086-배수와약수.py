def check(x, y):
    if y % x == 0:
        print("factor")
    elif x % y == 0:
        print("multiple")
    else:
        print("neither")

while(True):
    x, y = map(int, input().split())
    if x == 0 and y == 0:
        break
    check(x, y)