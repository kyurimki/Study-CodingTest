import math

D, H, W = map(int, input().split())

R = D / math.sqrt(H**2+W**2)
W = int(W*R)
H = int(H*R)
print(H, W)