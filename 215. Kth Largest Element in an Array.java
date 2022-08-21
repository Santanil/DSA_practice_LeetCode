https://leetcode.com/problems/kth-largest-element-in-an-array/

https://www.youtube.com/watch?v=FrWq2rznPLQ

//TC:O(N)  SC:O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue();
        for(int n:nums){
            minHeap.add(n);
            if(minHeap.size()>k)
                minHeap.remove();
        }
        
        //works since at this point of time only largest k elements are present in the heap
        return minHeap.remove();
    }
}
