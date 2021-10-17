T = int(input())

for i in range(1, T+1):
    result = [0, 0, 0, 0, 0]
    t = int(input())

    while t % 2 == 0:
        result[0] += 1
        t //= 2
    while t % 3 == 0:
        result[1] += 1
        t //= 3
    while t % 5 == 0:
        result[2] += 1
        t //= 5
    while t % 7 == 0:
        result[3] += 1
        t //= 7
    while t % 11 == 0:
        result[4] += 1
        t //= 11
    
    print("#{} {} {} {} {} {}".format(i, result[0], result[1], result[2], result[3], result[4]))