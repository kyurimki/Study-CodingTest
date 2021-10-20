def rotate(arr):
    rotated = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            rotated[j][N-1-i] = arr[i][j]
    return rotated

T = int(input())
for t in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    x = rotate(arr)
    y = rotate(x)
    z = rotate(y)

    print("#{}".format(t))
    for i in range(N):
        print("".join(map(str, x[i])), "".join(map(str, y[i])), "".join(map(str, z[i])))