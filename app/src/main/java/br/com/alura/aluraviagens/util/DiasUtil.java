package br.com.alura.aluraviagens.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formataDiaEmTexto(int dias) {
        if (dias > 1) {
            return dias + PLURAL;
        } else {
            return dias + SINGULAR;
        }
    }
}
