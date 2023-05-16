https://leetcode.com/problems/remove-duplicates-from-sorted-array/


-----------------------------------------------------Brute Force---------------------------------------------------------
TC: O(N)
SC: O(N)
    
class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0,count=0;
        Set<Integer> set = new TreeSet();
        for(int i: nums)
            set.add(i);   /************* treeSet insertion takes O(log n)  ***************/
        Iterator<Integer> itr=set.iterator();
        while(itr.hasNext()){
            Integer x=itr.next();
            nums[j++]=x;
            count++;
        }
        return count;
    }
}

-----------------------------------------------------Optimized---------------------------------------------------------
TC: O(N)
SC: O(1)
  
class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr=1;
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=temp){
                temp=nums[i];
                nums[ptr++]=temp;
            }
        }
        return ptr;    
    }
}
