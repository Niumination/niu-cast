package va;

import android.os.IBinder;
import vd.b0;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16797c = "m";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f16798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.o f16799b;

    public IBinder a(String str) {
        return b(fc.b.a.f5988h).a(str);
    }

    public pg.k b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16797c, "TranThubServiceManager");
            b0 b0Var = this.f16798a;
            if (b0Var != null) {
                return b0Var;
            }
            b0 b0Var2 = new b0();
            this.f16798a = b0Var2;
            return b0Var2;
        }
        dc.e.f(f16797c, "TranAospServiceManager");
        e8.o oVar = this.f16799b;
        if (oVar != null) {
            return oVar;
        }
        e8.o oVar2 = new e8.o();
        this.f16799b = oVar2;
        return oVar2;
    }

    public String[] c() {
        return b(fc.b.a.f5981a).b();
    }
}
