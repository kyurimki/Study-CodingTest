/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
 var getLucky = function(s, k) {
    var num = convert(s);
     
    for(let cnt = 1; cnt <= k; cnt++)
        num = trans(num);
    
    return num;
};

function convert(s) {
    let charA = 'a'.charCodeAt(0);
    let num = "";

    for(let i = 0; i < s.length; i++)
        num += (s[i].charCodeAt(0) - charA + 1).toString();
        
    return num;
}

function trans(num) {
    let sum = 0;
    
    for(let i = 0; i < num.length; i++)
        sum += parseInt(num[i]);
    
    return sum.toString();
}