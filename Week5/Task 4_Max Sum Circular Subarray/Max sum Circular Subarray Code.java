class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int maxKadane = kadane(nums);

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int minKadane = kadaneMin(nums);
        
        if (totalSum == minKadane) {
            return maxKadane;
        }
        
        return Math.max(maxKadane, totalSum - minKadane);
    }
    
    private int kadane(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    private int kadaneMin(int[] nums) {
        int minEndingHere = nums[0];
        int minSoFar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        
        return minSoFar;
    }
}
