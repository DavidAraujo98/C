import java.util.*;

public class ex1_01 {

    public static void main(String[] args) {
        try {
            int opi = Integer.parseInt(args[0]);
            int opf = Integer.parseInt(args[2]);

            int r = 0;

            switch (args[1]) {
                case "/":
                    r = opi / opf;
                    break;
                case "*":
                    r = opi * opf;
                    break;
                case "+":
                    r = opi + opf;
                    break;
                case "-":
                    r = opi - opf;
                    break;
            }

            System.out.println(r);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
