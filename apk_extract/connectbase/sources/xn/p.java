package xn;

import eo.h1;
import eo.q0;
import eo.w0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements un.n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f20397f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final f<?> f20398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final un.n.b f20400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final a0.a f20401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final a0.a f20402e;

    public static final class a extends n0 implements jn.a<List<? extends Annotation>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        public final List<? extends Annotation> invoke() {
            return h0.e(p.this.s());
        }
    }

    public static final class b extends n0 implements jn.a<Type> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Type invoke() {
            q0 q0VarS = p.this.s();
            if (!(q0VarS instanceof w0) || !l0.g(h0.i(p.this.f20398a.L()), q0VarS) || p.this.f20398a.L().getKind() != eo.b.a.FAKE_OVERRIDE) {
                return p.this.f20398a.F().a().get(p.this.f20399b);
            }
            Class<?> clsP = h0.p((eo.e) p.this.f20398a.L().b());
            if (clsP != null) {
                return clsP;
            }
            throw new y(l0.C("Cannot determine receiver Java type of inherited declaration: ", q0VarS));
        }
    }

    static {
        g1 g1Var = new g1(l1.d(p.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;");
        m1 m1Var = l1.f9319a;
        f20397f = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(p.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public p(@os.l f<?> fVar, int i10, @os.l un.n.b bVar, @os.l jn.a<? extends q0> aVar) {
        l0.p(fVar, "callable");
        l0.p(bVar, "kind");
        l0.p(aVar, "computeDescriptor");
        this.f20398a = fVar;
        this.f20399b = i10;
        this.f20400c = bVar;
        this.f20401d = a0.d(aVar);
        this.f20402e = a0.d(new a());
    }

    @Override // un.n
    public boolean b() {
        q0 q0VarS = s();
        return (q0VarS instanceof h1) && ((h1) q0VarS).s0() != null;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (l0.g(this.f20398a, pVar.f20398a) && this.f20399b == pVar.f20399b) {
                return true;
            }
        }
        return false;
    }

    @Override // un.n
    public int f() {
        return this.f20399b;
    }

    @Override // un.b
    @os.l
    public List<Annotation> getAnnotations() {
        a0.a aVar = this.f20402e;
        un.o<Object> oVar = f20397f[1];
        Object objInvoke = aVar.invoke();
        l0.o(objInvoke, "<get-annotations>(...)");
        return (List) objInvoke;
    }

    @Override // un.n
    @os.l
    public un.n.b getKind() {
        return this.f20400c;
    }

    @Override // un.n
    @os.m
    public String getName() {
        q0 q0VarS = s();
        h1 h1Var = q0VarS instanceof h1 ? (h1) q0VarS : null;
        if (h1Var == null || h1Var.b().e0()) {
            return null;
        }
        dp.f name = h1Var.getName();
        l0.o(name, "valueParameter.name");
        if (name.f3821b) {
            return null;
        }
        return name.b();
    }

    @Override // un.n
    @os.l
    public un.s getType() {
        vp.f0 type = s().getType();
        l0.o(type, "descriptor.type");
        return new v(type, new b());
    }

    public int hashCode() {
        return Integer.valueOf(this.f20399b).hashCode() + (this.f20398a.hashCode() * 31);
    }

    @os.l
    public final f<?> m() {
        return this.f20398a;
    }

    public final q0 s() {
        a0.a aVar = this.f20401d;
        un.o<Object> oVar = f20397f[0];
        Object objInvoke = aVar.invoke();
        l0.o(objInvoke, "<get-descriptor>(...)");
        return (q0) objInvoke;
    }

    @os.l
    public String toString() {
        return c0.f20308a.f(this);
    }

    @Override // un.n
    public boolean z() {
        q0 q0VarS = s();
        h1 h1Var = q0VarS instanceof h1 ? (h1) q0VarS : null;
        if (h1Var == null) {
            return false;
        }
        return lp.a.a(h1Var);
    }
}
