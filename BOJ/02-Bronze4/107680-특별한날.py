m = int(input())
d = int(input())

if m == 1:
    print("Before")
elif m > 2:
    print("After")
else:
    if d > 18:
        print("After")
    elif d < 18:
        print("Before")
    else:
        print("Special")