https://leetcode.com/problems/intersection-of-two-arrays/



Approach 1-------------------------------------------------------------------------
// There are built-in intersection facilities, which provide O(n + m) time complexity in the average case and O(n×m) 
time complexity in the worst case (Leetcode solution)
TC:O(n*m)
SC:O(n)
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}

Approach 2-------------------------------------------------------------------------
// Add all elements of array1 in set1 , ietrate through array 2 elemnets and check if present in set 1, 
if present add in set 2. Iterate through set 2 and add in resultant int array to be returned
TC:O(n)
SC:(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> temp=new HashSet<>();
        HashSet<Integer> set=new HashSet<>();
        
        
        for(int i=0;i<nums1.length;i++)
            temp.add(nums1[i]);
        for(int i=0;i<nums2.length;i++){
            if(temp.contains(nums2[i])){
                set.add(nums2[i]);
            }
        }
        
        
        int[] res=new int[set.size()];
        int i=0;    
        for(int element: set)
            res[i++]=element;
        return res;   
    }
}

Approach 3--------------------------------------------------------------------------
//Sort the 2 arrays -> use 2 pointers to find the matching elemnts and store them in a set as same element may occur more than once in both the arrays. Finally copy the set elemnts into the resultant array to returned
