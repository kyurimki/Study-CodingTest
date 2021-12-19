def parse(array, command):
    i = command[0]
    j = command[1]
    k = command[2]
    
    subarray = []
    subarray = array[i-1:j]
    subarray.sort()
    
    num = subarray[k-1]
    
    return num
    

def solution(array, commands):
    answer = []
    
    size = len(commands)
    
    for i in range(size):
        answer.insert(i, parse(array, commands[i]))
        
    return answer