from collections import deque

s = int(input())
dist = [[-1] * (s+1) for _ in range(s+1)]

q = deque()
q.append((1, 0))
dist[1][0] = 0
while q:
    x, y = q.popleft()

    # 이모티콘 복사 -> 클립보드 저장
    if dist[x][x] == -1:
        dist[x][x] =  dist[x][y] + 1
        q.append((x, x))
    
    # 클립보드 붙여넣기
    if x + y <= s and dist[x+y][y] == -1:
        dist[x+y][y] = dist[x][y] + 1
        q.append((x+y, y))
    
    # 이모티콘 삭제
    if x > 1 and dist[x-1][y] == -1:
        dist[x-1][y] = dist[x][y] + 1
        q.append((x-1, y))


answer = dist[s][1]
for i in range(1, s):
    if dist[s][i] != -1:
        answer = min(answer, dist[s][i])

print(answer)