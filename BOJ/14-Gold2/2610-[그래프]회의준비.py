n = int(input())  # 회의에 참석하는 사람의 수
m = int(input())  # acquaintants
A = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    A[a].append(b)
    A[b].append(a)

print(A)

groups = []
idx = 1
while idx < n+1:
    if len(A[idx]) == 0:
        groups.append(idx)
        visited[idx] = True
        idx += 1
        print("!", idx)
    else:
        for i in A[idx]:
            if visited[i] == False:
                visited[i] = True
                if len(A[i]) > len(A[idx]):
                    idx = i
        else:
            groups.append(idx)
            idx = visited.index(False)
            print(idx)
        print("@", idx)

print(groups)