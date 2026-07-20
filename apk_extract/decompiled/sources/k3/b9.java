package k3;

/* JADX INFO: loaded from: classes.dex */
public abstract class b9 {
    public static hf.u a(hf.r rVar) {
        return new hf.u(rVar, false);
    }

    public static void b(ze.r1 r1Var, hf.v vVar) {
        v8.i(r1Var, "methodDescriptor");
        v8.i(vVar, "responseObserver");
        vVar.onError(new ze.s2(ze.q2.f11409l.h("Method " + r1Var.f11423b + " is unimplemented")));
    }
}
