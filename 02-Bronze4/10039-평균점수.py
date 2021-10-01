sum = 0
for _ in range(5):
    x = int(input())
    if x < 40:
        sum += 40
    else:
        sum += x
print(sum // 5)