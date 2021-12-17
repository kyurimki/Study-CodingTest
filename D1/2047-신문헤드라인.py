T = input()

for t in T:
    if 'a' <= t <= 'z':
        print(chr(ord(t)-ord('a')+ord('A')), end="")
    else:
        print(t, end="")