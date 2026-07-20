package xn;

import java.util.Collections;
import java.util.List;
import kn.d1;
import kn.f1;
import kn.h1;
import kn.m1;
import kn.n0;
import kn.u0;
import kn.w0;
import kn.y0;

/* JADX INFO: loaded from: classes3.dex */
public class b0 extends m1 {
    public static void u() {
        g.a();
        z.a();
    }

    public static j v(kn.q qVar) {
        un.h owner = qVar.getOwner();
        return owner instanceof j ? (j) owner : b.f20307d;
    }

    @Override // kn.m1
    public un.d a(Class cls) {
        return new h(cls);
    }

    @Override // kn.m1
    public un.d b(Class cls, String str) {
        return new h(cls);
    }

    @Override // kn.m1
    public un.i c(kn.g0 g0Var) {
        return new k(v(g0Var), g0Var.getName(), g0Var.getSignature(), g0Var.getBoundReceiver());
    }

    @Override // kn.m1
    public un.d d(Class cls) {
        return g.b(cls);
    }

    @Override // kn.m1
    public un.d e(Class cls, String str) {
        return g.b(cls);
    }

    @Override // kn.m1
    public un.h f(Class cls, String str) {
        return new o(cls, str);
    }

    @Override // kn.m1
    public un.s g(un.s sVar) {
        return f0.a(sVar);
    }

    @Override // kn.m1
    public un.k h(u0 u0Var) {
        return new l(v(u0Var), u0Var.getName(), u0Var.getSignature(), u0Var.getBoundReceiver());
    }

    @Override // kn.m1
    public un.l i(w0 w0Var) {
        return new m(v(w0Var), w0Var.getName(), w0Var.getSignature(), w0Var.getBoundReceiver());
    }

    @Override // kn.m1
    public un.m j(y0 y0Var) {
        return new n(v(y0Var), y0Var.getName(), y0Var.getSignature());
    }

    @Override // kn.m1
    public un.s k(un.s sVar) {
        return f0.b(sVar);
    }

    @Override // kn.m1
    public un.s l(un.s sVar, un.s sVar2) {
        return f0.c(sVar, sVar2);
    }

    @Override // kn.m1
    public un.p m(d1 d1Var) {
        return new q(v(d1Var), d1Var.getName(), d1Var.getSignature(), d1Var.getBoundReceiver());
    }

    @Override // kn.m1
    public un.q n(f1 f1Var) {
        return new r(v(f1Var), f1Var.getName(), f1Var.getSignature(), f1Var.getBoundReceiver());
    }

    @Override // kn.m1
    public un.r o(h1 h1Var) {
        return new s(v(h1Var), h1Var.getName(), h1Var.getSignature());
    }

    @Override // kn.m1
    public String p(kn.e0 e0Var) {
        k kVarC;
        un.i iVarA = wn.f.a(e0Var);
        return (iVarA == null || (kVarC = h0.c(iVarA)) == null) ? super.p(e0Var) : c0.f20308a.e(kVarC.L());
    }

    @Override // kn.m1
    public String q(n0 n0Var) {
        return p(n0Var);
    }

    @Override // kn.m1
    public void r(un.t tVar, List<un.s> list) {
    }

    @Override // kn.m1
    public un.s s(un.g gVar, List<un.u> list, boolean z10) {
        return vn.g.b(gVar, list, z10, Collections.emptyList());
    }

    @Override // kn.m1
    public un.t t(Object obj, String str, un.v vVar, boolean z10) {
        List<un.t> typeParameters;
        if (obj instanceof un.d) {
            typeParameters = ((un.d) obj).getTypeParameters();
        } else {
            if (!(obj instanceof un.c)) {
                throw new IllegalArgumentException(c0.a.a("Type parameter container must be a class or a callable: ", obj));
            }
            typeParameters = ((un.c) obj).getTypeParameters();
        }
        for (un.t tVar : typeParameters) {
            if (tVar.getName().equals(str)) {
                return tVar;
            }
        }
        throw new IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }
}
