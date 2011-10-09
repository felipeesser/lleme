package patterns.composite;

import java.util.HashSet;
import java.util.Set;

public class ItemComposto extends Item {

    /**
     * @aggregation composite
     */
    Set<Item> itens = new HashSet<Item>();

    @Override
    public double getVariacao() {
        double variacao = 0;
        for (Item item : itens)
            variacao += item.getVariacao();
        return variacao / itens.size();
    }

    @Override
    public void setVariacao(double variacao) {
        // Não faz nada
    }
}
