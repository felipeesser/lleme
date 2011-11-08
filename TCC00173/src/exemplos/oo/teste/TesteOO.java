package exemplos.oo.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TesteOO {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream(".\\dat\\compras.txt");
        Scanner in = new Scanner(input);

        Compra[] compras = new Compra[10];
        int i = 0;
        Compra compraAnt = null;
        Compra compra = null;
        
        while (in.hasNext()) {
            int idCompra = in.nextInt();
            int qtdProduto = in.nextInt();
            float valorCompra = in.nextFloat();

            if (compraAnt == null || compra != compraAnt)
                compra = new Compra();
            
            compra.id = idCompra;
            Item item = new Item();
            item.qtd = qtdProduto;
            item.valor = valorCompra;
            compra.incluirItem(item);
            compras[i++] = compra;
            
            compraAnt = compra;
        }
        input.close();

        for (int j = 0; j < compras.length; j++)
            if (compras[j] != null)
                System.out.println(compras[j].id);

    }
}
