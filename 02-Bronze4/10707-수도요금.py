A = int(input())
B = int(input())
C = int(input())
D = int(input())
P = int(input())

x = A * P

y = B
if P > C:
    y += (P-C) * D

print(min(x, y))