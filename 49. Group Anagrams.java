//49. Group Anagrams
//https://leetcode.com/problems/group-anagrams/
//https://docs.google.com/spreadsheets/d/1Hk2dxaDNsqrDElQy5NKMWKAdYzjgWrmoFgT-vWRHkC8/edit#gid=0

//TC: O(N*k) where N is the length of the string array and K is the length of the longest string present in the array
//Note: We cannot use the freq array as the key as everytime a new array is created a new memory address will be created, so are parsing the integer array to string for storing as key
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm=new HashMap<>();
        List<String> list=new ArrayList<>();
        
        int j=0;
        while(j<strs.length){
            String e=strs[j];
            Integer[] freq=new Integer[26];
            
            //assigning all the element freq to 0 initially
            for(int z=0;z<26;z++){
                freq[z]=0;
            }
            
            //forming the freq array for each element
            for(int i=0;i<e.length();i++){
                char ch=e.charAt(i); 
                int idx=(int)(ch-'a');
                freq[idx]++;
            }
            
            //parsing the freq array to string
            StringBuilder s=new StringBuilder();
            for(int z=0;z<26;z++){
                while(freq[z]>0){
                    s.append((char)('a'+z));
                    freq[z]--;
                }
            }
            
            
            String word=s.toString();
            
            //checking if freq is present in HM in case it is present append the new element to the end of the list else create a new list with the new key
            if(!hm.containsKey(word)){
                //creating new arraylist and adding the element in case frq not present
                List<String> subList=new ArrayList<>();        
                subList.add(e);
                hm.put(word,subList);            
            }else{ 
                //adding element to the end of the list for the given element
                List<String> subList=hm.get(word);
                subList.add(e);
                hm.put(word,subList);     
            }
            j++;
        }
        
        //forming the final result
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:hm.entrySet()){
            res.add(entry.getValue());    
        }
        return res; 
    }
}
