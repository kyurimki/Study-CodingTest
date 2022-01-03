start = ['m', 'o', 'o']

def moo(n, k, l):
    newL = 2 * l + k + 3
    if n <= 3:
        print(start[n-1])
        exit(0)
    
    if newL < n:
        moo(n, k+1, newL)
    else:
        if n > l and n <= l+k+3:
            if n-l == 1:
                print('m')
                exit(0)
            else:
                print('o')
                exit(0)
        else:
            moo(n-(l+k+3), 1, 3)

n = int(input())
moo(n, 1, 3)