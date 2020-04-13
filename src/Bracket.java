
import java.io.*;

class CheckBracket {
    private String in;
    private boolean bracketMiddle;
    private boolean bracketSenior;

    public CheckBracket(String in) {
        this.in = in; }

    public void check() {
        int stackSize = in.length();
        Stack theStack = new Stack(stackSize);
        for(int j=0; j<in.length(); j++)
        {
            char ch = in.charAt(j);
            switch(ch)
            {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if( !theStack.isEmpty() )
                    {
                        char chx = theStack.pop();
                        if(ch=='}') bracketSenior=true;
                        if(ch==')') bracketMiddle=true;

                        if(      (ch=='}' && chx!='{') ||
                                (ch==']' && (  (chx!='[') || (chx != '[')&& bracketSenior ||
                                                             (ch != '[') && bracketMiddle)) ||
                                (ch==')' && (  (chx!='(') || (chx !='(')&& bracketSenior) ))
                            System.out.println("Error: "+ch+" at "+j);
                    }

                    else
                        System.out.println("Error: "+ch+" at "+j);
                    break;
                default:
                    break;
            }
        }

        if( !theStack.isEmpty() )
            System.out.println("Error: missing right delimiter");
    }
}
class Main
{
    public static void main(String[] args) throws IOException
    {
        String string;
        while(true) {
            System.out.print(
                    "Enter string  ");
            System.out.flush();
            string = getString();
            CheckBracket c = new CheckBracket(string);
            c.check();
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}