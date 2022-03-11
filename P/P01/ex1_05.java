import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ex1_05 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> map = load("numbers.txt");
        Stack<Integer> sp = new Stack<Integer>();
        for (String x : args) {
            if (!x.matches("^[a-zA-Z]*")) {
                String[] y = x.split("-");
                int comp = 0;
                for (String w : y) {
                    comp += map.get(w);
                }
                sp.push(comp);
            } else if (isPowerOfTen(map.get(x))) {
                int op = sp.pop();
                op = op * map.get(x);
                op = op + sp.pop();
            } else {
                sp.push(map.get(x));
            }
        }
        int sum = 0;
        while (sp.size() > 0)
            sum += sp.pop();
        System.out.println("Result: " + sum);
    }

    private static HashMap<String, Integer> load(String x) throws FileNotFoundException {
        File file = new File(x);
        Scanner sf = new Scanner(file);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (sf.hasNextLine()) {
            String pair = sf.nextLine();
            String key = (pair.split("-")[1]).trim();
            int value = Integer.parseInt((pair.split("-")[0]).trim());
            map.put(key, value);
        }
        sf.close();
        return map;
    }

    private static boolean isPowerOfTen(int x) {
        String y = String.valueOf(x);
        return y.matches("^1{1}0*"); // A power of ten is always one 1 followed only by zeros
    }
}
