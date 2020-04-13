
import java.io.*;


public class Otherwise {
    private String word;
    private String otherwise;

    public Otherwise(String in) {
        word = in;
    }
    public String change() {
        int stackSize = word.length();
        Stack stack = new Stack(stackSize);
        for (int j = 0; j < word.length(); j++) {
            char ch = word.charAt(j);
            stack.push(ch);
        }

        otherwise = "";
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            otherwise = otherwise + ch;
        }
        return otherwise;
    }

    public static void main(String[] args) throws IOException {
        String word;
        System.out.print("Enter a string: ");
        System.out.flush();
        word = getString();

        Otherwise obj = new Otherwise(word);
        System.out.println("Otherwise: " + obj.change());
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
