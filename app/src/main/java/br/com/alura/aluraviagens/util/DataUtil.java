package br.com.alura.aluraviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";
    public static final String PT = "pt";
    public static final String BR = "br";

    @NonNull
    public static String periodoEmTexto(final int dias) {
        final Calendar dataIda = Calendar.getInstance();
        final Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        final SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES, new Locale(PT, BR));
        final String dataIdaString = formatoBrasileiro.format(dataIda.getTime());
        final String dataVoltaString = formatoBrasileiro.format(dataVolta.getTime());
        return dataIdaString + " - " + dataVoltaString + " de " + dataVolta.get(Calendar.YEAR);
    }
}
