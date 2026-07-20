package io.github.inflationx.calligraphy3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    private TypefaceUtils() {
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        Map<Typeface, CalligraphyTypefaceSpan> map = sCachedSpans;
        synchronized (map) {
            try {
                if (map.containsKey(typeface)) {
                    return map.get(typeface);
                }
                CalligraphyTypefaceSpan calligraphyTypefaceSpan = new CalligraphyTypefaceSpan(typeface);
                map.put(typeface, calligraphyTypefaceSpan);
                return calligraphyTypefaceSpan;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue(typeface);
    }

    public static Typeface load(AssetManager assetManager, String str) {
        Map<String, Typeface> map = sCachedFonts;
        synchronized (map) {
            try {
                try {
                    if (map.containsKey(str)) {
                        return map.get(str);
                    }
                    Typeface typefaceCreateFromFile = str.startsWith("/") ? Typeface.createFromFile(str) : Typeface.createFromAsset(assetManager, str);
                    map.put(str, typefaceCreateFromFile);
                    return typefaceCreateFromFile;
                } catch (Exception e10) {
                    Log.w("Calligraphy", "Can't create asset from " + str + ". Make sure you have passed in the correct path and file name.", e10);
                    sCachedFonts.put(str, null);
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
