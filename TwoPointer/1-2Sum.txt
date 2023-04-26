class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int[] ans=new int[2];            
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int diff=target-curr;
            if(hm.containsKey(diff)){
                ans[0]=i;
                ans[1]=hm.get(diff);
                return ans;
            }
            hm.put(curr,i);
        }
        return ans;
    }
}