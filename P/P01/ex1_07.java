<<<<<<< HEAD
public class ex1_07 {
    public static void main(String[] args) {
        Node root = null;
    }

    private static Node ExpressionTree(Node current, String r, String l) {
        if (current == null) {
            return new Node(r);
        }

        // Don't know tbh
=======
import java.util.Scanner;

public class ex1_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(String.join(" ", arr));
        Node root = new Node(args[0]);
        root = ExpressionTree(root, sc);
    }

    private static Node ExpressionTree(Node current, Scanner sc) {
        if(current == null){
            return new Node(sc.next());
        }

        if(sc.hasNext("[=*/+-]")){
            current.left = ExpressionTree(current.left, sc);
            current.right = ExpressionTree(current.right, sc);
        }else if(sc.hasNext("[A-Za-a_][A-Za-z0-9_]*") || sc.hasNextDouble()){
            current.left = ExpressionTree(current.left, sc);
        }
>>>>>>> c60996bf38d2013b6328af5b74e5ae80115d0aa9

        return current;
    }
}

class Node {
<<<<<<< HEAD
    String value;
    Node right;
    Node left;

    public Node(String value) {
        this.value = value;
        this.right = null;
        this.left = null;
=======
    Object value;
    Node right;
    Node left;
    public Node(Object value) {
        this.value = value;
        right = null;
        left = null;
>>>>>>> c60996bf38d2013b6328af5b74e5ae80115d0aa9
    }
}
