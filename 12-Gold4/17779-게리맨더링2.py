inf = float("inf")

N = int(input())
A = []
A.append([[0] * (N+1)])
total = 0
for _ in range(N):
    tmp = list(map(int, input().split()))
    total += sum(tmp)
    A.append([0] + tmp)
    

def gerrymander(x, y, d1, d2):
    fifth = [[0] * (N+1) for _ in range(N+1)]
    fifth[x][y] = 5
    for i in range(1, d1+1):
        fifth[x+i][y-i] = 5
    for i in range(1, d2+1):
        fifth[x+i][y+i] = 5
    for i in range(1, d2+1):
        fifth[x+d1+i][y-d1+i] = 5
    for i in range(1, d1+1):
        fifth[x+d2+i][y+d2-i] = 5

    pplsum = [0] * 6
    for r in range(1, x+d1):
        for c in range(1, y+1):
            if fifth[r][c] == 5:
                break
            else:
                pplsum[1] += A[r][c]
    
    for r in range(1, x+d2+1):
        for c in range(N, y, -1):
            if fifth[r][c] == 5:
                break
            else:
                pplsum[2] += A[r][c]
    
    for r in range(x+d1, N+1):
        for c in range(1, y-d1+d2):
            if fifth[r][c] == 5:
                break
            else:
                pplsum[3] += A[r][c]
    
    for r in range(x+d2+1, N+1):
        for c in range(N, y-d1+d2-1, -1):
            if fifth[r][c] == 5:
                break
            else:
                pplsum[4] += A[r][c]
    
    pplsum[5] = total - sum(pplsum)
    return max(pplsum[1:]) - min(pplsum[1:])


result = inf
for x in range(1, N+1):
    for y in range(1, N+1):
        for d1 in range(1, N+1):
            for d2 in range(1, N+1):
                if 1 <= x < x+d1+d2 <= N and 1 <= y-d1 < y < y+d2 <= N:
                        result = min(result, gerrymander(x, y, d1, d2))
print(result)