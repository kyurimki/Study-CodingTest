a, b, n = map(int, input().split())

a %= b
for i in range(1, n):
    a = (a*10) % b

print((a*10) // b)