448. Find All Numbers Disappeared in an Array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
https://www.youtube.com/watch?v=JfinxytTYFQ

Cyclic Sort
//TC:O(N)
//SC:O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]<=nums.length && nums[i]!=nums[correct])
                swap(nums,i,correct);
            else
                i++;
        }
      
        
        //find the missing number by iterating through the list
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                list.add(i+1);
        }
        return list;
    }
    public void swap(int[] nums,int i,int correct){
        int temp=nums[i];
        nums[i]=nums[correct];
        nums[correct]=temp;
    }
}
