package testes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Clonagem implements Cloneable, Serializable {

    public String atributo = null;
    public Set<String> colecao = new HashSet<String>();

    public static void main(String[] args) throws CloneNotSupportedException {
        Clonagem teste = new Clonagem();
        teste.atributo = "Luiz André";
        teste.colecao.add(teste.atributo);
        Clonagem teste2 = (Clonagem) teste.clone();
        teste2.atributo = "outro nome";
        teste2.colecao.clear();
        teste2.colecao.add(teste2.atributo);
    }

    @Override
    // Shallow cloning
    public Clonagem clone() throws CloneNotSupportedException {
        int tipo = 1;
        switch (tipo) {
            case 1:
                return shallowClone();
            case 2:
                return deepClone1();
            case 3:
                return deepClone2();
            default:
                return shallowClone();
        }
    }

    // Shallow cloning
    public Clonagem shallowClone() throws CloneNotSupportedException {
        return (Clonagem) super.clone();
    }

    // Deep cloning 1
    public Clonagem deepClone1() throws CloneNotSupportedException {
        Clonagem clone = (Clonagem) super.clone();
        clone.colecao = new HashSet<String>();
        for (String valor : colecao)
            clone.colecao.add(valor + "");
        return clone;
    }

    // Deep cloning 1
    public Clonagem deepClone2() {
        Clonagem objeto = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(this);
            oos.flush();

            InputStream is = new ByteArrayInputStream(os.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(is);
            objeto = (Clonagem) ois.readObject();
        } catch (IOException e) {
            e.toString();
        } catch (Exception e) {
            e.toString();
        }
        return objeto;
    }
}
