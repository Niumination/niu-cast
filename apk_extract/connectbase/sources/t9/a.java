package t9;

import android.content.Context;
import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15541c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uc.a f15542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c7.a f15543b;

    public void a(Context context, String str) throws ac.a {
        if (context == null || str == null) {
            throw new IllegalArgumentException("addActivityEmbeddingPkg invalid param");
        }
        f(b.a.f5988h).h(context, str);
    }

    public String b(Context context) throws ac.a {
        if (context != null) {
            return f(b.a.f5988h).f(context);
        }
        throw new IllegalArgumentException("getActivityEmbeddingPkgs invalid param");
    }

    public int c(Context context, String str) throws ac.a {
        if (context == null || str == null) {
            throw new IllegalArgumentException("getCompatibleMode invalid param");
        }
        return f(b.a.f5988h).d(context, str);
    }

    public boolean d(Context context, String str) throws ac.a {
        if (context == null || str == null) {
            throw new NullPointerException("Params cannot be null");
        }
        return f(b.a.f5996p).k(context, str);
    }

    public int e(Context context) throws ac.a {
        if (context != null) {
            return f(b.a.f5988h).b(context);
        }
        throw new IllegalArgumentException("getScreenRelayMode invalid param");
    }

    public nf.a f(String str) {
        if (b.b(str)) {
            e.f(f15541c, "TranThubFoldingScreenManager");
            uc.a aVar = this.f15542a;
            if (aVar != null) {
                return aVar;
            }
            uc.a aVar2 = new uc.a();
            this.f15542a = aVar2;
            return aVar2;
        }
        e.f(f15541c, "TranAospFoldingScreenManager");
        c7.a aVar3 = this.f15543b;
        if (aVar3 != null) {
            return aVar3;
        }
        c7.a aVar4 = new c7.a();
        this.f15543b = aVar4;
        return aVar4;
    }

    public boolean g(Context context, String str) throws ac.a {
        if (context == null || str == null) {
            throw new IllegalArgumentException("isPkgInActivityEmbedding invalid param");
        }
        return f(b.a.f5988h).e(context, str);
    }

    public void h(Context context, String str) throws ac.a {
        if (context == null || str == null) {
            throw new IllegalArgumentException("removeActivityEmbeddingPkg invalid param");
        }
        f(b.a.f5989i).a(context, str);
    }

    public void i(Context context, String str, int i10) throws ac.a {
        if (context == null || str == null || i10 < -1 || i10 > 2) {
            throw new IllegalArgumentException("getCompatibleMode invalid param");
        }
        f(b.a.f5988h).i(context, str, i10);
    }

    public void j(Context context, String str, int i10, boolean z10) throws ac.a {
        if (context == null || str == null || i10 < 0 || i10 > 3) {
            throw new NullPointerException("Params cannot is illegal");
        }
        f(b.a.f5996p).j(context, str, i10, z10);
    }

    public void k(Context context, String str, boolean z10, boolean z11) throws ac.a {
        if (context == null || str == null) {
            throw new NullPointerException("Params cannot be null");
        }
        f(b.a.f5996p).c(context, str, z10, z11);
    }

    public void l(Context context, int i10) throws ac.a {
        if (context == null || i10 < 0 || i10 > 3) {
            throw new IllegalArgumentException("setScreenRelayMode invalid param");
        }
        f(b.a.f5988h).g(context, i10);
    }
}
