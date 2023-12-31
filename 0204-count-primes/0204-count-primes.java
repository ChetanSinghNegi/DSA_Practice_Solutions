class Solution {
    public int countPrimes(int n) {
        boolean[] dp = new boolean[n+1];
        if(n == 0){
            return 0;
        }else if(n == 1 || n == 2) return 0;
        
        Arrays.fill(dp,true);
        int divisor = 2;
        for(int i = 2; i * i <= n; i++ ){
            if(dp[i] == true){
                for(int j = i * i; j <= n; j+=i){
                    dp[j] = false;
                }
            }
        }
        int counter = 0;
        for(int i= 2; i<n;i++){
            if(dp[i] == true){
                counter++;
            }
        }
        return counter;
    }
}