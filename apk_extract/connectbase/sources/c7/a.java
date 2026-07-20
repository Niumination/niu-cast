package c7;

import android.content.Context;
import java.lang.reflect.Method;
import p6.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements nf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1374b = " dont has class of TranFoldingScreenManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f1375c = cc.a.a("com.transsion.hubsdk.foldable.TranFoldingScreen");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1376a = l();

    @Override // nf.a
    public void a(Context context, String str) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        cc.a.j(cc.a.g(cls, "removeActivityEmbeddingPkg", Context.class, String.class), this.f1376a, context, str);
    }

    @Override // nf.a
    public int b(Context context) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        Object objJ = cc.a.j(cc.a.g(cls, "getScreenRelayMode", Context.class), this.f1376a, context);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // nf.a
    public void c(Context context, String str, boolean z10, boolean z11) throws ac.a {
        Class clsA = cc.a.a("com.transsion.hubsdk.foldable.TranFoldingScreen");
        if (clsA != null) {
            Class cls = Boolean.TYPE;
            try {
                cc.a.j(cc.a.g(clsA, "setHoverModeStateForPackage", Context.class, String.class, cls, cls), clsA.newInstance(), context, str, Boolean.valueOf(z10), Boolean.valueOf(z11));
            } catch (Exception e10) {
                b.a("setHoverModeStateForPackage fail:", e10, getClass().getSimpleName());
            }
        }
    }

    @Override // nf.a
    public int d(Context context, String str) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        Object objJ = cc.a.j(cc.a.g(cls, "getCompatibleMode", Context.class, String.class), this.f1376a, context, str);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // nf.a
    public boolean e(Context context, String str) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        Object objJ = cc.a.j(cc.a.g(cls, "isPkgInActivityEmbedding", Context.class, String.class), this.f1376a, context, str);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // nf.a
    public String f(Context context) throws ac.a {
        Class<?> cls = f1375c;
        if (cls != null) {
            return (String) cc.a.j(cc.a.g(cls, "getActivityEmbeddingPkgs", Context.class), this.f1376a, context);
        }
        throw new ac.a(f1374b);
    }

    @Override // nf.a
    public void g(Context context, int i10) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        cc.a.j(cc.a.g(cls, "setScreenRelayMode", Context.class, Integer.TYPE), this.f1376a, context, Integer.valueOf(i10));
    }

    @Override // nf.a
    public void h(Context context, String str) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        cc.a.j(cc.a.g(cls, "addActivityEmbeddingPkg", Context.class, String.class), this.f1376a, context, str);
    }

    @Override // nf.a
    public void i(Context context, String str, int i10) throws ac.a {
        Class<?> cls = f1375c;
        if (cls == null) {
            throw new ac.a(f1374b);
        }
        cc.a.j(cc.a.g(cls, "setCompatibleMode", Context.class, String.class, Integer.TYPE), this.f1376a, context, str, Integer.valueOf(i10));
    }

    @Override // nf.a
    public void j(Context context, String str, int i10, boolean z10) throws ac.a {
        Class clsA = cc.a.a("com.transsion.hubsdk.foldable.TranFoldingScreen");
        if (clsA != null) {
            try {
                cc.a.j(cc.a.g(clsA, "setCompatibleMode", Context.class, String.class, Integer.TYPE, Boolean.TYPE), clsA.newInstance(), context, str, Integer.valueOf(i10), Boolean.valueOf(z10));
            } catch (Exception e10) {
                b.a("setCompatibleMode fail:", e10, getClass().getSimpleName());
            }
        }
    }

    @Override // nf.a
    public boolean k(Context context, String str) throws ac.a {
        Method methodG;
        Class clsA = cc.a.a("com.transsion.hubsdk.foldable.TranFoldingScreen");
        if (clsA == null || (methodG = cc.a.g(clsA, "getHoverModeStateForPackage", Context.class, String.class)) == null) {
            return false;
        }
        try {
            return Boolean.TRUE.equals(cc.a.j(methodG, clsA.newInstance(), context, str));
        } catch (Exception e10) {
            b.a("getHoverModeStateForPackage fail:", e10, getClass().getSimpleName());
            return false;
        }
    }

    public final Object l() {
        try {
            Class<?> cls = f1375c;
            if (cls != null) {
                return cls.newInstance();
            }
            return null;
        } catch (Exception e10) {
            b.a("getInstance fail:", e10, getClass().getSimpleName());
            return null;
        }
    }
}
