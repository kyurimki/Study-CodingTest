n, m, k = map(int, input().split())  # 땅의 한 변 길이, 나무 개수, 몇 년 후

A = [[0]* (n+1)] 
for i in range(n):
    tmp = list(map(int, input().split()))
    tmp.insert(0, 0)
    A.append(tmp)

trees = {}
soil = [[5]*(n+1) for _ in range(n+1)]

for _ in range(m):
    x, y, age = list(map(int, input().split()))
    if (x, y) in trees:
        trees[(x, y)].append(age)
    else:
        trees[(x, y)] = [age]

def ss():
    for i in trees:
        trees[i].sort()
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

def fw():
    tmpTrees = []
    for i in trees.keys():
        for j in trees[i]:
            if j % 5 == 0:
                dx = [-1, -1, -1, 0, 0, 1, 1, 1]
                dy = [-1, 0, 1, -1, 1, -1, 0, 1]
                for k in range(8):
                    x = i[0] + dx[k]
                    y = i[1] + dy[k]
                    if 0 < x < n+1 and 0 < y < n+1:
                        tmpTrees.append((x, y))
    
    for i in tmpTrees:
        if i in trees.keys():
            trees[i].append(1)
        else:
            trees[i] = [1]
    print(trees)

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