#include <iostream>
#include <cstring>

using namespace std;

const int MAX = 5000;

int n;
int arr[MAX];
int dp[MAX][MAX];

int palindrome(int x, int y) {
    if(x >= y) {
        return 0;
    }

    if(dp[x][y] != -1) {
        return dp[x][y];
    }

    if(arr[x] == arr[y]) {
        dp[x][y] = palindrome(x+1, y-1);
        return dp[x][y];
    } else {
        dp[x][y] = min(palindrome(x+1, y)+1, palindrome(x, y-1)+1);
        return dp[x][y];
    }
}



int main() {
    cin >> n;

    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    memset(dp, -1, sizeof(dp));

    cout << palindrome(0, n-1) << endl;
    
    return 0;
}