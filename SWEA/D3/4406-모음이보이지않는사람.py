T = int(input())
for t in range(1, T+1):
    string = list(input())
    for i in range(len(string)):
        if string[i] in ['a', 'e', 'i', 'o', 'u']:
            string[i] = ''
    print("#{} {}".format(t, "".join(string)))