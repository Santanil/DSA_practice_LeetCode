//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//https://www.youtube.com/watch?v=bU-q1OJ0KWw
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0



//O(Log N) for binary search and O(N/2) for searching left and right-> 
//TC:O(N/2)
//SC:O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0,right=0;
        int index=binarySearch(0,nums.length-1,target,nums);
        if(index==-1){
            return new int[]{-1,-1};
        }
        else{
            left=index;right=index;
            while(left-1>=0 && nums[left-1]==nums[index])
                left--;
            while(right+1<nums.length && nums[right+1]==nums[index])
                right++;
        }
        return new int[]{left,right};
    }
    public int binarySearch(int l,int r,int target,int[] arr){
        int mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
}


//Optimized code
//TC:O(log N)
//SC:O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex=binarySearchLeft(0,nums.length-1,target,nums);
        int rightIndex=binarySearchRight(0,nums.length-1,target,nums);
        return new int[]{leftIndex,rightIndex};
    }
    public int binarySearchLeft(int l,int r,int target,int[] arr){
        int index=-1,mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(arr[mid]>=target)
                r=mid-1;
            else
                l=mid+1;
            if(arr[mid]==target)
                index=mid;
        }
        return index;
    }
    public int binarySearchRight(int l,int r,int target,int[] arr){
        int index=-1,mid;
        while(l<=r){
            mid=l+(r-l)/2;
            if(arr[mid]<=target)
                l=mid+1;
            else
                r=mid-1;   
            if(arr[mid]==target)
                index=mid;
        }
        return index;
    }
}
