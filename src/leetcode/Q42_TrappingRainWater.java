package leetcode;

public class Q42_TrappingRainWater {

    //42. Trapping Rain Water
//    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//
//
//Example 1:
//
//
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//Example 2:
//
//Input: height = [4,2,0,3,2,5]
//Output: 9
//
//
//Constraints:
//
//n == height.length
//1 <= n <= 2 * 104
//0 <= height[i] <= 105


    //SOLUTION
    //APPROACH:- L2R and R2L iteration
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0], rightMax = height[n-1], ans = 0;
        int[] leftArr = new int[n];
        // int[] rightArr = new int[n];

        for(int i=1; i<n-1; i++){
            if(height[i] < leftMax){
                leftArr[i] = leftMax - height[i];
            }
            if(leftMax < height[i]){
                leftMax = height[i];
            }
        }

        for(int i=n-2; i>0; i--){
            if(height[i] < rightMax){
                if(rightMax - height[i] < leftArr[i]){
                    ans+= rightMax - height[i];
                } else{
                    ans+= leftArr[i];
                }
            }
            if(rightMax < height[i]){
                rightMax = height[i];
            }
        }

        return ans;
    }
}
