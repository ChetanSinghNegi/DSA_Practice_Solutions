class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childSatisfied = 0;
        int greedItr = 0;
        int satisfyItr = 0;
        while(greedItr < g.length && satisfyItr < s.length){
            if(g[greedItr] <= s[satisfyItr]){
                childSatisfied++;
                greedItr++;
                satisfyItr++;
            }else{
                satisfyItr++;
            }
        }
        return childSatisfied;
    }
}