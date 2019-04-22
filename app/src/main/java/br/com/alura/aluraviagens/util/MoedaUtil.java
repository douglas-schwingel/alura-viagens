package br.com.alura.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LINGUAGEM = "pt";
    public static final String PAIS = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_DESEAJDO = "R$ ";

    public static String formataParaReais(BigDecimal valor) {
        NumberFormat formatoBr = DecimalFormat.getCurrencyInstance(new Locale(LINGUAGEM, PAIS));
        return formatoBr.format(valor).replace(FORMATO_PADRAO, FORMATO_DESEAJDO);
    }
}
