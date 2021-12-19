from collections import deque

def dijkstra(dist, paths):
    q = deque()
    q.append(1)
    
    while q:
        cur = q.popleft()
        for nxt, d in paths[cur]:
            if dist[nxt] > dist[cur] + d:
                dist[nxt] = dist[cur] + d
                q.append(nxt)
    return dist
    

def solution(N, road, K):
    inf = float('inf')
    dist = [inf] * (N+1)
    dist[1] = 0
    paths = [[] for _ in range(N+1)]
    
    for v1, v2, d in road:
        paths[v1].append((v2, d))
        paths[v2].append((v1, d))
    
    return len([x for x in dijkstra(dist, paths) if x <= K])