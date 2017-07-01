package com.anduntils.wllk;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by huiyi on 2017/6/30.
 */
public class FontUtils {

    public static void setDeauftFont(Context context,String staticTypeFiledName,String fontAssetsName) {

        final Typeface regular = Typeface.createFromAsset(context.getAssets(),fontAssetsName);
        replaceFont(staticTypeFiledName,regular);
    }

    public static void replaceFont(String statictypeFiledName,Typeface newTypeFace) {

        try {
            Field statcField = Typeface.class.getDeclaredField(statictypeFiledName);
            statcField.setAccessible(true);
            statcField.set(null,newTypeFace);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
