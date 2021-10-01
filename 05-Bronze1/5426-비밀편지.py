import math

n = int(input())
for _ in range(n):
    encoded = input()
    size = int(math.sqrt(len(encoded)))
    msg = []
    for i in range(size):
        tmp = []
        for j in range(size):
            tmp.append(encoded[size*i+j])
        msg.append(tmp)
    
    for i in range(size-1, -1, -1):
        for j in range(size):
            print(msg[j][i], end="")