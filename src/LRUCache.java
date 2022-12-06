import java.util.HashMap;
import java.util.Map;

/**
 * author jmh
 */
public class LRUCache{
    private int capacity;
    private int size;
    private LinkedNode head;
    private LinkedNode tail;
    private Map<Integer, LinkedNode> map = new HashMap<>();

    class LinkedNode{
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LinkedNode() {
        }
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        LinkedNode node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){

        LinkedNode node = map.get(key);
        if(node == null){
            LinkedNode newNode = new LinkedNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                LinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else{
            node.value =value;
            moveToHead(node);
        }
    }

    public void removeNode(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(LinkedNode node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public LinkedNode removeTail(){
        LinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }


    public void moveToHead(LinkedNode node){
        removeNode(node);
        addToHead(node);
    }
}
