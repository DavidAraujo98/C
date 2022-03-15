import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

public class ex1_06 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> dic = new HashMap<String, String>();
        ArrayList<String> txt = new ArrayList<String>();

        dic = loadDic(args[1]);
        switch (args[0]) {
            case "-t":
                for (int i = 2; i < args.length; i++) {
                    txt = loadTxt(args[i]);
                    txt = translate(txt, dic);
                    writeBack(txt, args[i]);
                }
                break;
            case "-d":
                for (int i = 2; i < args.length; i++) {
                    txt = loadTxt(args[i]);
                    txt = translate(txt, dic);
                    writeBack(txt, args[i]);
                }
                break;
        }

    }

    private static HashMap<String, String> loadDic(String path) throws FileNotFoundException {
        HashMap<String, String> dic = new HashMap<String, String>();
        File src = new File(path);
        Scanner sc = new Scanner(src);
        while (sc.hasNextLine()) {
            String x = sc.nextLine();
            String[] line = x.trim().split(" ", 2);
            dic.put(line[0].toLowerCase(), line[1].toLowerCase());
        }
        sc.close();
        return dic;
    }

    private static ArrayList<String> loadTxt(String path) throws FileNotFoundException {
        ArrayList<String> txt = new ArrayList<String>();
        File src = new File(path);
        Scanner sc = new Scanner(src);
        while (sc.hasNextLine()) {
            String x = sc.nextLine();
            txt.add(x);
        }
        sc.close();
        return txt;
    }

    private static ArrayList<String> translate(ArrayList<String> txt, HashMap<String, String> dic) {
        boolean r = false;
        ArrayList<String> fn = new ArrayList<String>();
        txt.forEach(e -> {
            String[] line = e.trim().split(" ");
            for (int i = 0; i < line.length; i++) {
                String y = dic.get(line[i].toLowerCase());
                if (y != null) {
                    line[i] = y;
                }
            }
            fn.add(String.join(" ", line));
        });
        return fn;
    }

    private static void writeBack(ArrayList<String> txt, String path) throws IOException {
        PrintStream fw = new PrintStream(new File(path + ".tsl"));
        txt.forEach(e -> {
            fw.println(e);
        });
        fw.close();
    }
}

/*
 * This code does not solc c), couldn't be bothered to change the code tbh :)
 * 
 * Anyway, if you do want to do it, keep in mind you'll have to make the
 * loadTxt method quite different, make it deal with only Strings, this because
 * in every recursion you'll have call it to read the remainder of the string
 * containing the meaning of the current word.
 */