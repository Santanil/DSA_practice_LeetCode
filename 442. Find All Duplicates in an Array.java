442. Find All Duplicates in an Array
https://www.youtube.com/watch?v=JfinxytTYFQ&t=3008s

-----------------------Cycic Sort----------------------------------

//TC:O(N)
//SC:O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>(); 
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]<=nums.length && nums[i]!=nums[correct])
                swap(nums,i,correct);
            else
                i++;
        }
        
        //iterating through the array and checking serially for the number that doean't match with the index value
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                list.add(nums[i]);
        }
        return list;
    }
    
    public void swap(int[] arr,int i,int correct){
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}
