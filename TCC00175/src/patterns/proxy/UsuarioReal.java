package patterns.proxy;

import java.sql.SQLException;
import java.sql.Timestamp;
import org.omg.CORBA.UserException;

public class UsuarioReal implements Usuario {

    private int id;
    private String nome;
    private long cpf;
    private Endereco endereco;
    private Timestamp timestamp;

    @Override
    public Endereco getEndereco() {
        return endereco;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void parsistir() throws ClassNotFoundException, SQLException, UserException {
        // não faz nada
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
