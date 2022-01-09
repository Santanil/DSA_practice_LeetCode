//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/
//https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5

//BF  TC:O(m+n)   SC: O(m+n)
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int arr[]=new int[m+n];
//         int i=0,j=0,k=0;
//         if(n!=0){
//             while(i<m || j<n){
//                 if(j>=n){
//                     arr[k]=nums1[i];
//                     i++;
//                     k++;
//                 }else if(i>=m){
//                     arr[k]=nums2[j];
//                     j++;
//                     k++;
//                 }else if(nums1[i]>nums2[j]){
//                     arr[k]=nums2[j];
//                     j++;
//                     k++;
//                 }else{
//                     arr[k]=nums1[i];
//                     i++;
//                     k++;
//                 }
//             }
//             for(i=0;i<m+n;i++)
//                 nums1[i]=arr[i];
//         }
//     }
// }


//  TC: O( m*nlogn + n) SC: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        if(n!=0){
            while(i<m || j<n){
                if(i>=m){
                    nums1[i]=nums2[j];
                    i++;
                    j++;
                    k++;
                }else if(nums1[i]<=nums2[j]){
                    i++;
                    k++;
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
