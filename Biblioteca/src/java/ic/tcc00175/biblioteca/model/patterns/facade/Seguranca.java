package ic.tcc00175.biblioteca.model.patterns.facade;

import ic.tcc00175.biblioteca.model.patterns.mediator.LoginMediador;

import javax.servlet.http.HttpServletRequest;

public class Seguranca {

    private LoginMediador mediador = null;

    public Seguranca() {
        super();
        mediador = new LoginMediador();
    }

    public void doLogin(HttpServletRequest request) {
        mediador.doLogin(request);
    }

    public void doLogout(HttpServletRequest request) {
        mediador.doLogout(request);
    }
}
