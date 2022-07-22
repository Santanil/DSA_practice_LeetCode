https://leetcode.com/problems/next-greater-element-i/


---------------------------------------------------------Naive--------------------------------------------------------
TC:O(N^2)
SC:O(1)
  
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        int l1=nums1.length,l2=nums2.length,ans=Integer.MAX_VALUE,ind=-1;
        for(int i=0;i<l1;i++){
            boolean found=false;
            ind=-1;
            int j=0;
            while(nums2[j]!=nums1[i])
                j++;
            while(j<l2){
                if(nums2[j]>nums1[i]){
                       ind=nums2[j];
                       break;
                }
                j++;
            }
            res[i]=ind;
        }
        return res;
    }
}

--------------------------------------------------------Optimized------------------------------------------------------

TC:O(N)
SC:O(N)
  
class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>(); 
            Stack<Integer> stack = new Stack<>();
            for (int num : nums2) {
                while (!stack.isEmpty() && stack.peek() < num)
                    map.put(stack.pop(), num);
                stack.push(num);
            }   
            for (int i = 0; i < nums1.length; i++)
                nums1[i] = map.getOrDefault(nums1[i], -1);
            return nums1;
        }
    }
