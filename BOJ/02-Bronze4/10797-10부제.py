day = int(input())
arr = list(map(int, input().split()))

cnt = 0
for i in range(5):
    if arr[i] % 10 == day:
        cnt += 1
    
print(cnt)