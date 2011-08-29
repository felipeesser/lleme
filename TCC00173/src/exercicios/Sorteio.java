package exercicios;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Sorteio {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String[] alunos = leAlunos();
        int[] sorteados = leSorteios();

        OutputStream output = new FileOutputStream("sortreados.txt", true);
        OutputStreamWriter writer = new OutputStreamWriter(output);
        BufferedWriter bw = new BufferedWriter(writer);
        int sorteio;
        do
            sorteio = (int) (Math.random() * 24);
        while (foiSorteado(sorteio, sorteados));
        bw.write("" + sorteio);
        System.out.println(alunos[sorteio]);

        output.close();

    }

    public static boolean foiSorteado(int n, int[] sorteados) {
        for (int i = 0; i < sorteados.length; i++)
            if (sorteados[i] == n)
                return true;
        return false;
    }

    public static String[] leAlunos() throws FileNotFoundException {
        InputStream input = new FileInputStream(".\\dat\\alunos.txt");
        Scanner in = new Scanner(input);
        String[] alunos = new String[25];
        int i = 0;
        while (in.hasNext()) {
            alunos[i] = in.nextLine();
            i++;
        }
        in.close();
        return alunos;
    }

    public static int[] leSorteios() throws FileNotFoundException {
        InputStream input = new FileInputStream(".\\dat\\sorteados.txt");
        Scanner in = new Scanner(input);
        int[] sorteados = new int[100];
        int i = 0;
        while (in.hasNext()) {
            sorteados[i] = in.nextInt();
            i++;
        }
        in.close();
        return sorteados;
    }
}
