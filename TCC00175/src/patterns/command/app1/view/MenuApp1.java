package patterns.command.app1.view;

import patterns.command.app1.control.Engordar1Kg;
import patterns.command.app1.control.Emagrecer1Kg;
import patterns.command.app1.control.Engordar10Kg;
import patterns.command.app1.model.Paciente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import patterns.command.framework.Command;
import patterns.command.framework.Menu;

public class MenuApp1 extends Menu {

    public static void main(String[] args) throws ParseException {
        Menu menu = new MenuApp1();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nascimentoStr = "30/04/1989";
        Date nascimento = sdf.parse(nascimentoStr);

        Paciente paciente1 = new Paciente("Paciente 1", 85.0f, 1.8f, nascimento);
        menu.opcao1 = new Emagrecer1Kg(paciente1);
        menu.opcao2 = new Engordar1Kg(paciente1);
        menu.opcao3 = new Engordar10Kg(paciente1);
        
        List <Command> l = new ArrayList<Command>();
        l.add(menu.opcao1);
        menu.acionarOpcao3();
        l.get(0).desfazer();
        
        System.out.println(paciente1.nome+" "+paciente1.peso);
        
        
        nascimentoStr = "17/10/1991";
        nascimento = sdf.parse(nascimentoStr);
        Paciente paciente2 = new Paciente("Paciente 2", 85.0f, 1.8f, nascimento);
        menu.opcao1 = new Emagrecer1Kg(paciente2);
        menu.opcao2 = new Engordar1Kg(paciente2);
        menu.opcao3 = new Engordar10Kg(paciente2);
        
        menu.acionarOpcao2();
        System.out.println(paciente2.nome+" "+paciente2.peso);

    }
}
