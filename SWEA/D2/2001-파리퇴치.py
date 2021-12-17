T = int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    arr = []
    for _ in range(N):
        tmp = list(map(int, input().split()))
        arr.append(tmp)

    maxSum = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            s = 0
            for k in range(M):
                for l in range(M):
                    s += arr[i+k][j+l]

            if s > maxSum:
                maxSum = s
    
    print("#{} {}".format(t, maxSum))
