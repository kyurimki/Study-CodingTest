T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    nums = list(map(int, input().split()))
    odds = [n for n in nums if n % 2 == 1]
    print("#{} {}".format(test_case, sum(odds)))