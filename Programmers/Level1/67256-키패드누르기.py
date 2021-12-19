import math

def solution(numbers, hand):
    keypad = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [-1, 0, -1]]
    answer = ''
    lastL = [3, 0]
    lastR = [3, 2]
    for i in numbers:
        if i in [1, 4, 7]:
            answer += 'L'
            lastL = [(i-1)/3, 0]
        elif i in [3, 6, 9]:
            answer += 'R'
            lastR = [i/3-1, 2]
        else:
            if i == 0:
                i = 11
            curP = [(i-2)/3, 1]
            distL = abs(curP[0] - lastL[0]) + abs(curP[1] - lastL[1])
            distR = abs(curP[0] - lastR[0]) + abs(curP[1] - lastR[1])
            
            if distL > distR:
                answer += 'R'
                lastR = curP
            elif distL < distR:
                answer += 'L'
                lastL = curP
            else:
                if hand == "left":
                    answer += 'L'
                    lastL = curP
                else:
                    answer += 'R'
                    lastR = curP
    
    return answer