package s8;

import android.content.Context;
import com.android.internal.annotations.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ch.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15021c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f15022d = cc.a.a("android.telecom.DefaultDialerManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15023a = bc.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f15024b;

    @Override // ch.a
    public boolean a(Context context, String str) {
        try {
            if (this.f15024b == null) {
                Constructor constructorC = cc.a.c(f15022d, new Class[0]);
                constructorC.setAccessible(true);
                this.f15024b = constructorC.newInstance(null);
            }
            Method methodG = cc.a.g(f15022d, "setDefaultDialerApplication", Context.class, String.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15024b, context, str);
            if (objInvoke != null && (objInvoke instanceof Boolean)) {
                return ((Boolean) objInvoke).booleanValue();
            }
        } catch (Throwable th2) {
            m7.a.a("setDefaultDialerApplication fail ", th2, f15021c);
        }
        return false;
    }

    @VisibleForTesting
    public void b(Object obj) {
        this.f15024b = obj;
    }
}
