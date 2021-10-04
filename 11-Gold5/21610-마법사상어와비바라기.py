n, m = map(int, input().split())
di = [0, (-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, -1), (0, 1), (-1, 1)]

A = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    A.append(tmp)

mv = []
for _ in range(m):
    d, s = map(int, input().split())
    mv.append((di[d][0]*s, di[d][1]*s))

cur = [n-2, 0]
for i in range(m):
    # 1. 모든 구름이 di 방향으로 si칸 이동
    cur[0] = (cur[0] + mv[i][0]) % n
    cur[1] = (cur[1] + mv[i][1]) % n

    # 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양 1 증가
    A[cur[0]][cur[1]] += 1
    A[cur[0]]