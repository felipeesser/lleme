package exercicios.matriz;

public class Main {

  public static void main(String[] args) {
    Matriz<Aluno> m = new Matriz<>();
    Aluno aluno1 = new Aluno(2);
    Aluno aluno2 = new Aluno(9);

    m.set(3, 4, aluno1);
    m.set(6, 40, aluno1);
    System.out.println(m.linhas());
    System.out.println(m.colunas());
    System.out.println(m.get(500, 70));
    
    //MatrizEscalar m = new MatrizEscalar<MyDouble>();
  }
}