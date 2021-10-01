n = int(input())  # 일의 개수

arr = []
for _ in range(n):
    t_i, s_i = map(int, input().split())  # 소요 시간, 종료 시간
    arr.append((t_i, s_i))

arr.sort(key=lambda t:t[1], reverse=True)

start = arr[0][1] - arr[0][0]
for i in range(1, n):
    if start < arr[i][1]:
        start = start - arr[i][0]
    else:
        start = arr[i][1] - arr[i][0]

if start < 0:
    print(-1)
else:
    print(start)