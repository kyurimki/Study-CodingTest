n = int(input())
m = []

for _ in range(n):
    m.append(input())

for i in range(n):
    s = ''

    for j in range(n):
        s += m[j][i]
    
    if m[i] != s:
        print("NO")
        break
else:
    print("YES")