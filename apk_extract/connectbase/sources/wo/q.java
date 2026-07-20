package wo;

import eo.a1;
import eo.z0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ro.h f19818b;

    public q(@os.l ro.h hVar) {
        l0.p(hVar, "packageFragment");
        this.f19818b = hVar;
    }

    @Override // eo.z0
    @os.l
    public a1 b() {
        a1 a1Var = a1.f4590a;
        l0.o(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    @os.l
    public String toString() {
        return this.f19818b + ": " + this.f19818b.G0().keySet();
    }
}
