package l8;

import android.preference.PreferenceFragment;
import android.widget.ListView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements vg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9746a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f9747b = cc.a.a("android.preference.PreferenceFragment");

    @Override // vg.a
    public ListView a(PreferenceFragment preferenceFragment) {
        try {
            Method methodG = cc.a.g(f9747b, "getListView", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(preferenceFragment, null);
            if (objInvoke != null && (objInvoke instanceof ListView)) {
                return (ListView) objInvoke;
            }
        } catch (Throwable th2) {
            m7.a.a("getListView fail", th2, f9746a);
        }
        return null;
    }
}
