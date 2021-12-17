arr = list(map(int, input().split()))
print(arr[0] * max(arr[1], arr[2]) // min(arr[1], arr[2]))