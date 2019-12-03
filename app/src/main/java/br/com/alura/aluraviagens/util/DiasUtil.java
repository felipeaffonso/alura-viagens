package br.com.alura.aluraviagens.util;

public class DiasUtil {

    public static final String DIAS_PLURAL = " dias";
    public static final String DIA_SINGULAR = " dia";

    public static String formataDiasEmTexto(final int qunatidadeDias) {
        if(qunatidadeDias > 1) {
            return qunatidadeDias + DIAS_PLURAL;
        }
        return qunatidadeDias + DIA_SINGULAR;
    }

}
