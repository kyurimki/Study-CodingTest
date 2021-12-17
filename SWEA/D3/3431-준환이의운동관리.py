T = int(input())
for t in range(1, T+1):
    L, U, X = map(int, input().split())
    print("#{}".format(t), end=" ")
    if X < L:
        print(L-X)
    elif L <= X <= U:
        print(0)
    else:
        print(-1)