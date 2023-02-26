//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/
//https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5

*****************************************BF  TC:O(m+n)   SC: O(m+n)****************************************
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,c=0;
        int[] res=new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<nums2[j])
                res[c++]=nums1[i++];
            else
                res[c++]=nums2[j++];
        }
        while(i<m)
            res[c++]=nums1[i++];
        while(j<n)
            res[c++]=nums2[j++];  
        for(i=0;i<m+n;i++)
            nums1[i]=res[i];
    }
}

*****************************************Space Optimized  (No extra space)****************************************
  TC: O( m*nlogn + n) SC: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        if(n!=0){
            while(i<m || j<n){
                if(i>=m){   //when all elements of nums1 are traversed and already have nums2 sorted
                    nums1[i]=nums2[j];
                    i++;
                    j++;
                }else if(nums1[i]<=nums2[j]){
                    i++;
                }else{
                    int temp=nums1[i];
                    nums1[i]=nums2[j];
                    nums2[j]=temp;
                    i++;
                    Arrays.sort(nums2);
                }
            }
        }
    }
}
