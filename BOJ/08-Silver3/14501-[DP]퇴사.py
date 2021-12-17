N = int(input())
timetable = []
dp = [0 for _ in range(N+1)]

for i in range(1, N+1):
    T, P = map(int, input().split())
    timetable.append([T, P])

for j in range(N-1, -1, -1):
    if j + timetable[j][0] > N:
        dp[j] = dp[j+1]
    else:
        dp[j] = max(timetable[j][1] + dp[j + timetable[j][0]], dp[j+1])

print(dp[0])