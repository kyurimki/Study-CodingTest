a = list(map(int, input().split()))
c = list(map(int, input().split()))

b = []
b.append(c[0] - a[2])
b.append(int(c[1] / a[1]))
b.append(c[2] - a[0])
print(*b)