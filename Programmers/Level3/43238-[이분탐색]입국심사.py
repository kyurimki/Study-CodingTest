def solution(n, times):
    answer = 0
    
    left, right = 1, n * max(times)
    while left <= right:
        mid = (left+right) // 2
        
        avail = 0
        for time in times:
            avail += mid // time    
            if avail >= n:
                break
        
        if avail >= n:
            answer = mid
            right = mid -1
        else:
            left = mid + 1
            
    return answer