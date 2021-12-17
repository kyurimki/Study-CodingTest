def prime(m, n):
    for i in range(m, n+1):
        if i <= 1:
            continue
        for x in range(2, int(i**0.5)+1):
            if i % x == 0:
                break
        else:
            print(i)

m, n = map(int, input().split())
prime(m, n)