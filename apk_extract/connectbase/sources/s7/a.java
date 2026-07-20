package s7;

import android.content.Context;
import dc.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a implements dg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15019a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f15020b = cc.a.a("com.android.internal.telephony.util.LocaleUtils");

    @Override // dg.a
    public Locale a(Context context, int i10, String str) {
        Method methodG = cc.a.g(f15020b, "getLocaleFromMcc", Context.class, Integer.TYPE, String.class);
        methodG.setAccessible(true);
        try {
            Object objInvoke = methodG.invoke(null, context, Integer.valueOf(i10), str);
            if (objInvoke == null || !(objInvoke instanceof Locale)) {
                return null;
            }
            return (Locale) objInvoke;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f15019a, "getLocaleFromMcc fail " + e10);
            return null;
        }
    }

    @Override // dg.a
    public String b(int i10) {
        return (String) cc.a.j(cc.a.g(f15020b, "defaultLanguageForMcc", Integer.TYPE), null, Integer.valueOf(i10));
    }
}
