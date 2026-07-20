package m7;

import android.content.Context;
import android.os.LocaleList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class g implements xf.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10589c = "g";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f10590d = cc.a.a("com.android.internal.app.LocalePicker");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f10591e = cc.a.a("com.android.internal.app.LocalePicker$LocaleInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f10592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f10593b = bc.a.a();

    @Override // xf.c
    public void a(LocaleList localeList) {
        try {
            cc.a.j(cc.a.g(f10590d, "updateLocales", LocaleList.class), f10590d, localeList);
        } catch (Throwable th2) {
            a.a("updateLocales fail ", th2, f10589c);
        }
    }

    @Override // xf.c
    public List<da.e> b(boolean z10) {
        new ArrayList();
        ArrayList arrayList = new ArrayList();
        try {
            Method methodG = cc.a.g(f10590d, "getAllAssetLocales", Context.class, Boolean.TYPE);
            methodG.setAccessible(true);
            List list = (List) methodG.invoke(null, this.f10593b, Boolean.valueOf(z10));
            Method methodG2 = cc.a.g(f10591e, "getLabel", new Class[0]);
            methodG2.setAccessible(true);
            Method methodG3 = cc.a.g(f10591e, "getLocale", new Class[0]);
            methodG3.setAccessible(true);
            for (Object obj : list) {
                arrayList.add(new da.e((String) methodG2.invoke(obj, null), (Locale) methodG3.invoke(obj, null)));
            }
        } catch (IllegalAccessException | InvocationTargetException e10) {
            dc.e.c(f10589c, "getAllAssetLocales fail " + e10);
        }
        return arrayList;
    }

    @Override // xf.c
    public void c(Locale locale) {
        cc.a.j(cc.a.g(f10590d, "updateLocale", Locale.class), f10590d, locale);
    }
}
