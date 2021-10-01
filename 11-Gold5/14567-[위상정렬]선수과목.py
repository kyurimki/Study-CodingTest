from collections import deque

n, m = map(int, input().split())  # 과목의 수, 선수 조건의 수
semester = [1] * (n+1)
graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)
for _ in range(m):
    a, b = map(int, input().split())  # a 과목이 b 과목의 선수과목
    graph[a].append(b)
    indegree[b] += 1

q = deque()
for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    prerequisites = graph[cur]

    for i in prerequisites:
        indegree[i] -= 1
        if indegree[i] == 0:
            q.append(i)
            semester[i] = semester[cur] + 1

print(*semester[1:])