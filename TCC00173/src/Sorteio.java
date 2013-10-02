
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sorteio {

    public static void main(String[] args) {
        int quantidade = 0;
        try (InputStream input = new FileInputStream("./dat/alunos.txt")) {
            quantidade = contAlunos(input);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        }
        try (InputStream input = new FileInputStream("./dat/alunos.txt")) {
            int sorteio = (int) (Math.random() * quantidade + 1);
            System.out.println(encontraAluno(sorteio, input));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String encontraAluno(int n, InputStream input) {
        Scanner in = new Scanner(input);
        int indice, matricula;
        String nome;
        while (in.hasNext()) {
            indice = in.nextInt();
            matricula = in.nextInt();
            nome = in.nextLine();
            if (indice == n) {
                return nome;
            }
        }
        return null;
    }

    public static int contAlunos(InputStream input) {
        Scanner in = new Scanner(input);
        int contador = 0;
        while (in.hasNext()) {
            contador++;
            in.nextLine();
        }
        return contador;
    }
}
