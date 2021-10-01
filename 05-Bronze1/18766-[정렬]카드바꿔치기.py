t = int(input())
for _ in range(t):
    n = int(input())
    a = list(input().split())
    b = list(input().split())

    a.sort()
    b.sort()

    if a == b:
        print("NOT CHEATER")
    else:
        print("CHEATER")