
import ic.tcc00175.biblioteca.DAO.DAOHibernateUtil;
import ic.tcc00175.biblioteca.controller.Livro;
import ic.tcc00175.biblioteca.controller.Material;
import ic.tcc00175.biblioteca.controller.Operacao;
import ic.tcc00175.biblioteca.controller.Reserva;
import ic.tcc00175.biblioteca.controller.Usuario;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.hibernate.classic.Session;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luiz Leme
 */
public class TesteHibernate {

    public static void main(String[] args) {
        Material m1 = new Material(1l, "Engenharia de Software");
        Livro l1 = new Livro(1l, m1);
        Usuario u1 = new Usuario(123, "Luiz");
        Operacao op1 = new Operacao(1, u1);
        op1.setData(Calendar.getInstance().getTime());
        Reserva r1 = new Reserva(1, op1, l1);

        Session session = DAOHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Livro> livros = session.createQuery("from Livro where material_codigo=1").list();
        for (Livro l : livros) {
            System.out.println(l.getMaterial().getTitulo());
            Set<Reserva> sr = l.getReservas();
            for (Reserva r : sr) {
                System.out.println(r.getOperacao().getUsuario().getNome());
                System.out.println(r.getOperacao().getData().toString());
            }
        }
        session.getTransaction().commit();

    }
}
