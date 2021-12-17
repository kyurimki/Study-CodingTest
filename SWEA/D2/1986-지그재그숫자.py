T = int(input())

for t in range(1, T+1):
    x = int(input())
    result = (x//2)*(-1)
    if x % 2 == 0:
        print("#{} {}".format(t, result))
    else:
        print("#{} {}".format(t, result+x))