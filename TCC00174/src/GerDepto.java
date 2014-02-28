
import com.sun.xml.internal.ws.util.StringUtils;
import java.lang.reflect.Array;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luiz Leme
 */
public class GerDepto {

  public static void main(String[] args) {
    Gerente ger1 = new Gerente();
    ger1.nome = "Gerente";
    
    Departamento depto1 = new Departamento();
    depto1.nome="Depto1";
    
    ger1.chefeDe=depto1;
    depto1.chefe=ger1;
    
    
    System.out.println(ger1.chefeDe.nome);
    System.out.println(depto1.chefe.nome);
  }
}
