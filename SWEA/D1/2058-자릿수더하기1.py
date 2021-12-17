T = int(input())

sums = 0
while T > 0:
    sums += T % 10
    T //= 10

print(sums)