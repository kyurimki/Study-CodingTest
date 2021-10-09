from collections import deque
from itertools import combinations

n, m = map(int, input().split())
status = []

dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

inf = float('inf')
result = inf

def bfs(v):
    while q:
        x, y = q.popleft()
        for i in range(4):
            cx = x + dx[i]
            cy = y + dy[i]
            if 0 <= cx < n and 0 <= cy < n and visited[cx][cy] == 0 and  status[cx][cy] != 1:
                steps[cx][cy] = steps[x][y] + 1
                visited[cx][cy] = True
                v += 1
                q.append((cx, cy))
    return v

virus = deque()
blank = 0
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(n):
        if tmp[j] == 2:
            virus.append((i, j))
        if tmp[j] != 1:
            blank += 1
    status.append(tmp)

combs = list(combinations(virus, m))
for c in combs:
    steps = [[-1] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    visitCount = 0
    q = deque()
    for x, y in c:
        steps[x][y] = 0
        visited[x][y] = True
        visitCount += 1
        q.append((x, y))

    visitCount = bfs(visitCount)

    if blank == visitCount:
        maxx = 0
        for i in range(n):
            for j in range(n):
                if status[i][j] != 1 and (i, j) not in virus:
                    maxx = max(maxx, steps[i][j])
        result = min(result, maxx)
    
print(result if result != inf else -1)