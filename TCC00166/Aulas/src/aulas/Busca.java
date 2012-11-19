package aulas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.nio.channels.FileChannel;

import java.util.Calendar;
import java.util.Scanner;

public class Busca {

    private static String sobra = "";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //criarArquivo(100000000);
        indexarArquivo();
//        double inicio, fim;
//        inicio = Calendar.getInstance().getTimeInMillis();
//        System.out.println("Nome do aluno: " + busca(9999999));
//        fim = Calendar.getInstance().getTimeInMillis();
//        System.out.println("Duração: " + (fim - inicio) / 1000 + " milisegundos");
//        inicio = Calendar.getInstance().getTimeInMillis();
//        System.out.println("Nome do aluno: " + buscaIndexada(9999999));
//        fim = Calendar.getInstance().getTimeInMillis();
//        System.out.println("Duração: " + (fim - inicio) / 1000 + " milisegundos");
    }

    public static String busca(long matriculaInformada) throws FileNotFoundException, IOException {
        String linha, nome = null;
        long matricula;
        boolean achou = false;
        try (InputStream input = new FileInputStream("./dat/alunos.txt");
                Scanner in = new Scanner(input)) {
            while (in.hasNext() && !achou) {
                matricula = in.nextLong();
                if (matricula == matriculaInformada) {
                    nome = in.nextLine();
                    achou = true;
                } else
                    in.nextLine();
            }
        }
        return nome;
    }

    public static String buscaIndexada(long matriculaInformada) throws FileNotFoundException, IOException {
        String linha, nome = null;
        long matricula;
        boolean achou = false;
        try (FileInputStream input = new FileInputStream("./dat/alunos.txt");) {
            long inicio = getInicio(matriculaInformada);
            if (inicio > 0) {
                input.getChannel().position(inicio);
                Scanner in = new Scanner(input);
                while (in.hasNext() && !achou) {
                    matricula = in.nextLong();
                    if (matricula == matriculaInformada) {
                        nome = in.nextLine();
                        achou = true;
                    } else
                        in.nextLine();
                }
            }
        }
        return nome;
    }

    public static void indexarArquivo() throws FileNotFoundException, IOException {
        long pos = 0, matricula = 0;
        try (OutputStream output = new FileOutputStream("./dat/indice.txt", false);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer)) {
            FileChannel myFileChannel;
            try (FileInputStream input = new FileInputStream("./dat/alunos.txt");
                    InputStreamReader sr = new InputStreamReader(input);
                    BufferedReader br = new BufferedReader(sr)) {
                Scanner in;
                String linha = br.readLine();
                myFileChannel = input.getChannel();
                while (linha != null) {
                    in = new Scanner(linha);
                    matricula = in.nextLong();
                    pos = input.getChannel().position();
                    bw.write(matricula + " " + pos + "\r\n");
                    linha = br.readLine();
                }
            }
            bw.flush();
        }
    }

    public static void criarArquivo(int qtd) throws FileNotFoundException, IOException {
        try (OutputStream output = new FileOutputStream("./dat/alunos.txt", false);
                OutputStreamWriter writer = new OutputStreamWriter(output);
                BufferedWriter bw = new BufferedWriter(writer)) {
            for (long i = 1; i <= qtd; i++)
                bw.write(i + " Nome do aluno " + i + " Endereco do Aluno " + i + "\r\n");
            bw.flush();
        }
    }

    private static long getInicio(long matriculaInformada) throws FileNotFoundException, IOException {
        String linha;
        long matricula, posicao = -1;
        boolean achou = false;
        try (InputStream input = new FileInputStream("./dat/indice.txt");
                Scanner in = new Scanner(input)) {
            while (in.hasNext() && !achou) {
                matricula = in.nextLong();
                if (matricula == matriculaInformada) {
                    posicao = in.nextLong();
                    achou = true;
                } else
                    in.nextLine();
            }
        }
        return posicao;
    }
}
