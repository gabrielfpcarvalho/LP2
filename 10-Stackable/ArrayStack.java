import java.util.ArrayList;

class ArrayStack implements IStackable {
    ArrayList<Integer> l = new ArrayList<Integer>();

    public void push(int v) {
        l.add(v);
    }

    public int size() {
        return l.size();
    }

    public int pop() {
        int a = l.get(l.size()-1);
        l.remove(l.get(l.size()-1));
        return a;
    }
}