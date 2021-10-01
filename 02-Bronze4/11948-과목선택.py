arr1 = [int(input()) for _ in range(4)]
arr2 = [int(input()) for _ in range(2)]
arr1.sort()
arr2.sort()
print(arr1[1]+arr1[2]+arr1[3]+arr2[1])