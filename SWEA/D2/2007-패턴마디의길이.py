T = int(input())
for t in range(1, T+1):
    string = input()
    for i in range(1, len(string)):
        if string[:i] == string[i:i+i]:
            print("#{} {}".format(t, len(string[:i])))
            break