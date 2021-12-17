n = int(input())

length = len(str(n))
count = 0
for i in range(length-1):
    count += 9 * (10 ** i) * (i+1)

count += (n - (10 ** (length-1)) + 1) * length
print(count)