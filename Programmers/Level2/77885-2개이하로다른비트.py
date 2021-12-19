def solution(numbers):
    def f(n):
        if n[-1] == '0':
            return int(n[:-1]+"1", 2)
        else:
            for i in range(len(n)-1, -1, -1):
                if n[i] == '0':
                    return int(n[:i]+"10"+n[i+2:], 2)
            else:
                return int("10"+n[1:], 2)
            
    answer = []
    for i in numbers:
        answer.append(f(bin(i)[2:]))
    
    return answer