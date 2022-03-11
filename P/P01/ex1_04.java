import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ex1_04 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> map = load("numbers.txt");
        for (String x : args) {
            if (x.matches("^[a-zA-Z]*")) {
                System.out.print(map.get(x) + "\s");
            } else {
                String[] y = x.split("-");
                for (String w : y) {
                    System.out.print(map.get(w) + "\s");
                }
            }
        }
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
}
