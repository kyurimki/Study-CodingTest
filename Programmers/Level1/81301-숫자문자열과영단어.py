def solution(s):
    answer = ""
    numSet = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    tmp = ""
    for x in s:
        if '0' <= x and x <= '9':
            answer += x
        else:
            tmp += x
            if tmp in numSet:
                answer += str(numSet.index(tmp))
                tmp = ""
    
    return int(answer)