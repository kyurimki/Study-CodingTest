from itertools import combinations

def chick_dist(p0, p1):
    return abs(p0[0]-p1[0]) + abs(p0[1]-p1[1])

HOUSE = 1
STORE = 2

n, m = map(int, input().split())

plan = [list(map(int, input().split())) for _ in range(n)]

store = []
house = []
for i in range(n):
    for j in range(n):
        if plan[i][j] == HOUSE:
            house.append((i, j))
        if plan[i][j] == STORE:
            store.append((i, j))

min_city_dist = float('inf')
comb = list(combinations(store, m))
for c in comb:
    dist = 0
    for h in house:
        min_dist = min([chick_dist(p, h) for p in c])
        dist += min_dist
    if min_city_dist > dist:
        min_city_dist = dist

print(min_city_dist)