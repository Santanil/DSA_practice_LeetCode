https://leetcode.com/problems/majority-element-ii/description/
https://www.youtube.com/watch?v=vwZj1K0e9U8&t=1572s


//BF Sol-------------->  picking up all the elements one by one and seaching the element through the list
// TC: O(N^2)
// SC: O(1)

//Better solution will be-------------> Hashing all elements with key->element, Value-> count
//TC: O(N)
//SC: O(1)

// Optimized Solution
// Moor's voting algorithm
// TC: O(2N)
// SC: O(1)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int cnt1=0,cnt2=0,ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE,n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1=1;    
            }else if(cnt2==0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2=1;
            }
            else if(ele1==nums[i])
                    cnt1++;
            else if(ele2==nums[i])
                    cnt2++;
            else{
                cnt1--;
                cnt2--;
            }   
        }
        int ele1cnt=0,ele2cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1)
                ele1cnt++;
            if(nums[i]==ele2)
                ele2cnt++;
        }
        if(ele1cnt>Math.floor(n/3) && ele1!=Integer.MIN_VALUE)
            list.add(ele1);
        if(ele2cnt>Math.floor(n/3) && ele2!=Integer.MIN_VALUE)
            list.add(ele2);

        return list;
    }
}
