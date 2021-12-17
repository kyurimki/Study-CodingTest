n, w, h, l = map(int, input().split())
x = (w//l) * (h//l)
print(x if x < n else n)