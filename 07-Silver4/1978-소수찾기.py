import math

def prime(nums):
    count = 0
    for i in nums:
        if i <= 1:
            continue
        for x in range(2, int(math.sqrt(i))+1):
            if i % x == 0:
                break
        else:
            count += 1
    return count


n = int(input())
nums = list(map(int, input().split()))
print(prime(nums))
