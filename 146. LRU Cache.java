https://leetcode.com/problems/lru-cache/description/
https://www.youtube.com/watch?v=xDEuM5qa0zg&t=370s

TC: O(1) [Average]
SC: O(N)


class LRUCache {

    int cap;
    Node head;
    Node tail;
    HashMap<Integer,Node> hm;

    class Node{
        int key;
        int value;
        Node prev, next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private void remove(Node node){
        hm.remove(node.key);
        
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void insert(Node node){
        hm.put(node.key,node);
        node.next=head.next;
        node.prev=head;
        head.next=node;
        node.next.prev=node;
    }

    public LRUCache(int capacity) {
        cap=capacity;
        hm=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node res=hm.get(key);
            remove(res);
            insert(res);
            return res.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key))
            remove(hm.get(key));
        if(hm.size()==cap)
            remove(tail.prev);
        insert(new Node(key,value));    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
