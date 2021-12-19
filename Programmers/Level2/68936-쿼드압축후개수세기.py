def solution(arr):
    answer = [0, 0]
    size = len(arr)
    
    def compress(x, y, n):
        start = arr[x][y]
        for i in range(x, x+n):
            for j in range(y, y+n):
                if arr[i][j] != start:
                    tmp = n // 2
                    compress(x, y, tmp)
                    compress(x, y+tmp, tmp)
                    compress(x+tmp, y, tmp)
                    compress(x+tmp, y+tmp, tmp)
                    return 
        answer[start] += 1
    
    compress(0, 0, size)
        
    return answer