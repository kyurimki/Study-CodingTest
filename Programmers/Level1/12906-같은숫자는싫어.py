def solution(arr):
    answer = []
    
    length = len(arr)
    
    for i in range(length-1):
        if arr[i] != arr[i+1]:
            answer.append(arr[i])
    answer.append(arr[length-1])
            
    return answer