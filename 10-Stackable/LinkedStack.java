import java.util.LinkedList;

class LinkedStack implements IStackable {
    LinkedList<Integer> l = new LinkedList<Integer>();

    public void push (int v) {
        l.addFirst(v);
    }

    public int size () {
        return l.size();
    }

    public int pop () {
        int a = l.getFirst();
        l.removeFirst();
        return a;
    }
}
