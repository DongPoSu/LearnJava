package learn.generic;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            this.item = null;
            this.next = null;
        }
        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;

        }
        public boolean end(){
            return this.item ==null && this.next == null;
        }
    }
    private Node<T> top = new Node<T>();
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top =  top.next;
        }
        return result;
    }
    public void push(T item){
        top = new Node<T>(item, top);

    }

    public static void main(String[] args) {
        new Node<>();
    }
}
