public class Node<T> {
    private T data;
    private Node next;


    public Node(T nodeData, Node nodeNext) {
        data = nodeData;
        next = nodeNext;
    }


    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}