package com.transsion.core.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class Commutil {
    public static File getExternalCacheDir(Context context) {
        boolean z2 = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z2 = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (z2) {
            return null;
        }
        try {
            return context.getExternalCacheDir();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
