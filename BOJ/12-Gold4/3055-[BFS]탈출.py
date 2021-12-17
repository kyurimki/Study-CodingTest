from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    while q:





r, c = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(r)]
dist = [[0] * c for _ in range(r)]
q = deque()

for x in range(r):
    for y in range(c):
        if board[x][c] == 'S':
            q.append((x, y))
        elif board