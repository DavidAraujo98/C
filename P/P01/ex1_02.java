import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ex1_02 {
    static HashMap<String, Object> map = new HashMap<String, Object>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.print("New line: ");
                String n = sc.nextLine();
                interpreter(n);

            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    private static Object interpreter(String n) {
        Object val = 0;
        int op1 = 0, op2 = 0;
        String opr = "";

        if (n.matches("^[a-zA-Z]*[+/*-]\\d*")) { // Operation type: variable <operator> integer
            String[] y = n.split("((?<=+/*-)|(?=+/*-))");
            op1 = (int) map.get(y[0]);
            op2 = Integer.parseInt(y[2]);
            opr = y[1];
            val = operate(op1, op2, opr);
        } else if (n.matches("^\\d*[+/*-][a-zA-Z]*")) { // Operation type: integer <operator> variable
            String[] y = n.split("((?<=+/*-)|(?=+/*-))");
            op1 = Integer.parseInt(y[0]);
            opr = y[1];
            op2 = (int) map.get(y[2]);
            val = operate(op1, op2, opr);
        } else if (n.matches("^[a-zA-Z]*[+/*-][a-zA-Z]*")) { // Operation type: variable <operator> variable
            String[] y = n.split("((?<=+/*-)|(?=+/*-))");
            op1 = (int) map.get(y[0]);
            opr = y[1];
            op2 = (int) map.get(y[2]);
            val = operate(op1, op2, opr);
        } else if (n.matches("^[a-zA-Z]*[=]\\w*")) { // Attribution
            System.out.println("Attribution");
            int i = n.indexOf("=");
            if (!n.matches("\\d*")) {
                // val = interpreter(n.substring(i));
            } else {
                val = Integer.parseInt(n.substring(i));
            }
            map.put(n.split("=")[0], val);
            return 0;
        } else {
            System.err.println("Invalid format");
            System.exit(0);
        }

        return val;
    }

    private static int operate(int op1, int op2, String opr) {
        int val = 0;
        switch (opr) {
            case "*":
                val = op1 * op2;
                break;
            case "/":
                val = op1 / op2;
                break;
            case "+":
                val = op1 + op2;
                break;
            case "-":
                val = op1 - op2;
        }
        return val;
    }

}
