package core.algorithims;

public class BinaryTree {

    public  static  class  Node{
        Node head;
        Node left;
        Node right;
        Object Data;
        public Node(Node _head,Object _data){
            this.Data = _data;
            this.head = _head;
            this.right = null;
            this.left = null;
        }
    }
}
