n = int(input())

coins = [7, 5, 2, 1]
dp = [n] * (n+1)

for i in range(1, n+1):
    for c in coins:
        if c < i and dp[i-c]+dp[c] < dp[i]:
            dp[i] = dp[i-c]+dp[c]
        elif c == i:
            dp[i] = 1

print(dp[-1])