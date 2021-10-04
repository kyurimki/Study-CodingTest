n, m, k = map(int, input().split())  # 땅의 한 변 길이, 나무 개수, 몇 년 후
A = [list(map(int, input().split())) for _ in range(n)]

trees = {}
soil = [[5]*(n+1) for _ in range(n+1)]

for _ in range(m):
    x, y, age = list(map(int, input().split()))
    if (x, y) in trees:
        trees[(x, y)].append(age)
    else:
        trees[(x, y)] = [age]

for i in trees:
    trees[i].sort()

def ss():
    for i in trees:
        for j in range(len(trees[i])):
            if soil[i[0]][i[1]] >= trees[i][j]:
                soil[i[0]][i[1]] -= trees[i][j]
                trees[i][j] += 1
            else:
                dead = trees[i][j:]
                for k in dead:
                    soil[i[0]][i[1]] += k // 2
                trees[i] = trees[i][:j]
                break

def fw(tmpTrees):
    for i in tmpTrees:
        for j in trees[i]:
            if j:
                num = 0
                if j % 5 == 0:
                    num += 1
            if num:
                dx = [-1, -1, -1, 0, 0, 1, 1, 1]
                dy = [-1, 0, 1, -1, 1, -1, 0, 1]
                for k in range(8):
                    x = i[0] + dx[k]
                    y = i[1] + dy[k]
                    if 0 < x < n+1 and 0 < y < n+1:
                        if (x, y) in trees.keys():
                            trees[(x, y)].insert(0, 1)
                        else:
                            trees[(x, y)] = [1]


    for i in range(1, n+1):
        for j in range(1, n+1):
            soil[i][j] += A[i-1][j-1]

for _ in range(k):
    ss()
    fw(list(trees))

cnt = 0
for i in trees.keys():
    if len(trees[i]) > 0:
        cnt += len(trees[i])
print(cnt)