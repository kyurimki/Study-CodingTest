t = int(input())

for _ in range(t):
    yonsei = 0
    korea = 0

    for _ in range(9):
        x, y = map(int, input().split())
        yonsei += x
        korea += y

    if yonsei == korea:
        print("Draw")
    elif yonsei > korea:
        print("Yonsei")
    else:
        print("Korea")