original = [1, 1, 2, 2, 2, 8]
inputArr = list(map(int, input().split()))

for i in range(6):
    print(original[i]-inputArr[i], end=" ")