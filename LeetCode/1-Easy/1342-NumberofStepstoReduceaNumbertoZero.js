/**
 * @param {number} num
 * @return {number}
 */
 var numberOfSteps = function(num) {
    let step = 0;
    while(num > 0) {
        step++;
        num % 2 === 0 ? num /= 2 : num -=1;
    }
    return step;
};