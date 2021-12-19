def solution(new_id):
    new_id = new_id.lower()
    avail = "abcdefghijklmnopqrstuvwxyz0123456789-_."
    new_id = list(new_id)
    size = len(new_id)
    for i in range(size):
        if new_id[i] not in avail:
            new_id[i] = ""
            
    for i in range(size-1):
        if new_id[i] == "." and new_id[i+1] == ".":
            new_id[i] = ""
    
    new_id_str = "".join(new_id)
    size = len(new_id_str)
    print(new_id_str)
    
    while(True):
        size = len(new_id_str)
        if new_id_str[0] == ".":
            new_id_str = new_id_str[1:size]
        else:
            break
        if new_id_str[size-1] == ".":
            new_id_str = new_id_str[0:size-1]
        else:
            break
    
    print(new_id_str)
    answer = ''
    return answer