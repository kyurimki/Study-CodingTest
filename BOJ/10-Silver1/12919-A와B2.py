def check(s, t):
    if len(s) == len(t):
        return t == s
    
    if (t[0] == 'B' and check(s, t[:0:-1])) or (t[-1] == 'A' and check(s, t[:-1])):
        return True 

s = input()
t = input()

print(1 if check(s, t) else 0)