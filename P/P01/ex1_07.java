import java.util.Arrays;

public class ex1_07 {
    public static void main(String[] args) {
        Node root = new Node(args[0]);
        String[] rem = Arrays.copyOfRange(args, 1, args.length - 1);
        root = ExpressionTree(root, rem);
    }

    private static Node ExpressionTree(Node current, String[] src) {
        

        return current;
    }
}

class Node<T> {
    T value;
    Node<T> right;
    Node<T> left;
    public Node(T value) {
        this.value = value;
    }
}
