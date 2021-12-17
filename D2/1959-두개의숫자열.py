T = int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    if N > M:
        sums = [0 for _ in range(N-M+1)]
        for i in range(N-M+1):
            for j in range(M):
                sums[i] += A[i+j] * B[j]
    else:
        sums = [0 for _ in range(M-N+1)]
        for i in range(M-N+1):
            for j in range(N):
                sums[i] += A[j] * B[i+j]
    print("#{} {}".format(t, max(sums)))