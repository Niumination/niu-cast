package h9;

import android.app.Application;
import ic.g1;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7046c = "k";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g1 f7047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.m f7048b;

    @yb.a(level = 1)
    public Application a() {
        return c(fc.b.a.f5989i).b();
    }

    public Application b() {
        return c(fc.b.a.f5989i).a();
    }

    public bf.h c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7046c, "TranThubActivityThread");
            g1 g1Var = this.f7047a;
            if (g1Var != null) {
                return g1Var;
            }
            g1 g1Var2 = new g1();
            this.f7047a = g1Var2;
            return g1Var2;
        }
        dc.e.f(f7046c, "TranAospActivityThread");
        p6.m mVar = this.f7048b;
        if (mVar != null) {
            return mVar;
        }
        p6.m mVar2 = new p6.m();
        this.f7048b = mVar2;
        return mVar2;
    }
}
