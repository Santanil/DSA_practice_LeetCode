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
        int l=0,r=1,n=nums.length;
        if(n==1)
            return 1;
        while(r<n){
            if(nums[l]!=nums[r])
                nums[++l]=nums[r];
            r++;
        }
        return ++l;
    }
}
