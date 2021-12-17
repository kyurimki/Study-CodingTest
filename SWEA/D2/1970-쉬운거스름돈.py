T = int(input())
arr = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

for t in range(1, T+1):
    tmp = [0 for _ in range(len(arr))]
    N = int(input())
    for i in range(len(arr)):
        tmp[i] = N // arr[i]
        N -= tmp[i] * arr[i]
    print("#{}".format(t))
    print(*tmp)