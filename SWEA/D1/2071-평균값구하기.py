T = int(input())
for test_case in range(1, T + 1):
    nums = list(map(int, input().split()))
    x = round(sum(nums) / 10)
    print("#{} {}".format(test_case, x))