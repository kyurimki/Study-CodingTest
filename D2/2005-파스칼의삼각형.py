T = int(input())
for t in range(1, T+1):
    N = int(input())
    tri = []

    for i in range(N):
        tmp = []
        for j in range(i+1):
            if j == 0 or j == i:
                tmp.append(1)
            else:
                tmp.append(tri[i-1][j-1] + tri[i-1][j])
        tri.append(tmp)
    
    print("#{}".format(t))
    for i in range(len(tri)):
        print(*tri[i])