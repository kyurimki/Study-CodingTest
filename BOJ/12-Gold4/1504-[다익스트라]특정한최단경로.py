import heapq

inf = float("inf")

n, e = map(int, input().split())  # 정점 개수, 간선 개수

graph = [[] for _ in range(n+1)]

for _ in range(e):
    a, b, c = map(int, input().split())  # 정점 a~정점 b에 양방향 길, 거리 c
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())  # 반드시 거쳐야 하는 정점


def dijakstra(start):
    dist_list = [inf] * (n+1)
    dist_list[start] = 0
    q = []
    heapq.heappush(q, (0, start))

    while q:
        dist, cur = heapq.heappop(q)

        if dist_list[cur] < dist:
            continue

        for i in graph[cur]:
            cost = dist + i[1]

            if dist_list[i[0]] > cost:
                dist_list[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return dist_list


orig_dist = dijakstra(1)
v1_dist = dijakstra(v1)
v2_dist = dijakstra(v2)

result = min(orig_dist[v1]+v1_dist[v2]+v2_dist[n], orig_dist[v2]+v2_dist[v1]+v1_dist[n])
print(result if result < inf else -1)