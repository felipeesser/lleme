
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
        
        float media = calcularMedia("./dat/notas2.txt");
        try (OutputStream output = new FileOutputStream("./dat/saida.txt", true);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer);
                InputStream input = new FileInputStream("./dat/notas2.txt");) {
            Scanner in = new Scanner(input);
            int i = 0;
            int mat;
            float nota;
            while (in.hasNext() && i < 50) {
                mat = in.nextInt();
                nota = in.nextFloat();
                if (nota < media) {
                    bw.write(mat + " " + nota + "\n");
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static float calcularMedia(String arquivo) {
        float media = 0;
        try (InputStream input = new FileInputStream("entrada.txt")) {
            Scanner in = new Scanner(input);
            int i = 0;
            while (in.hasNext() && i < 50) {
                in.nextInt();
                media += in.nextFloat();
                i++;
            }
            media /= i;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        return media;
    }
}
