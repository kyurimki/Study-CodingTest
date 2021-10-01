def factorial(n):
    if n > 1:
        return n*factorial(n-1)
    else:
        return 1


t = int(input())  # 테스트케이스 개수
for _ in range(t):
    n, m = map(int, input().split())
    print(factorial(m) // (factorial(n) * factorial(m-n)))