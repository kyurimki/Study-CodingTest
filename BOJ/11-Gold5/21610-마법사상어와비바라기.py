n, m = map(int, input().split())
di = [0, (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]

A = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    A.append(tmp)

mv = []
for _ in range(m):
    d, s = map(int, input().split())
    mv.append((di[d][0]*s, di[d][1]*s))

cloud = [[n-1, 0], [n-1, 1], [n-2, 0], [n-2, 1]]
for i in range(m):
    visited = [[False] * n for _ in range(n)]
    for c in cloud:
        # 1. 모든 구름이 di 방향으로 si칸 이동
        c[0] = (c[0] + mv[i][0]) % n
        c[1] = (c[1] + mv[i][1]) % n

        # 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양 1 증가
    for c in cloud:
        A[c[0]][c[1]] += 1
        visited[c[0]][c[1]] = True

    # 3. 구름이 모두 사라진다.
    prev = cloud
    cloud = []

    # 4. 물복사버그 마법
    dx = [-1, -1, 1, 1]
    dy = [-1, 1, -1, 1]
    for c in prev:
        cnt = 0
        for i in range(4):
            if -1 < c[0]+dx[i] < n and -1 < c[1]+dy[i] < n and A[c[0]+dx[i]][c[1]+dy[i]] > 0:
                cnt += 1
        A[c[0]][c[1]] += cnt

    # 5. 구름 생성
    for i in range(n):
        for j in range(n):
            if A[i][j] >= 2 and visited[i][j] is False:
                A[i][j] -= 2
                cloud.append([i, j])    
    
sums = 0
for i in range(n):
    for j in range(n):
        sums += A[i][j]
print(sums)