for i in range(int(input())):
    initCount = [0] * 8  # TTT, TTH, THT, THH, HTT, HTH, HHT, HHH

    t = input()
    for j in range(38):
        if t[j]+t[j+1]+t[j+2] == 'TTT':
            initCount[0] += 1
        elif t[j]+t[j+1]+t[j+2] == 'TTH':
            initCount[1] += 1
        elif t[j]+t[j+1]+t[j+2] == 'THT':
            initCount[2] += 1
        elif t[j]+t[j+1]+t[j+2] == 'THH':
            initCount[3] += 1
        elif t[j]+t[j+1]+t[j+2] == 'HTT':
            initCount[4] += 1
        elif t[j]+t[j+1]+t[j+2] == 'HTH':
            initCount[5] += 1
        elif t[j]+t[j+1]+t[j+2] == 'HHT':
            initCount[6] += 1
        else:
            initCount[7] += 1
  
    print(*initCount)