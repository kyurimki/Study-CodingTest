from itertools import combinations

L, C = map(int, input().split())
arr = sorted(list(input().split()))

vowels = set(['a', 'e', 'i', 'o', 'u'])

combSets = list(combinations(arr, L))
for c in combSets:
    vCnt = cCnt = 0
    for x in c:
        if x in vowels:
            vCnt += 1
        else:
            cCnt += 1
    
    if vCnt > 0 and cCnt > 1:
        print("".join(c))