/**
 * @param {string} s
 * @return {number}
 */
 var romanToInt = function(s) {
    const numSet = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    };
    
    let answer = 0;
    for(let i = 0; i < s.length; i++) {
        let cur = numSet[s[i]];
        let next = numSet[s[i+1]];
        
        if(cur < next) {
            answer += (next - cur);
            i++;
        } else {
            answer += cur;
        }
    }
    return answer;
};