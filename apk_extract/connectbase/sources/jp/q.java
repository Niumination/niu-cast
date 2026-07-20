package jp;

import eo.e1;
import ik.y0;
import kn.l0;
import lm.i0;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.h0;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends g<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f8791b = new a();

    public static final class a {
        public a() {
        }

        @os.m
        public final g<?> a(@os.l f0 f0Var) {
            l0.p(f0Var, "argumentType");
            if (h0.a(f0Var)) {
                return null;
            }
            int i10 = 0;
            f0 type = f0Var;
            while (ao.h.c0(type)) {
                type = ((c1) nm.h0.h5(type.F0())).getType();
                l0.o(type, "type.arguments.single().type");
                i10++;
            }
            eo.h hVarD = type.G0().d();
            if (hVarD instanceof eo.e) {
                dp.b bVarH = lp.a.h(hVarD);
                return bVarH == null ? new q(new b.a(f0Var)) : new q(bVarH, i10);
            }
            if (!(hVarD instanceof e1)) {
                return null;
            }
            dp.b bVarM = dp.b.m(ao.k.a.f573b.l());
            l0.o(bVarM, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new q(bVarM, 0);
        }

        public a(kn.w wVar) {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final f0 f8792a;

            public a(@os.l f0 f0Var) {
                l0.p(f0Var, y0.a.f8215h);
                this.f8792a = f0Var;
            }

            @os.l
            public final f0 a() {
                return this.f8792a;
            }

            public boolean equals(@os.m Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && l0.g(this.f8792a, ((a) obj).f8792a);
            }

            public int hashCode() {
                return this.f8792a.hashCode();
            }

            @os.l
            public String toString() {
                return "LocalClass(type=" + this.f8792a + ')';
            }
        }

        /* JADX INFO: renamed from: jp.q$b$b, reason: collision with other inner class name */
        public static final class C0228b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final f f8793a;

            public C0228b(@os.l f fVar) {
                l0.p(fVar, "value");
                this.f8793a = fVar;
            }

            public final int a() {
                return this.f8793a.f8773b;
            }

            @os.l
            public final dp.b b() {
                return this.f8793a.f8772a;
            }

            @os.l
            public final f c() {
                return this.f8793a;
            }

            public boolean equals(@os.m Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0228b) && l0.g(this.f8793a, ((C0228b) obj).f8793a);
            }

            public int hashCode() {
                return this.f8793a.hashCode();
            }

            @os.l
            public String toString() {
                return "NormalClass(value=" + this.f8793a + ')';
            }
        }

        public b() {
        }

        public b(kn.w wVar) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.l b bVar) {
        super(bVar);
        l0.p(bVar, "value");
    }

    @Override // jp.g
    @os.l
    public f0 a(@os.l eo.h0 h0Var) {
        l0.p(h0Var, "module");
        fo.g.f6167h.getClass();
        fo.g gVar = fo.g.a.f6169b;
        eo.e eVarE = h0Var.n().E();
        l0.o(eVarE, "module.builtIns.kClass");
        return g0.g(gVar, eVarE, nm.x.k(new vp.e1(c(h0Var))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public final f0 c(@os.l eo.h0 h0Var) {
        l0.p(h0Var, "module");
        T t10 = this.f8774a;
        b bVar = (b) t10;
        if (bVar instanceof b.a) {
            return ((b.a) t10).f8792a;
        }
        if (!(bVar instanceof b.C0228b)) {
            throw new i0();
        }
        f fVar = ((b.C0228b) t10).f8793a;
        dp.b bVar2 = fVar.f8772a;
        int i10 = fVar.f8773b;
        eo.e eVarA = eo.x.a(h0Var, bVar2);
        if (eVarA == null) {
            n0 n0VarJ = vp.x.j("Unresolved type: " + bVar2 + " (arrayDimensions=" + i10 + ')');
            l0.o(n0VarJ, "createErrorType(\"Unresol…sions=$arrayDimensions)\")");
            return n0VarJ;
        }
        n0 n0VarQ = eVarA.q();
        l0.o(n0VarQ, "descriptor.defaultType");
        f0 f0VarT = zp.a.t(n0VarQ);
        int i11 = 0;
        while (i11 < i10) {
            i11++;
            f0VarT = h0Var.n().l(o1.INVARIANT, f0VarT);
            l0.o(f0VarT, "module.builtIns.getArray…Variance.INVARIANT, type)");
        }
        return f0VarT;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(@os.l f fVar) {
        this(new b.C0228b(fVar));
        l0.p(fVar, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(@os.l dp.b bVar, int i10) {
        this(new f(bVar, i10));
        l0.p(bVar, "classId");
    }
}
