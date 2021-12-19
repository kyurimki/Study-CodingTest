def solution(numbers):
    numSet = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    for i in numbers:
        if i in numSet:
            numSet.remove(i)
    
    answer = 0
    for j in numSet:
        answer += j
    return answer