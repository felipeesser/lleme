package patterns.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Fachada extends Operacoes implements InterfaceChaveValor {

    public String reservar(Map<String, String> parametros) throws ParseException {

        String tipoQuarto = parametros.get("tipoQuarto");
        String inicioStr = parametros.get("inicio");
        String fimStr = parametros.get("fim");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return reservar(tipoQuarto, sdf.parse(inicioStr), sdf.parse(fimStr));
    }
}
