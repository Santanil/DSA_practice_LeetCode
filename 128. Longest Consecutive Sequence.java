https://leetcode.com/problems/longest-consecutive-sequence/

// I have a doubt. Let's take a test case: [3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
// While loop won't execute for 3 & 2 since 1 is present. But while loop will be executed for 1 since 0 is not present, and that will be executed (n-2) times here. 
// I think instead of iterating over nums which consists repeated elements, we can iterate over hashset then for 1 it will execute while loop only once resulting time complexity O(n) + O(n)

TC: O(N)
SC: O(N)

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet();
        int res=0,c=1;
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
        
        for(Integer x: set){
             if(!set.contains(x-1)){
                c=0;
                int e=x;
                while(set.contains(e++))
                    c++;
            }
            res=(c>res)?c:res;
        }
        return res;
    }
}
