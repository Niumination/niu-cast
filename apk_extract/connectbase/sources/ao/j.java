package ao;

import eo.e1;
import eo.h0;
import eo.j0;
import eo.x;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import kn.w;
import lm.d0;
import vp.f0;
import vp.g0;
import vp.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final b f540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f541l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j0 f542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final d0 f543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final a f544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final a f545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final a f546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final a f547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final a f548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final a f549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final a f550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final a f551j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f552a;

        public a(int i10) {
            this.f552a = i10;
        }

        @os.l
        public final eo.e a(@os.l j jVar, @os.l un.o<?> oVar) {
            l0.p(jVar, "types");
            l0.p(oVar, "property");
            return jVar.b(cq.a.a(oVar.getName()), this.f552a);
        }
    }

    public static final class b {
        public b() {
        }

        @os.m
        public final f0 a(@os.l h0 h0Var) {
            l0.p(h0Var, "module");
            eo.e eVarA = x.a(h0Var, k.a.f598n0);
            if (eVarA == null) {
                return null;
            }
            fo.g.f6167h.getClass();
            fo.g gVar = fo.g.a.f6169b;
            List<e1> parameters = eVarA.i().getParameters();
            l0.o(parameters, "kPropertyClass.typeConstructor.parameters");
            Object objH5 = nm.h0.h5(parameters);
            l0.o(objH5, "kPropertyClass.typeConstructor.parameters.single()");
            return g0.g(gVar, eVarA, nm.x.k(new s0((e1) objH5)));
        }

        public b(w wVar) {
        }
    }

    public static final class c extends n0 implements jn.a<op.h> {
        final /* synthetic */ h0 $module;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h0 h0Var) {
            super(0);
            this.$module = h0Var;
        }

        @Override // jn.a
        @os.l
        public final op.h invoke() {
            return this.$module.o0(k.f562j).o();
        }
    }

    static {
        g1 g1Var = new g1(l1.d(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;");
        m1 m1Var = l1.f9319a;
        f541l = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), m1Var.n(new g1(m1Var.d(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), m1Var.n(new g1(m1Var.d(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), m1Var.n(new g1(m1Var.d(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), m1Var.n(new g1(m1Var.d(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), m1Var.n(new g1(m1Var.d(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), m1Var.n(new g1(m1Var.d(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
        f540k = new b();
    }

    public j(@os.l h0 h0Var, @os.l j0 j0Var) {
        l0.p(h0Var, "module");
        l0.p(j0Var, "notFoundClasses");
        this.f542a = j0Var;
        this.f543b = lm.f0.c(lm.h0.PUBLICATION, new c(h0Var));
        this.f544c = new a(1);
        this.f545d = new a(1);
        this.f546e = new a(1);
        this.f547f = new a(2);
        this.f548g = new a(3);
        this.f549h = new a(1);
        this.f550i = new a(2);
        this.f551j = new a(3);
    }

    public final eo.e b(String str, int i10) {
        dp.f fVarK = dp.f.k(str);
        l0.o(fVarK, "identifier(className)");
        eo.h hVarF = d().f(fVarK, mo.d.FROM_REFLECTION);
        eo.e eVar = hVarF instanceof eo.e ? (eo.e) hVarF : null;
        return eVar == null ? this.f542a.d(new dp.b(k.f562j, fVarK), nm.x.k(Integer.valueOf(i10))) : eVar;
    }

    @os.l
    public final eo.e c() {
        return this.f544c.a(this, f541l[0]);
    }

    public final op.h d() {
        return (op.h) this.f543b.getValue();
    }
}
