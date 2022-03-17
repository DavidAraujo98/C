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

        return current;
    }
}

class Node {
    Object value;
    Node right;
    Node left;
    public Node(Object value) {
        this.value = value;
        right = null;
        left = null;
    }
}
