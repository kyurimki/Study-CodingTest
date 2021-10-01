n, m, k = map(int, input().split())  # 땅의 한 변 길이, 나무 개수, 몇 년 후
A = [list(map(int, input().split())) for _ in range(n)]

trees = [[[] for _ in range(n+1)] for _ in range(n+1)]
soil = [[5]*(n+1) for _ in range(n+1)]

for _ in range(m):
    x, y, age = list(map(int, input().split()))
    trees[x][y].append(age)

def ss():
    for i in range(1, n+1):
        for j in range(1, n+1):
            trees[i][j].sort()
            for k in trees[i][j]:
                if soil[i][j]>= trees[i][j][k]:
                    soil[i][j] -= trees[i][j][k]
                    trees[i][j][k] += 1
                else:
                    dead = trees[i][j][k:]
                    for l in dead:
                        soil[i][j] += l // 2
                    trees[i][j] = trees[i][j][:k]
                    break

def fw():
    for i in tmp:
        for j in trees[i]:
            if len(trees[i]) > 0 and j % 5 == 0:
                dx = [-1, -1, -1, 0, 0, 1, 1, 1]
                dy = [-1, 0, 1, -1, 1, -1, 0, 1]
                for k in range(8):
                    x = i[0] + dx[k]
                    y = i[1] + dy[k]
                    if 0 < x < n+1 and 0 < y < n+1:
                        trees[x][y].append(1)    

    for i in range(1, n+1):
        for j in range(1, n+1):
            soil[i][j] += A[i][j]

for _ in range(k):
    ss()
    fw()

cnt = 0
for i in trees.keys():
    if len(trees[i]) > 0:
        cnt += len(trees[i])
print(cnt)