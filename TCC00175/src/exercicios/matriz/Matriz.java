package exercicios.matriz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Matriz<E> implements Serializable {

  private HashMap<Integer, Linha<E>> matriz = new HashMap();

  public E get(int i, int j) {
    i = Math.abs(i);
    j = Math.abs(j);
    Linha<E> linha = matriz.get(i);
    if (linha != null)
      return linha.get(j);
    return null;
  }

  public void set(int i, int j, E valor) {
    i = Math.abs(i);
    j = Math.abs(j);
    if (valor != null)
      inclui(i, j, valor);
    else
      remove(i, j);
  }

  private void remove(int i, int j) {
    Linha<E> linha = matriz.get(i);
    if (linha != null) {
      linha.set(j, null);
      if (linha.colunas() == 0)
        matriz.remove(i);
    }
  }

  private void inclui(int i, int j, E valor) {
    Linha<E> linha = matriz.get(i);
    if (linha == null) {
      linha = new Linha();
      matriz.put(i, linha);
    }
    linha.set(j, valor);
  }

  public int linhas() {
    int linhas = -1;
    for (Integer i : matriz.keySet())
      if (i > linhas)
        linhas = i;
    return linhas + 1;
  }

  public int colunas() {
    int colunas = 0;
    int c = 0;
    for (Entry<Integer, Linha<E>> entry : matriz.entrySet()) {
      Linha<E> linha = entry.getValue();
      c = linha.colunas();
      if (c > colunas)
        colunas = c;
    }
    return colunas;
  }

  public void salvar(String arquivo) {
    try (OutputStream out = new FileOutputStream(arquivo, false);
         ObjectOutputStream s = new ObjectOutputStream(out);) {
      s.writeObject(this);
      s.flush();
      s.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static <T> Matriz<T> carregar(String arquivo, Matriz<T> matriz) {
    try (FileInputStream in = new FileInputStream(arquivo);
         ObjectInputStream s = new ObjectInputStream(in);) {
      matriz = (Matriz<T>) s.readObject();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
    }
    return matriz;
  }
}
