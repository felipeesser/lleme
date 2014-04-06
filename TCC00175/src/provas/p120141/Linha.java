package provas.p120141;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Linha<E> implements Serializable {

  private Map<Integer, E> linha = new HashMap();

  public void set(int j, E valor) {
    j = Math.abs(j);
    if (valor == null)
      this.linha.remove(j);
    else
      this.linha.put(j, valor);
  }

  public E get(int j) {
    j = Math.abs(j);
    return this.linha.get(j);
  }

  public int colunas() {
    int colunas = -1;
    for (Integer j : linha.keySet())
      if (j > colunas)
        colunas = j;
    return colunas + 1;
  }
}
