n = int(input())
a = n * (1-0.22)
b = n * 0.8 + n * (1-0.8) * (1-0.22)
print(int(a), int(b))