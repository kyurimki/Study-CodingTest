T = int(input())

for t in range(1, T+1):
    nums = sorted(list(map(int, input().split())))
    sums = round((sum(nums) - nums[0] - nums[9])/8)
    print("#{} {}".format(t, sums))