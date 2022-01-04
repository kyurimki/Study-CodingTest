def prime(m):
    num = 0
    for i in range(m+1, 2*m+1):
        if i <= 1:
            continue
        for x in range(2, int(i**0.5)+1):
            if i % x == 0:
                break
        else:
            num += 1
    return num

while True:
    n = int(input())
    if n == 0:
        break
    print(prime(n))