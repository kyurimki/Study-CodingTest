T = int(input())

for x in range(1, T+1):
    check = [False for _ in range(10)]
    N = int(input())
    i = 0
    while check.count(False) > 0:
        i += 1
        splited = list(str(i * N))
        for s in splited:
            check[int(s)] = True
            
    print("#{} {}".format(x, i*N))