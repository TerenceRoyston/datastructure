package junior.day04;

public class ReverseList {
    public static void main(String[] args) {

    }

    public static Node reverseList(Node node){
        return null;
    }


}

class Node{
    int value;
    Node next;
    public Node(int data){
        this.value=data;
    }
}

class DoubleNode{
    int value;
    DoubleNode last;
    DoubleNode next;
    public DoubleNode(int data){
        this.value=data;
    }
}
