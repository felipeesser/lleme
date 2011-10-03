package patterns.proxy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import org.omg.CORBA.UserException;

public interface Usuario extends Cloneable {

    public long getCpf();

    public Endereco getEndereco() throws ClassNotFoundException, SQLException, Exception;

    public int getId();

    public String getNome();

    public Date getTimestamp();

    public void setCpf(long cpf);

    public void setEndereco(Endereco endereco);

    public void setId(int id);

    public void setNome(String nome);

    public void setTimestamp(Timestamp date);

    public void parsistir() throws ClassNotFoundException, SQLException, UserException;

    public Object clone() throws CloneNotSupportedException;
}
