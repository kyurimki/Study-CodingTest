def binarysearch(find, A, left, right):
    if left > right:
        return 0
    mid = (left+right) // 2
    if find == A[mid]:
        return 1
    elif find < A[mid]:
        return binarysearch(find, A, left, mid-1)
    else:
        return binarysearch(find, A, mid+1, right)

N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
toFind = list(map(int, input().split()))

for f in toFind:
    left = 0
    right = len(A)-1
    print(binarysearch(f, A, left, right))