package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        String ds1 = "Qua Mar 05 15:24:05 BRT 2014";
        String ds2 = "05/03/2014 15:19";

        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        System.out.println(sdf1.toLocalizedPattern());

        Date data = sdf1.parse(ds1);
        System.out.println(sdf2.format(data));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String dateLocalizedFormatPattern = simpleDateFormat.toLocalizedPattern();
        System.out.println(dateLocalizedFormatPattern);
        
        System.out.println(simpleDateFormat.format(data));
    }
}
