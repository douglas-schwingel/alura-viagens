package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ImagemUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(String caminhoImagem, Context context) {
        Resources resources = context.getResources();
        int idDrawable = resources.getIdentifier(caminhoImagem, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDrawable);
    }
}
