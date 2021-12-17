T = int(input())
for t in range(1, T+1):
    N = int(input())
    arr = []
    for n in range(N):
        c, l = input().split()
        for i in range(int(l)):
            arr.append(c)
    
    print("#{}".format(t))
    for i in range(len(arr)):
        print(arr[i], end='')
        if i % 10 == 9:
            print()
    print()