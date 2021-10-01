wordSet = ['', '', '', 'ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

txt = input()
answer = 0
for i in range(len(txt)):
    for j in wordSet:
        if txt[i] in j:
            answer += wordSet.index(j)
print(answer)