def split_group(mid):
    splited = 0
    tmp = 0
    
    for idx in range(n):
        tmp += scores[idx]
        if tmp >= mid:
            splited += 1
            tmp = 0
    return splited


n, k = map(int, input().split())
scores = list(map(int, input().split()))

left = 0
right = sum(scores) + 1

while left+1 < right:
    mid = (left+right) // 2
    splited = split_group(mid)
    if splited >= k:
        left = mid
    else:
        right = mid
print(left)