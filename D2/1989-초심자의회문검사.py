def palindrome(string):
    size = len(string)
    for i in range(size//2):
        if string[i] != string[size-1-i]:
            return False
    
    return True

T = int(input())

for t in range(1, T+1):
    string = list(input())
    status = palindrome(string)
    print("#{} {}".format(t, int(status)))