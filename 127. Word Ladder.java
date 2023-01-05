https://leetcode.com/problems/word-ladder/description/
https://www.youtube.com/watch?v=tRPda0rcf8E&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=29

class Pair{
    String str;
    int step;
    Pair(String str,int step){
        this.str=str;
        this.step=step;
    }
}

class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        //add words to set
        for(String s:wordList)
            set.add(s);
            
        q.add(new Pair(startWord,1));
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            String wrd=p.str;
            int d=p.step;
            int len=wrd.length();
            
            if(wrd.equals(targetWord)==true)
                return d;
            
            for(int i=0;i<len;i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray=wrd.toCharArray();
                    charArray[i]=ch;
                    String newWord=new String(charArray);
                    
                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,d+1));
                    }
                }
            }
            
        }
        return 0;    
    }
}
