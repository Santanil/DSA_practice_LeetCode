//268. Missing Number

----------------------------Using XOR----------------------------------------
// TC:O(N)  SC:O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=ans^nums[i]^(i+1);   
        }
        return ans;
    }
}


---------------------------Using cyclic sort------------------------------------------------
//TC:O(N)
//SC:O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct])
                swap(nums,i,correct);
            else
                i++;
        }
        
        //find the missing number by iterating through the list
        for(i=0;i<nums.length;i++)
            if(nums[i]!=i)
                return i;
        return i;
    }
    public void swap(int[] nums,int i,int correct){
        int temp=nums[i];
        nums[i]=nums[correct];
        nums[correct]=temp;
    }
}
