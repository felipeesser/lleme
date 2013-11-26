
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

  public static void main(String[] args) {

    int[] vetor = {1,2,3,4,5,6,7,8,9};
    int aux = vetor[5];
    vetor[5]=vetor[1];
    vetor[1]=aux;


  }

  
}
