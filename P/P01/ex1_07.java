public class ex1_07 {
    public static void main(String[] args) {
        Node root = null;
    }

    private static Node ExpressionTree(Node current, String r, String l) {
        if (current == null) {
            return new Node(r);
        }

        // Don't know tbh

        return current;
    }
}

class Node {
    String value;
    Node right;
    Node left;

    public Node(String value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}
