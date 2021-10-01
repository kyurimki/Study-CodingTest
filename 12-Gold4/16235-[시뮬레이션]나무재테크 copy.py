from collections import deque

n, m, k = map(int, input().split())  # 땅의 한 변 길이, 나무 개수, 몇 년 후
A = [list(map(int, input().split())) for _ in range(n)]

trees = [[deque() for _ in range(n+1)] for _ in range(n+1)]
soil = [[5]*(n+1) for _ in range(n+1)]

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

for _ in range(m):
    x, y, age = list(map(int, input().split()))
    trees.append([age, x, y])

def ss():
    for i in range(1, n+1):
        for j in range(1, n+1):
            length = len(trees[i][j])
            for k in range(length):
                if soil[i][j] < trees[i][j][k]:
                    print(trees[i][j])
                    front = trees[i][j][k]
                    print(front)
                    # for l in range(k, length):
                
                else:
                    soil[i][j] -= trees[i][j][k]
                    trees[i][j][k] += 1

def fw():
    for age, x, y in list(trees):
        if age % 5 == 0:
            for i in range(8):
                nx, ny = x + dx[i], y + dy[i]

                if 0 < nx < n+1 and 0 < ny < n+1:
                    trees.appendleft([1, nx, ny])
    
    for i in range(1, n+1):
        for j in range(1, n+1):
            soil[i][j] += A[i-1][j-1]


for _ in range(k):
    ss()
    # fw()

print(trees)