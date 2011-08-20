package testes;

import oo.Usuario;

public class Clonagem implements Usuario, Cloneable {

  public static void main(String[] args) throws CloneNotSupportedException {
    Clonagem teste = new Clonagem();
    Clonagem teste2 = (Clonagem) teste.clone();
  }

  public void login(String id, String senha) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void logout() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
