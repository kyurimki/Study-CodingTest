def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    length = len(completion)
    
    for i in range(length):
        if participant[i] != completion[i]:
            return participant[i]
    return participant[length]