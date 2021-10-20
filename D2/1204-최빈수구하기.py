T = int(input())
for _ in range(T):
    t = int(input())
    nums = list(map(int, input().split()))
    cnts = [0] * 101

    for num in nums:
        cnts[num] += 1
    
    maxIdx = 0
    for i in range(1, len(cnts)):
        if cnts[i] >= cnts[maxIdx]:
            maxIdx = i
    
    print("#{} {}".format(t, maxIdx))