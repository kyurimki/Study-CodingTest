def prime(m, n):
    primes = 0
    minx = 0
    for i in range(m, n+1):
        if i <= 1:
            continue
        for x in range(2, int(i**0.5)+1):
            if i % x == 0:
                break
        else:
            if primes == 0:
                minx = i
            primes += i
    return primes, minx

m = int(input())
n = int(input())
sums, minx = prime(m, n)
print(sums if sums != 0 else -1)
print(minx if minx != 0 else "")