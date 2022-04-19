287. Find the Duplicate Number



---------------------------Fast Slow Pointer Technique----------------------------------------
  
//TC:O(N)
//SC:O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
            
        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}


----------------------------------------Solution using cyclic sort--------------------------------------------
https://www.youtube.com/watch?v=JfinxytTYFQ&t=3008s
//TC:O(N)
//SC:O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i];
            if(nums[i]!=nums[correct])
                swap(nums,i,correct);
            else
                i++;
        }
        
        //iterating through the array and checking serially for the number that doean't match with the index value
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return nums[i];
        }
        return 0;
    }
    
    public void swap(int[] arr,int i,int correct){
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}
