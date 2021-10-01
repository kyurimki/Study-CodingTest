from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

c, r = map(int, input().split())
arr = []
for _ in range(c):
    tmp = list(map(int, input().split()))
    arr.append(tmp)

q = deque()

cheeses = 0
for i in range(c):
    for j in range(r):
        if arr[i][j] == 1:
            cheeses += 1

def bfs(cheeses):
    while q:
        start = q.popleft()
        for i in range(4):
            x = start[0] + dx[i]
            y = start[1] + dy[i]
            if 0 <= x < c and 0 <= y < r and visited[x][y] == False:
                visited[x][y] = True
                if arr[x][y] == 0:
                    q.append((x, y))
                else:
                    arr[x][y] = 0
                    cheeses -= 1
    return cheeses

count = 0
last = cheeses
while cheeses != 0:
    visited = [[False for _ in range(r)] for _ in range(c)]
    q.append((0, 0))
    visited[0][0] = True

    cheeses = bfs(cheeses)
    count += 1
    if cheeses != 0:
        last = cheeses

print(count)
print(last)