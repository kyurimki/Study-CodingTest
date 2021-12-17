n = int(input())
c = s = 100

for i in range(n):
    x, y = map(int, input().split())
    
    if x > y:
        s -= x
    elif x < y:
        c -= y

print(c)
print(s)