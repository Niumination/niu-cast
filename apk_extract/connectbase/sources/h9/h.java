package h9;

import android.os.IBinder;
import ic.p0;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7035c = g.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p0 f7036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.g f7037b;

    public interface a {
        void a(IBinder iBinder, String str, int i10, boolean z10);
    }

    public bf.e a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7035c, "TranThubActivityManager");
            p0 p0Var = this.f7036a;
            if (p0Var != null) {
                return p0Var;
            }
            p0 p0Var2 = new p0();
            this.f7036a = p0Var2;
            return p0Var2;
        }
        dc.e.f(f7035c, "TranAospActivityManager");
        p6.g gVar = this.f7037b;
        if (gVar != null) {
            return gVar;
        }
        p6.g gVar2 = new p6.g();
        this.f7037b = gVar2;
        return gVar2;
    }

    public boolean b(a aVar) {
        if (aVar != null) {
            return a(fc.b.a.A).a(aVar);
        }
        throw new IllegalArgumentException("observer cannot be null");
    }
}
