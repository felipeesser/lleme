
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

  public static void main(String[] args) throws FileNotFoundException {
    String exp = "( C + 4 ) * 3";
    Reader reader = new StringReader(exp);
    StreamTokenizer tk = new StreamTokenizer(reader);
    try {
      while (tk.ttype != StreamTokenizer.TT_EOF) {
        tk.nextToken();
        if (tk.ttype == StreamTokenizer.TT_NUMBER)
          System.out.println("" + tk.nval);
        else
          System.out.println("" + tk.sval);
      }

    } catch (IOException ex) {
      Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
    }

    String[] arr = exp.split(" ");
    for (String str : arr)
      System.out.println(str);
    
  }
}
