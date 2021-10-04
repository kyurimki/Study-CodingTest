import sys
sys.setrecursionlimit(10**6)

n = int(input())
arr = list(map(int, input().split()))
dp = [[-1 for _ in range(n)] for _ in range(n)]

def palindrome(x, y):
    if x >= y:
        return 0
    
    if dp[x][y] != -1:
        return dp[x][y]
    
    if arr[x] == arr[y]:
        dp[x][y] = palindrome(x+1, y-1)
        return dp[x][y]
    else:
        dp[x][y] = min(palindrome(x+1, y)+1, palindrome(x, y-1)+1)
        return dp[x][y]

print(palindrome(0, n-1))