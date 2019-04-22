package br.com.alura.aluraviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.models.Pacote;

public class DataUtil {

    public static String formataData(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = formatoBr.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBr.format(dataVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }
}