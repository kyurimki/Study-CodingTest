import heapq

inf = float('inf')

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dijkstra():
    q = []
    heapq.heappush(q, (rupees[0][0], 0, 0))
    dist[0][0] = 0

    while q:
        cost, x, y = heapq.heappop(q)
        if x == n-1 and y == n-1:
            print("Problem {}: {}".format(cnt, dist[x][y]))
            break

        for i in range(4):
            cx = x + dx[i]
            cy = y + dy[i]

            if -1 < cx < n and -1 < cy < n:
                ccost = cost + rupees[cx][cy]
                if ccost < dist[cx][cy]:
                    dist[cx][cy] = ccost
                    heapq.heappush(q, (ccost, cx, cy))


cnt = 1
while True:
    n = int(input())
    if n == 0:
        break
    rupees = [list(map(int, input().split())) for _ in range(n)]
    dist = [[inf] * n for _ in range(n)]
    dijkstra()
    cnt += 1