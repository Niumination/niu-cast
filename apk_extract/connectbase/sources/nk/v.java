package nk;

import fl.r1;
import ik.j0;
import ik.r0;
import jq.e0;
import kn.l0;
import kn.n0;
import lm.f0;
import lm.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends s.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final s.d f11552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final String f11553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final lm.d0 f11554d;

    public static final class a extends n0 implements jn.a<ik.b0> {

        /* JADX INFO: renamed from: nk.v$a$a, reason: collision with other inner class name */
        public static final class C0296a extends n0 implements jn.p<String, String, Boolean> {
            public static final C0296a INSTANCE = new C0296a();

            public C0296a() {
                super(2);
            }

            @Override // jn.p
            @os.l
            public final Boolean invoke(@os.l String str, @os.l String str2) {
                l0.p(str, "name");
                l0.p(str2, "$noName_1");
                j0.f8048a.getClass();
                return Boolean.valueOf(!e0.K1(str, j0.f8080q, true));
            }
        }

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final ik.b0 invoke() {
            v vVar = v.this;
            if (vVar.f11553c == null) {
                return vVar.f11552b.e();
            }
            ik.b0.a aVar = ik.b0.f7939b;
            ik.c0 c0Var = new ik.c0(0, 1, null);
            r1.e(c0Var, vVar.f11552b.e(), false, C0296a.INSTANCE, 2, null);
            j0.f8048a.getClass();
            c0Var.a(j0.f8076o, vVar.f11553c);
            return c0Var.f();
        }
    }

    public v(@os.l s.d dVar, @os.m String str) {
        l0.p(dVar, "original");
        this.f11552b = dVar;
        this.f11553c = str;
        this.f11554d = f0.c(h0.NONE, new a());
    }

    @Override // nk.s
    @os.m
    public Long b() {
        return this.f11552b.b();
    }

    @Override // nk.s
    @os.m
    public ik.i c() {
        return this.f11552b.c();
    }

    @Override // nk.s
    @os.l
    public ik.b0 e() {
        return (ik.b0) this.f11554d.getValue();
    }

    @Override // nk.s
    @os.m
    public <T> T f(@os.l fl.b<T> bVar) {
        l0.p(bVar, cb.b.c.f1408o);
        return (T) this.f11552b.f(bVar);
    }

    @Override // nk.s
    @os.m
    public r0 g() {
        return this.f11552b.g();
    }

    @Override // nk.s
    public <T> void i(@os.l fl.b<T> bVar, @os.m T t10) {
        l0.p(bVar, cb.b.c.f1408o);
        this.f11552b.i(bVar, t10);
    }

    @Override // nk.s.d
    @os.l
    public pl.k j() {
        return this.f11552b.j();
    }

    @Override // nk.s.d
    @os.l
    public pl.k k(@os.l tn.o oVar) {
        l0.p(oVar, "range");
        return this.f11552b.k(oVar);
    }

    @os.m
    public final String l() {
        return this.f11553c;
    }

    @os.l
    public final s.d m() {
        return this.f11552b;
    }
}
