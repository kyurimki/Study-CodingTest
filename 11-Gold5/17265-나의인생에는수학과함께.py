inf = float('inf')

dx = [1, 0]
dy = [0, 1]

N = int(input())
maps = [['0' for _ in range(N+1)]]
for _ in range(N):
    tmp = list(input().split())
    maps.append(['0']+tmp)

ans = 0
maxx = -inf
minx = inf
def dfs(x, y, ans, op):
    global maxx, minx
    for i in range(2):
        cx = x + dx[i]
        cy = y + dy[i]
        if 1 <= cx <= N and 1 <= cy <= N:
            if maps[cx][cy] == '+':
                dfs(cx, cy, ans, '+')
            elif maps[cx][cy] == '-':
                dfs(cx, cy, ans, '-')
            elif maps[cx][cy] == '*':
                dfs(cx, cy, ans, '*')
            else:
                backup = 0
                if op == '+':
                    backup = ans + (ord(maps[cx][cy])-ord('0'))
                elif op == '-':
                    backup = ans - (ord(maps[cx][cy])-ord('0'))
                elif op == '*':
                    backup = ans * (ord(maps[cx][cy])-ord('0'))

                if cx == N and cy == N:
                    maxx = max(maxx, backup)
                    minx = min(minx, backup)
                    return
                dfs(cx, cy, backup, maps[cx][cy])

dfs(1, 1, ord(maps[1][1])-ord('0'), maps[1][1])
print(maxx, minx)