https://leetcode.com/problems/sliding-window-maximum/description/
https://www.youtube.com/watch?v=CZQGRp93K4k&t=747s

----------------------Naive Approach--------------------
TC: O(N*K)
SC: O(1)

1st loop to generate all the substrings of sike k
  1 inner lopp of k iterations to find max among the k length string
  

----------------------Optimized Approach-----------------

TC: O(N)
SC: O(K)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> arrDq=new ArrayDeque<>();
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            
            //remove smaller elements
            int start=i-k+1;
            while(arrDq.size()>0 && arrDq.peekFirst()<start){
                arrDq.pollFirst();
            }

            while(arrDq.size()>0 && nums[arrDq.peekLast()]<nums[i]){
                arrDq.pollLast();
            }

            arrDq.offerLast(i);
            if(i>=k-1)
                res[i-k+1]=nums[arrDq.peekFirst()];
        }
        return res;    
    }
}
