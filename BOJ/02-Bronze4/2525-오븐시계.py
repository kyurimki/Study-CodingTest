a, b = map(int, input().split())
c = int(input())

x = a+(b+c)//60
y = (b+c)%60

if x > 23:
    x -= 24
    
print(x, y)