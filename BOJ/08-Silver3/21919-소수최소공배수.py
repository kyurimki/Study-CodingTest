def prime(nums):
    primeSets = []
    for i in nums:
        if i <= 1:
            continue
        for x in range(2, int(i**0.5)+1):
            if i % x == 0:
                break
        else:
            primeSets.append(i)
    
    primeSets = set(primeSets)
    muls = 1
    for x in primeSets:
        muls *= x
    return muls

n = int(input())
nums = list(map(int, input().split()))
result = prime(nums)
print(result if result != 1 else -1)