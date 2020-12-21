import java.util.ArrayList;

class List<T> {     //COMPOSITE(Definition from TB/Wikipedia)-a group of objects
                    // that are treated the same way as a single instance of the same type of object.
    private int Nodes = 0;
    private Node<T> front = null;

    public boolean isEmpty() {
        return (front == null);
    }

    public void makeEmpty() {
        front = null;
        Nodes = 0;
    }

    public int size() {
        return Nodes;
    }

    public void frontins(T element) {
        front = new Node<T>(element, front);
        Nodes++;
    }

    public T peek() {
        if (isEmpty())
            return null;

        return front.getData();
    }

    @SuppressWarnings("unchecked")
    public T removeFront() {
        T tempData;

        if (isEmpty())
            return null;

        tempData = front.getData();
        front = front.getNext();
        Nodes--;
        return tempData;
    }


    @SuppressWarnings("unchecked")
    public ArrayList<T> getArray() {

        ArrayList<T> shapeArray = new ArrayList<T>();

        Node<T> node = front;
        while (node != null) {
            shapeArray.add(node.getData());
            node = node.getNext();
        }

        return shapeArray;
    }
}