package wj;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f2 extends vj.p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18668b = "shuffleAddressList";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f18669c = v0.i("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST", true);

    public static Object f(Map<String, ?> map) {
        Boolean boolD = h1.d(map, f18668b);
        return f18669c ? new c2.e(boolD, null) : new e2.c(boolD, null);
    }

    @b1.e
    public static boolean g() {
        return f18669c;
    }

    @Override // vj.o1.d
    public vj.o1 a(vj.o1.f fVar) {
        return f18669c ? new c2(fVar) : new e2(fVar);
    }

    @Override // vj.p1
    public String b() {
        return v0.H;
    }

    @Override // vj.p1
    public int c() {
        return 5;
    }

    @Override // vj.p1
    public boolean d() {
        return true;
    }

    @Override // vj.p1
    public vj.x1.c e(Map<String, ?> map) {
        try {
            return vj.x1.c.a(f(map));
        } catch (RuntimeException e10) {
            return vj.x1.c.b(vj.y2.f17563t.t(e10).u("Failed parsing configuration for " + b()));
        }
    }
}
