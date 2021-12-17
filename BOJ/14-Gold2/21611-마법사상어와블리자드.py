n, m = map(int, input().split())

info = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    info.append(tmp)

dx = [0, 0, 0, -1, 1]
dy = [0, -1, 1, 0, 0]

def blizzard(d, s):
    # 구슬 파괴
    for i in range(1, s+1):
        info[n//2+dy[d]*i][n//2+dx[d]*i] = 0
    
    # 구슬 이동


for _ in range(m):
    d, s = map(int, input().split())
    blizzard(d, s)