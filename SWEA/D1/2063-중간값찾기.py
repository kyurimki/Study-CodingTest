T = int(input())

nums = sorted(list(map(int, input().split())))
size = len(nums) // 2
print(nums[size])