package testes;

import java.util.Scanner;

public class NextLine {

    public static void main(String[] args) {
        String str = " ";
        //str = str.trim();
        Scanner in = new Scanner(str);
        System.out.println(in.hasNext());
        System.out.println(in.hasNextLine());
        String str2 = in.nextLine();
        System.out.println(str2);

    }

}
