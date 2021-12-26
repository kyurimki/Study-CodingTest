from copy import deepcopy
from collections import deque

n, m = map(int,input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

empty = 0
wall = 1
virus = 2

empty_list = []
virus_list = []
board = []

for i in range(n):
    tmp = list(map(int, input().split()))

    for j in range(m):
        if tmp[j] == empty:
            empty_list.append((i, j))
        if tmp[j] == virus:
            virus_list.append((i, j))
    board.append(tmp)

'''
1. 벽 세우는 함수
2. 퍼트리는 함수
3. 개수 세는 함수
'''

virus_result = []

def count(board):
    cnt = 0
    for i in range(n):
        cnt += board[i].count(empty)
    virus_result.append(cnt)

def bfs(board):
    q = deque()
    visited = [[False]*m for _ in range(n)]

    for v in virus_list:
        q.append(v)
    
    while q:
        y, x = q.popleft()

        for i in range(4):
            cy = y + dy[i]
            cx = x + dx[i]

            if -1 < cx < m and -1 < cy < n and board[cy][cx] == empty and visited[cy][cx] == False:
                q.append((cy, cx))
                board[cy][cx] = virus
                visited[cy][cx] = True
    count(board)


def make_wall():
    length = len(empty_list)
    for i in range(2, length):
        for j in range(1, i):
            for k in range(j):
                y1, x1 = empty_list[i]
                y2, x2 = empty_list[j]
                y3, x3 = empty_list[k]

                board[y1][x1] = wall
                board[y2][x2] = wall
                board[y3][x3] = wall

                copied = deepcopy(board)
                bfs(copied)

                board[y1][x1] = empty
                board[y2][x2] = empty
                board[y3][x3] = empty

make_wall()
print(max(virus_result))