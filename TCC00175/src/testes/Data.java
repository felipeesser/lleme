package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String hojeStr = "20/03/2011 13:23:15";
        Date hoje = sdf.parse(hojeStr);
        hoje.setTime(hoje.getTime()+24*60*60*1000);
        System.out.println(hoje);
    }
}
