package p6;

import android.app.Activity;
import com.android.internal.app.AlertActivity;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements bf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12936a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f12937b = cc.a.a("android.app.Activity");

    @Override // bf.b
    public void a(Object obj) {
        Method methodG;
        AlertActivity alertActivity = obj instanceof AlertActivity ? (AlertActivity) obj : null;
        if (cc.a.a("com.android.internal.app.AlertActivity") == null || alertActivity == null || (methodG = cc.a.g(alertActivity.getClass(), "setupAlert", new Class[0])) == null) {
            return;
        }
        cc.a.j(methodG, obj, new Object[0]);
        dc.e.f(f12936a, "setupAlert success");
    }

    @Override // bf.b
    public String b(Activity activity) {
        try {
            return (String) cc.a.d(f12937b, "mReferrer").get(activity);
        } catch (IllegalAccessException e10) {
            dc.e.c(f12936a, "getReferrer fail " + e10);
            return null;
        }
    }

    @Override // bf.b
    @Deprecated
    public void c(int i10, String str, String str2, String str3, boolean z10) {
        Class clsA = cc.a.a("com.transsion.hubsdk.app.TranActivity");
        if (clsA != null) {
            Method methodG = cc.a.g(clsA, "sceneHappen", Integer.TYPE, String.class, String.class, String.class, Boolean.TYPE);
            if (methodG == null) {
                dc.e.f(f12936a, "TranAospActivity sceneHappen method is null!");
                return;
            }
            try {
                cc.a.j(methodG, clsA.newInstance(), Integer.valueOf(i10), str, str2, str3, Boolean.valueOf(z10));
            } catch (Exception e10) {
                b.a(" sceneHappen fail:", e10, getClass().getSimpleName());
            }
        }
    }
}
