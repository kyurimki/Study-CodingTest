maxx = -1000000001
minx = 1000000001

N = int(input())
A = list(map(int, input().split()))
op = list(map(int, input().split()))  # + - * /

def solution(num, idx, add, sub, mul, div):
    global maxx, minx
    if idx == N:
        maxx = max(maxx, num)
        minx = min(minx, num)
        return
    
    if add > 0:
        solution(num+A[idx], idx+1, add-1, sub, mul, div)
    if sub > 0:
        solution(num-A[idx], idx+1, add, sub-1, mul, div)
    if mul > 0:
        solution(num*A[idx], idx+1, add, sub, mul-1, div)
    if div > 0:
        solution(int(num/A[idx]), idx+1, add, sub, mul, div-1)

solution(A[0], 1, op[0], op[1], op[2], op[3])
print(maxx)
print(minx)