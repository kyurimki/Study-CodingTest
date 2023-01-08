function solution(numbers) {
    let answer = [];
    for(let i = 0; i < numbers.length-1; i++) {
        for(let j = i+1; j < numbers.length; j++) {
            const sum = numbers[i] + numbers[j];
            if(!answer.includes(sum)) answer.push(sum);
        }
    }
    answer.sort((x, y) => x-y);
    
    return answer;
}