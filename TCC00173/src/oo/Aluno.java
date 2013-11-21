package oo;

public abstract class Aluno{
  
  public static String universidade=null;
  public int matricula=0;
  public String nome="";
  public Turma[] turmas=new Turma[5];
  
  public void listaDisciplinas(){
    lista();
  }
  protected void lista(){
    for(Turma t: turmas){
      if (t!=null)
        System.out.println(t.disciplina);
    }
  }
  
}
