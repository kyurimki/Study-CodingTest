import math

n = int(input())
A = list(map(int, input().split()))
b, c = map(int, input().split())

nums = n
for i in A:
    i -= b
    
    if i > 0:
        nums += math.ceil(i/c)

print(nums)