def solution(sizes):
    resortedX = []
    resortedN = []
    for i in range(len(sizes)):
        resortedX.append(max(sizes[i][0], sizes[i][1]))
        resortedN.append(min(sizes[i][0], sizes[i][1]))
    
    answer = max(resortedX) * max(resortedN)
    return answer