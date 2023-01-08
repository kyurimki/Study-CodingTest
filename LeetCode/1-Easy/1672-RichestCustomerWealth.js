/**
 * @param {number[][]} accounts
 * @return {number}
 */
 var maximumWealth = function(accounts) {
    let max = 0;
    for(let i = 0; i < accounts.length; i++) {
        let tmp = 0;
        for(let j = 0; j < accounts[0].length; j++)
            tmp += accounts[i][j];
        max = max < tmp ? tmp : max;
    }
    return max;
};