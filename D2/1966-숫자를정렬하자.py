T = int(input())
for t in range(1, T+1):
    n = int(input())
    nums = sorted(list(map(int, input().split())))
    print("#{}".format(t), end=' ')
    print(*nums)