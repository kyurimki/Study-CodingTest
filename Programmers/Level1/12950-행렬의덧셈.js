function solution(arr1, arr2) {
    var answer = [[]];
    
    let row = arr1.length, col = arr1[0].length;
    for(let i = 0; i < row; i++) {
        answer[i] = [];
        for(let j = 0; j < col; j++) {
            answer[i].push(arr1[i][j]+arr2[i][j]);
        }
    }
    
    return answer;
}