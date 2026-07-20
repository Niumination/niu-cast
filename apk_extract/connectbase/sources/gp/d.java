package gp;

import eo.d1;
import eo.e1;
import eo.f1;
import eo.h0;
import eo.h1;
import eo.j1;
import eo.k0;
import eo.o;
import eo.p;
import eo.p0;
import eo.r0;
import eo.s0;
import eo.t;
import eo.t0;
import eo.u;
import eo.u0;
import eo.v0;
import eo.w;
import eo.w0;
import eo.y;
import ik.y0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.q;
import jq.j0;
import jq.m0;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.i0;
import lm.l2;
import nm.p1;
import nm.x;
import nm.z;
import vp.a1;
import vp.c1;
import vp.e0;
import vp.f0;
import vp.m1;
import vp.n1;
import vp.o1;
import vp.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends gp.c implements gp.f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public final gp.g f6774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public final d0 f6775m;

    public final class a implements o<l2, StringBuilder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f6776a;

        /* JADX INFO: renamed from: gp.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0185a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6777a;

            static {
                int[] iArr = new int[l.values().length];
                iArr[l.PRETTY.ordinal()] = 1;
                iArr[l.DEBUG.ordinal()] = 2;
                iArr[l.NONE.ordinal()] = 3;
                f6777a = iArr;
            }
        }

        public a(d dVar) {
            l0.p(dVar, "this$0");
            this.f6776a = dVar;
        }

        public void A(@os.l h1 h1Var, @os.l StringBuilder sb2) {
            l0.p(h1Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.T1(h1Var, true, sb2, true);
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 a(p0 p0Var, StringBuilder sb2) {
            s(p0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 b(t0 t0Var, StringBuilder sb2) throws IOException {
            u(t0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 c(eo.l lVar, StringBuilder sb2) throws IOException {
            o(lVar, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 d(k0 k0Var, StringBuilder sb2) {
            r(k0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 e(u0 u0Var, StringBuilder sb2) throws IOException {
            v(u0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 f(h0 h0Var, StringBuilder sb2) {
            q(h0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 g(w0 w0Var, StringBuilder sb2) {
            x(w0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 h(e1 e1Var, StringBuilder sb2) {
            z(e1Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 i(d1 d1Var, StringBuilder sb2) {
            y(d1Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 j(v0 v0Var, StringBuilder sb2) throws IOException {
            w(v0Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 k(h1 h1Var, StringBuilder sb2) {
            A(h1Var, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 l(eo.e eVar, StringBuilder sb2) throws IOException {
            n(eVar, sb2);
            return l2.f10208a;
        }

        @Override // eo.o
        public /* bridge */ /* synthetic */ l2 m(y yVar, StringBuilder sb2) throws IOException {
            p(yVar, sb2);
            return l2.f10208a;
        }

        public void n(@os.l eo.e eVar, @os.l StringBuilder sb2) throws IOException {
            l0.p(eVar, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.a1(eVar, sb2);
        }

        public void o(@os.l eo.l lVar, @os.l StringBuilder sb2) throws IOException {
            l0.p(lVar, "constructorDescriptor");
            l0.p(sb2, "builder");
            this.f6776a.f1(lVar, sb2);
        }

        public void p(@os.l y yVar, @os.l StringBuilder sb2) throws IOException {
            l0.p(yVar, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.j1(yVar, sb2);
        }

        public void q(@os.l h0 h0Var, @os.l StringBuilder sb2) {
            l0.p(h0Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.t1(h0Var, sb2, true);
        }

        public void r(@os.l k0 k0Var, @os.l StringBuilder sb2) {
            l0.p(k0Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.x1(k0Var, sb2);
        }

        public void s(@os.l p0 p0Var, @os.l StringBuilder sb2) {
            l0.p(p0Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.z1(p0Var, sb2);
        }

        public final void t(s0 s0Var, StringBuilder sb2, String str) throws IOException {
            int i10 = C0185a.f6777a[this.f6776a.f6774l.N().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return;
                }
                p(s0Var, sb2);
            } else {
                this.f6776a.o1(s0Var, sb2);
                sb2.append(l0.C(str, " for "));
                d dVar = this.f6776a;
                t0 t0VarW = s0Var.W();
                l0.o(t0VarW, "descriptor.correspondingProperty");
                dVar.B1(t0VarW, sb2);
            }
        }

        public void u(@os.l t0 t0Var, @os.l StringBuilder sb2) throws IOException {
            l0.p(t0Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.B1(t0Var, sb2);
        }

        public void v(@os.l u0 u0Var, @os.l StringBuilder sb2) throws IOException {
            l0.p(u0Var, "descriptor");
            l0.p(sb2, "builder");
            t(u0Var, sb2, "getter");
        }

        public void w(@os.l v0 v0Var, @os.l StringBuilder sb2) throws IOException {
            l0.p(v0Var, "descriptor");
            l0.p(sb2, "builder");
            t(v0Var, sb2, "setter");
        }

        public void x(@os.l w0 w0Var, @os.l StringBuilder sb2) {
            l0.p(w0Var, "descriptor");
            l0.p(sb2, "builder");
            sb2.append(w0Var.getName());
        }

        public void y(@os.l d1 d1Var, @os.l StringBuilder sb2) {
            l0.p(d1Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.J1(d1Var, sb2);
        }

        public void z(@os.l e1 e1Var, @os.l StringBuilder sb2) {
            l0.p(e1Var, "descriptor");
            l0.p(sb2, "builder");
            this.f6776a.O1(e1Var, sb2, true);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6779b;

        static {
            int[] iArr = new int[m.values().length];
            iArr[m.PLAIN.ordinal()] = 1;
            iArr[m.HTML.ordinal()] = 2;
            f6778a = iArr;
            int[] iArr2 = new int[k.values().length];
            iArr2[k.ALL.ordinal()] = 1;
            iArr2[k.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[k.NONE.ordinal()] = 3;
            f6779b = iArr2;
        }
    }

    public static final class c extends n0 implements jn.l<c1, CharSequence> {
        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l c1 c1Var) {
            l0.p(c1Var, "it");
            if (c1Var.a()) {
                return "*";
            }
            d dVar = d.this;
            f0 type = c1Var.getType();
            l0.o(type, "it.type");
            String strY = dVar.y(type);
            if (c1Var.c() == o1.INVARIANT) {
                return strY;
            }
            return c1Var.c() + ' ' + strY;
        }
    }

    /* JADX INFO: renamed from: gp.d$d, reason: collision with other inner class name */
    public static final class C0186d extends n0 implements jn.a<d> {

        /* JADX INFO: renamed from: gp.d$d$a */
        public static final class a extends n0 implements jn.l<gp.f, l2> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(gp.f fVar) {
                invoke2(fVar);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l gp.f fVar) {
                l0.p(fVar, "$this$withOptions");
                fVar.k(p1.D(fVar.g(), x.k(ao.k.a.C)));
            }
        }

        public C0186d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final d invoke() {
            return (d) d.this.A(a.INSTANCE);
        }
    }

    public static final class e extends n0 implements jn.l<jp.g<?>, CharSequence> {
        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l jp.g<?> gVar) {
            l0.p(gVar, "it");
            return d.this.e1(gVar);
        }
    }

    public static final class f extends n0 implements jn.l<h1, CharSequence> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(h1 h1Var) {
            return "";
        }
    }

    public static final class g extends n0 implements jn.l<f0, CharSequence> {
        public g() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(f0 f0Var) {
            d dVar = d.this;
            l0.o(f0Var, "it");
            return dVar.y(f0Var);
        }
    }

    public static final class h extends n0 implements jn.l<f0, Object> {
        public static final h INSTANCE = new h();

        public h() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Object invoke(@os.l f0 f0Var) {
            l0.p(f0Var, "it");
            return f0Var instanceof vp.u0 ? ((vp.u0) f0Var).f17681b : f0Var;
        }
    }

    public d(@os.l gp.g gVar) {
        l0.p(gVar, "options");
        this.f6774l = gVar;
        boolean z10 = gVar.f6781a;
        this.f6775m = lm.f0.b(new C0186d());
    }

    public static final void B(d dVar, s0 s0Var, StringBuilder sb2) {
        dVar.o1(s0Var, sb2);
    }

    public static /* synthetic */ void N1(d dVar, StringBuilder sb2, f0 f0Var, a1 a1Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            a1Var = f0Var.G0();
        }
        dVar.M1(sb2, f0Var, a1Var);
    }

    public static /* synthetic */ void S1(d dVar, j1 j1Var, StringBuilder sb2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        dVar.R1(j1Var, sb2, z10);
    }

    public static /* synthetic */ void Y0(d dVar, StringBuilder sb2, fo.a aVar, fo.e eVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            eVar = null;
        }
        dVar.X0(sb2, aVar, eVar);
    }

    public boolean A0() {
        return this.f6774l.Z();
    }

    public final void A1(StringBuilder sb2, r0 r0Var) {
        StringBuilder sb3;
        r0 r0Var2 = r0Var.f4628c;
        if (r0Var2 == null) {
            sb3 = null;
        } else {
            A1(sb2, r0Var2);
            sb2.append(n1.e.f11183c);
            dp.f name = r0Var.f4626a.getName();
            l0.o(name, "possiblyInnerType.classifierDescriptor.name");
            sb2.append(x(name, false));
            sb3 = sb2;
        }
        if (sb3 == null) {
            a1 a1VarI = r0Var.f4626a.i();
            l0.o(a1VarI, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb2.append(L1(a1VarI));
        }
        sb2.append(K1(r0Var.f4627b));
    }

    public boolean B0() {
        return this.f6774l.a0();
    }

    public final void B1(t0 t0Var, StringBuilder sb2) throws IOException {
        if (!this.f6774l.a0()) {
            if (!this.f6774l.Z()) {
                C1(t0Var, sb2);
                u visibility = t0Var.getVisibility();
                l0.o(visibility, "property.visibility");
                W1(visibility, sb2);
                boolean z10 = false;
                s1(sb2, this.f6774l.H().contains(gp.e.CONST) && t0Var.isConst(), "const");
                o1(t0Var, sb2);
                r1(t0Var, sb2);
                w1(t0Var, sb2);
                if (this.f6774l.H().contains(gp.e.LATEINIT) && t0Var.u0()) {
                    z10 = true;
                }
                s1(sb2, z10, "lateinit");
                n1(t0Var, sb2);
            }
            S1(this, t0Var, sb2, false, 4, null);
            List<e1> typeParameters = t0Var.getTypeParameters();
            l0.o(typeParameters, "property.typeParameters");
            Q1(typeParameters, sb2, true);
            D1(t0Var, sb2);
        }
        t1(t0Var, sb2, true);
        sb2.append(": ");
        f0 type = t0Var.getType();
        l0.o(type, "property.type");
        sb2.append(y(type));
        E1(t0Var, sb2);
        l1(t0Var, sb2);
        List<e1> typeParameters2 = t0Var.getTypeParameters();
        l0.o(typeParameters2, "property.typeParameters");
        X1(typeParameters2, sb2);
    }

    @os.l
    public m C0() {
        return this.f6774l.b0();
    }

    public final void C1(t0 t0Var, StringBuilder sb2) {
        if (this.f6774l.H().contains(gp.e.ANNOTATIONS)) {
            Y0(this, sb2, t0Var, null, 2, null);
            w wVarT0 = t0Var.t0();
            if (wVarT0 != null) {
                X0(sb2, wVarT0, fo.e.FIELD);
            }
            w wVarS = t0Var.S();
            if (wVarS != null) {
                X0(sb2, wVarS, fo.e.PROPERTY_DELEGATE_FIELD);
            }
            if (this.f6774l.N() == l.NONE) {
                u0 getter = t0Var.getGetter();
                if (getter != null) {
                    X0(sb2, getter, fo.e.PROPERTY_GETTER);
                }
                v0 setter = t0Var.getSetter();
                if (setter == null) {
                    return;
                }
                X0(sb2, setter, fo.e.PROPERTY_SETTER);
                List<h1> listH = setter.h();
                l0.o(listH, "setter.valueParameters");
                h1 h1Var = (h1) nm.h0.h5(listH);
                l0.o(h1Var, "it");
                X0(sb2, h1Var, fo.e.SETTER_PARAMETER);
            }
        }
    }

    @os.l
    public jn.l<f0, f0> D0() {
        return this.f6774l.c0();
    }

    public final void D1(eo.a aVar, StringBuilder sb2) {
        w0 w0VarR = aVar.R();
        if (w0VarR != null) {
            X0(sb2, w0VarR, fo.e.RECEIVER);
            f0 type = w0VarR.getType();
            l0.o(type, "receiver.type");
            String strY = y(type);
            if (Z1(type) && !vp.j1.m(type)) {
                strY = "(" + strY + ')';
            }
            sb2.append(strY);
            sb2.append(".");
        }
    }

    public boolean E0() {
        return this.f6774l.d0();
    }

    public final void E1(eo.a aVar, StringBuilder sb2) {
        w0 w0VarR;
        if (this.f6774l.O() && (w0VarR = aVar.R()) != null) {
            sb2.append(" on ");
            f0 type = w0VarR.getType();
            l0.o(type, "receiver.type");
            sb2.append(y(type));
        }
    }

    public boolean F0() {
        return this.f6774l.e0();
    }

    public final void F1(StringBuilder sb2, vp.n0 n0Var) {
        if (l0.g(n0Var, vp.j1.f17712b) || vp.j1.l(n0Var)) {
            sb2.append("???");
            return;
        }
        if (vp.x.t(n0Var)) {
            if (!this.f6774l.d0()) {
                sb2.append("???");
                return;
            }
            String str = ((vp.x.f) n0Var.G0()).g().getName().f3820a;
            l0.o(str, "type.constructor as Unin…escriptor.name.toString()");
            sb2.append(h1(str));
            return;
        }
        if (vp.h0.a(n0Var)) {
            g1(sb2, n0Var);
        } else if (Z1(n0Var)) {
            k1(sb2, n0Var);
        } else {
            g1(sb2, n0Var);
        }
    }

    @os.l
    public gp.c.l G0() {
        return this.f6774l.f0();
    }

    public final void G1(StringBuilder sb2) {
        int length = sb2.length();
        if (length == 0 || sb2.charAt(length - 1) != ' ') {
            sb2.append(' ');
        }
    }

    public boolean H0() {
        return this.f6774l.g0();
    }

    public final void H1(eo.e eVar, StringBuilder sb2) throws IOException {
        if (this.f6774l.k0() || ao.h.l0(eVar.q())) {
            return;
        }
        Collection<f0> collectionA = eVar.i().a();
        l0.o(collectionA, "klass.typeConstructor.supertypes");
        if (collectionA.isEmpty()) {
            return;
        }
        if (collectionA.size() == 1 && ao.h.b0(collectionA.iterator().next())) {
            return;
        }
        G1(sb2);
        sb2.append(": ");
        nm.h0.j3(collectionA, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : new g());
    }

    public boolean I0() {
        return this.f6774l.h0();
    }

    public final void I1(y yVar, StringBuilder sb2) {
        s1(sb2, yVar.isSuspend(), "suspend");
    }

    public boolean J0() {
        return this.f6774l.i0();
    }

    public final void J1(d1 d1Var, StringBuilder sb2) {
        Y0(this, sb2, d1Var, null, 2, null);
        u visibility = d1Var.getVisibility();
        l0.o(visibility, "typeAlias.visibility");
        W1(visibility, sb2);
        o1(d1Var, sb2);
        sb2.append(m1("typealias"));
        sb2.append(" ");
        t1(d1Var, sb2, true);
        List<e1> listR = d1Var.r();
        l0.o(listR, "typeAlias.declaredTypeParameters");
        Q1(listR, sb2, false);
        Z0(d1Var, sb2);
        sb2.append(" = ");
        sb2.append(y(d1Var.r0()));
    }

    public boolean K0() {
        return this.f6774l.j0();
    }

    @os.l
    public String K1(@os.l List<? extends c1> list) throws IOException {
        l0.p(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(R("<"));
        O(sb2, list);
        sb2.append(R(">"));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean L0() {
        return this.f6774l.k0();
    }

    @os.l
    public String L1(@os.l a1 a1Var) {
        l0.p(a1Var, "typeConstructor");
        eo.h hVarD = a1Var.d();
        if (hVarD instanceof e1 ? true : hVarD instanceof eo.e ? true : hVarD instanceof d1) {
            return c1(hVarD);
        }
        if (hVarD == null) {
            return a1Var instanceof e0 ? ((e0) a1Var).i(h.INSTANCE) : a1Var.toString();
        }
        throw new IllegalStateException(l0.C("Unexpected classifier: ", hVarD.getClass()).toString());
    }

    public boolean M0() {
        return this.f6774l.l0();
    }

    public final void M1(StringBuilder sb2, f0 f0Var, a1 a1Var) {
        r0 r0VarA = f1.a(f0Var);
        if (r0VarA != null) {
            A1(sb2, r0VarA);
        } else {
            sb2.append(L1(a1Var));
            sb2.append(K1(f0Var.F0()));
        }
    }

    public final void N(StringBuilder sb2, eo.m mVar) {
        eo.m mVarB;
        String name;
        if ((mVar instanceof k0) || (mVar instanceof p0) || (mVarB = mVar.b()) == null || (mVarB instanceof h0)) {
            return;
        }
        sb2.append(" ");
        sb2.append(p1("defined in"));
        sb2.append(" ");
        dp.d dVarM = hp.d.m(mVarB);
        l0.o(dVarM, "getFqName(containingDeclaration)");
        sb2.append(dVarM.f3815a.isEmpty() ? "root package" : w(dVarM));
        if (this.f6774l.i0() && (mVarB instanceof k0) && (mVar instanceof p) && (name = ((p) mVar).getSource().b().getName()) != null) {
            sb2.append(" ");
            sb2.append(p1("in file"));
            sb2.append(" ");
            sb2.append(name);
        }
    }

    public final String N0() {
        return R(">");
    }

    public final void O(StringBuilder sb2, List<? extends c1> list) throws IOException {
        nm.h0.j3(list, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : new c());
    }

    public final boolean O0(f0 f0Var) {
        return ao.g.o(f0Var) || !f0Var.getAnnotations().isEmpty();
    }

    public final void O1(e1 e1Var, StringBuilder sb2, boolean z10) {
        if (z10) {
            sb2.append(R("<"));
        }
        if (this.f6774l.g0()) {
            sb2.append("/*");
            sb2.append(e1Var.f());
            sb2.append("*/ ");
        }
        s1(sb2, e1Var.j(), "reified");
        String label = e1Var.m().getLabel();
        boolean z11 = true;
        s1(sb2, label.length() > 0, label);
        Y0(this, sb2, e1Var, null, 2, null);
        t1(e1Var, sb2, z10);
        int size = e1Var.getUpperBounds().size();
        if ((size > 1 && !z10) || size == 1) {
            f0 next = e1Var.getUpperBounds().iterator().next();
            if (!ao.h.h0(next)) {
                sb2.append(" : ");
                l0.o(next, "upperBound");
                sb2.append(y(next));
            }
        } else if (z10) {
            for (f0 f0Var : e1Var.getUpperBounds()) {
                if (!ao.h.h0(f0Var)) {
                    if (z11) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    l0.o(f0Var, "upperBound");
                    sb2.append(y(f0Var));
                    z11 = false;
                }
            }
        }
        if (z10) {
            sb2.append(R(">"));
        }
    }

    public final String P() {
        int i10 = b.f6778a[this.f6774l.b0().ordinal()];
        if (i10 == 1) {
            return R("->");
        }
        if (i10 == 2) {
            return "&rarr;";
        }
        throw new i0();
    }

    public final eo.e0 P0(eo.d0 d0Var) {
        if (d0Var instanceof eo.e) {
            return ((eo.e) d0Var).getKind() == eo.f.INTERFACE ? eo.e0.ABSTRACT : eo.e0.FINAL;
        }
        eo.m mVarB = d0Var.b();
        eo.e eVar = mVarB instanceof eo.e ? (eo.e) mVarB : null;
        if (eVar != null && (d0Var instanceof eo.b)) {
            eo.b bVar = (eo.b) d0Var;
            Collection<? extends eo.b> collectionD = bVar.d();
            l0.o(collectionD, "this.overriddenDescriptors");
            if (!collectionD.isEmpty() && eVar.s() != eo.e0.FINAL) {
                return eo.e0.OPEN;
            }
            if (eVar.getKind() != eo.f.INTERFACE || l0.g(bVar.getVisibility(), t.f4629a)) {
                return eo.e0.FINAL;
            }
            eo.e0 e0VarS = bVar.s();
            eo.e0 e0Var = eo.e0.ABSTRACT;
            return e0VarS == e0Var ? e0Var : eo.e0.OPEN;
        }
        return eo.e0.FINAL;
    }

    public final void P1(StringBuilder sb2, List<? extends e1> list) {
        Iterator<? extends e1> it = list.iterator();
        while (it.hasNext()) {
            O1(it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
    }

    public final boolean Q(String str, String str2) {
        if (!l0.g(str, jq.e0.i2(str2, "?", "", false, 4, null)) && (!jq.e0.J1(str2, "?", false, 2, null) || !l0.g(l0.C(str, "?"), str2))) {
            if (!l0.g("(" + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean Q0(fo.c cVar) {
        return l0.g(cVar.e(), ao.k.a.D);
    }

    public final void Q1(List<? extends e1> list, StringBuilder sb2, boolean z10) {
        if (this.f6774l.l0() || list.isEmpty()) {
            return;
        }
        sb2.append(R("<"));
        P1(sb2, list);
        sb2.append(R(">"));
        if (z10) {
            sb2.append(" ");
        }
    }

    public final String R(String str) {
        return this.f6774l.b0().escape(str);
    }

    public final String R0() {
        return R("<");
    }

    public final void R1(j1 j1Var, StringBuilder sb2, boolean z10) {
        if (z10 || !(j1Var instanceof h1)) {
            sb2.append(m1(j1Var.Q() ? "var" : "val"));
            sb2.append(" ");
        }
    }

    public boolean S() {
        return this.f6774l.t();
    }

    public final boolean S0(eo.b bVar) {
        return !bVar.d().isEmpty();
    }

    public boolean T() {
        return this.f6774l.u();
    }

    public final void T0(StringBuilder sb2, vp.a aVar) {
        m mVarB0 = this.f6774l.b0();
        m mVar = m.HTML;
        if (mVarB0 == mVar) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* = ");
        v1(sb2, aVar.f17659b);
        sb2.append(" */");
        if (this.f6774l.b0() == mVar) {
            sb2.append("</i></font>");
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0065  */
    public final void T1(h1 h1Var, boolean z10, StringBuilder sb2, boolean z11) {
        boolean z12;
        if (z11) {
            sb2.append(m1("value-parameter"));
            sb2.append(" ");
        }
        if (this.f6774l.g0()) {
            sb2.append("/*");
            sb2.append(h1Var.f());
            sb2.append("*/ ");
        }
        Y0(this, sb2, h1Var, null, 2, null);
        s1(sb2, h1Var.p0(), "crossinline");
        s1(sb2, h1Var.n0(), "noinline");
        boolean z13 = false;
        if (this.f6774l.V()) {
            eo.a aVarB = h1Var.b();
            eo.d dVar = aVarB instanceof eo.d ? (eo.d) aVarB : null;
            if (dVar != null && dVar.b0()) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            z12 = false;
        }
        if (z12) {
            s1(sb2, this.f6774l.t(), "actual");
        }
        V1(h1Var, z10, sb2, z11, z12);
        if (this.f6774l.z() != null) {
            if (this.f6774l.h() ? h1Var.w0() : lp.a.a(h1Var)) {
                z13 = true;
            }
        }
        if (z13) {
            jn.l<h1, String> lVarZ = this.f6774l.z();
            l0.m(lVarZ);
            sb2.append(l0.C(" = ", lVarZ.invoke(h1Var)));
        }
    }

    @os.m
    public jn.l<fo.c, Boolean> U() {
        return this.f6774l.v();
    }

    public final void U0(s0 s0Var, StringBuilder sb2) {
        o1(s0Var, sb2);
    }

    public final void U1(Collection<? extends h1> collection, boolean z10, StringBuilder sb2) {
        boolean zA2 = a2(z10);
        int size = collection.size();
        this.f6774l.f0().b(size, sb2);
        int i10 = 0;
        for (h1 h1Var : collection) {
            this.f6774l.f0().a(h1Var, i10, size, sb2);
            T1(h1Var, zA2, sb2, false);
            this.f6774l.f0().c(h1Var, i10, size, sb2);
            i10++;
        }
        this.f6774l.f0().d(size, sb2);
    }

    public boolean V() {
        return this.f6774l.w();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    public final void V0(y yVar, StringBuilder sb2) {
        boolean z10;
        boolean z11 = false;
        if (yVar.isOperator()) {
            Collection<? extends y> collectionD = yVar.d();
            l0.o(collectionD, "functionDescriptor.overriddenDescriptors");
            Collection<? extends y> collection = collectionD;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((y) it.next()).isOperator()) {
                            if (!this.f6774l.u()) {
                                z10 = false;
                            }
                        }
                    }
                }
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (yVar.isInfix()) {
            Collection<? extends y> collectionD2 = yVar.d();
            l0.o(collectionD2, "functionDescriptor.overriddenDescriptors");
            Collection<? extends y> collection2 = collectionD2;
            if (collection2.isEmpty()) {
                z11 = true;
            } else {
                Iterator<T> it2 = collection2.iterator();
                while (it2.hasNext()) {
                    if (((y) it2.next()).isInfix()) {
                        if (this.f6774l.u()) {
                            break;
                        }
                    }
                }
                z11 = true;
            }
        }
        s1(sb2, yVar.D(), "tailrec");
        I1(yVar, sb2);
        s1(sb2, yVar.isInline(), "inline");
        s1(sb2, z11, "infix");
        s1(sb2, z10, "operator");
    }

    public final void V1(j1 j1Var, boolean z10, StringBuilder sb2, boolean z11, boolean z12) {
        f0 type = j1Var.getType();
        l0.o(type, "variable.type");
        h1 h1Var = j1Var instanceof h1 ? (h1) j1Var : null;
        f0 f0VarS0 = h1Var != null ? h1Var.s0() : null;
        f0 f0Var = f0VarS0 == null ? type : f0VarS0;
        s1(sb2, f0VarS0 != null, "vararg");
        if (z12 || (z11 && !this.f6774l.a0())) {
            R1(j1Var, sb2, z12);
        }
        if (z10) {
            t1(j1Var, sb2, z11);
            sb2.append(": ");
        }
        sb2.append(y(f0Var));
        l1(j1Var, sb2);
        if (!this.f6774l.g0() || f0VarS0 == null) {
            return;
        }
        sb2.append(" /*");
        sb2.append(y(type));
        sb2.append("*/");
    }

    public boolean W() {
        return this.f6774l.x();
    }

    public final List<String> W0(fo.c cVar) {
        eo.d dVarG;
        Map<dp.f, jp.g<?>> mapA = cVar.a();
        List list = null;
        eo.e eVarF = this.f6774l.S() ? lp.a.f(cVar) : null;
        if (eVarF != null && (dVarG = eVarF.G()) != null) {
            List<h1> listH = dVarG.h();
            l0.o(listH, "valueParameters");
            ArrayList arrayList = new ArrayList();
            for (Object obj : listH) {
                if (((h1) obj).w0()) {
                    arrayList.add(obj);
                }
            }
            List arrayList2 = new ArrayList(z.b0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((h1) it.next()).getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = nm.k0.INSTANCE;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            dp.f fVar = (dp.f) obj2;
            l0.o(fVar, "it");
            if (!mapA.containsKey(fVar)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(z.b0(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(l0.C(((dp.f) it2.next()).b(), " = ..."));
        }
        Set<Map.Entry<dp.f, jp.g<?>>> setEntrySet = mapA.entrySet();
        ArrayList arrayList5 = new ArrayList(z.b0(setEntrySet, 10));
        Iterator<T> it3 = setEntrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            dp.f fVar2 = (dp.f) entry.getKey();
            jp.g<?> gVar = (jp.g) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fVar2.b());
            sb2.append(" = ");
            sb2.append(!list.contains(fVar2) ? e1(gVar) : "...");
            arrayList5.add(sb2.toString());
        }
        return nm.h0.q5(nm.h0.E4(arrayList4, arrayList5));
    }

    public final boolean W1(u uVar, StringBuilder sb2) {
        if (!this.f6774l.H().contains(gp.e.VISIBILITY)) {
            return false;
        }
        if (this.f6774l.I()) {
            uVar = uVar.f();
        }
        if (!this.f6774l.U() && l0.g(uVar, t.f4640l)) {
            return false;
        }
        sb2.append(m1(uVar.c()));
        sb2.append(" ");
        return true;
    }

    @os.l
    public gp.b X() {
        return this.f6774l.y();
    }

    public final void X0(StringBuilder sb2, fo.a aVar, fo.e eVar) {
        if (this.f6774l.H().contains(gp.e.ANNOTATIONS)) {
            Set<dp.c> setG = aVar instanceof f0 ? this.f6774l.g() : this.f6774l.B();
            jn.l<fo.c, Boolean> lVarV = this.f6774l.v();
            for (fo.c cVar : aVar.getAnnotations()) {
                if (!nm.h0.W1(setG, cVar.e()) && !Q0(cVar) && (lVarV == null || lVarV.invoke(cVar).booleanValue())) {
                    sb2.append(t(cVar, eVar));
                    if (this.f6774l.A()) {
                        sb2.append('\n');
                        l0.o(sb2, "append('\\n')");
                    } else {
                        sb2.append(" ");
                    }
                }
            }
        }
    }

    public final void X1(List<? extends e1> list, StringBuilder sb2) throws IOException {
        if (this.f6774l.l0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (e1 e1Var : list) {
            List<f0> upperBounds = e1Var.getUpperBounds();
            l0.o(upperBounds, "typeParameter.upperBounds");
            for (f0 f0Var : nm.h0.c2(upperBounds, 1)) {
                StringBuilder sb3 = new StringBuilder();
                dp.f name = e1Var.getName();
                l0.o(name, "typeParameter.name");
                sb3.append(x(name, false));
                sb3.append(" : ");
                l0.o(f0Var, "it");
                sb3.append(y(f0Var));
                arrayList.add(sb3.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb2.append(" ");
        sb2.append(m1("where"));
        sb2.append(" ");
        nm.h0.j3(arrayList, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : null, (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null);
    }

    @os.m
    public jn.l<h1, String> Y() {
        return this.f6774l.z();
    }

    public final String Y1(String str, String str2, String str3, String str4, String str5) {
        if (jq.e0.s2(str, str2, false, 2, null) && jq.e0.s2(str3, str4, false, 2, null)) {
            String strSubstring = str.substring(str2.length());
            l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            String strSubstring2 = str3.substring(str4.length());
            l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String strC = l0.C(str5, strSubstring);
            if (l0.g(strSubstring, strSubstring2)) {
                return strC;
            }
            if (Q(strSubstring, strSubstring2)) {
                return l0.C(strC, "!");
            }
        }
        return null;
    }

    public boolean Z() {
        return this.f6774l.A();
    }

    public final void Z0(eo.i iVar, StringBuilder sb2) {
        List<e1> listR = iVar.r();
        l0.o(listR, "classifier.declaredTypeParameters");
        List<e1> parameters = iVar.i().getParameters();
        l0.o(parameters, "classifier.typeConstructor.parameters");
        if (this.f6774l.g0() && iVar.l() && parameters.size() > listR.size()) {
            sb2.append(" /*captured type parameters: ");
            P1(sb2, parameters.subList(listR.size(), parameters.size()));
            sb2.append("*/");
        }
    }

    public final boolean Z1(f0 f0Var) {
        if (ao.g.m(f0Var)) {
            List<c1> listF0 = f0Var.F0();
            if (!(listF0 instanceof Collection) || !listF0.isEmpty()) {
                Iterator<T> it = listF0.iterator();
                while (it.hasNext()) {
                    if (((c1) it.next()).a()) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // gp.f
    public void a(boolean z10) {
        this.f6774l.a(z10);
    }

    @os.l
    public Set<dp.c> a0() {
        return this.f6774l.B();
    }

    public final void a1(eo.e eVar, StringBuilder sb2) throws IOException {
        eo.d dVarG;
        boolean z10 = eVar.getKind() == eo.f.ENUM_ENTRY;
        if (!this.f6774l.a0()) {
            Y0(this, sb2, eVar, null, 2, null);
            if (!z10) {
                u visibility = eVar.getVisibility();
                l0.o(visibility, "klass.visibility");
                W1(visibility, sb2);
            }
            if ((eVar.getKind() != eo.f.INTERFACE || eVar.s() != eo.e0.ABSTRACT) && (!eVar.getKind().isSingleton() || eVar.s() != eo.e0.FINAL)) {
                eo.e0 e0VarS = eVar.s();
                l0.o(e0VarS, "klass.modality");
                q1(e0VarS, sb2, P0(eVar));
            }
            o1(eVar, sb2);
            s1(sb2, this.f6774l.H().contains(gp.e.INNER) && eVar.l(), "inner");
            s1(sb2, this.f6774l.H().contains(gp.e.DATA) && eVar.x(), "data");
            s1(sb2, this.f6774l.H().contains(gp.e.INLINE) && eVar.isInline(), "inline");
            s1(sb2, this.f6774l.H().contains(gp.e.VALUE) && eVar.u(), "value");
            s1(sb2, this.f6774l.H().contains(gp.e.FUN) && eVar.t(), "fun");
            b1(eVar, sb2);
        }
        if (hp.d.x(eVar)) {
            d1(eVar, sb2);
        } else {
            if (!this.f6774l.a0()) {
                G1(sb2);
            }
            t1(eVar, sb2, true);
        }
        if (z10) {
            return;
        }
        List<e1> listR = eVar.r();
        l0.o(listR, "klass.declaredTypeParameters");
        Q1(listR, sb2, false);
        Z0(eVar, sb2);
        if (!eVar.getKind().isSingleton() && this.f6774l.x() && (dVarG = eVar.G()) != null) {
            sb2.append(" ");
            Y0(this, sb2, dVarG, null, 2, null);
            u visibility2 = dVarG.getVisibility();
            l0.o(visibility2, "primaryConstructor.visibility");
            W1(visibility2, sb2);
            sb2.append(m1("constructor"));
            List<h1> listH = dVarG.h();
            l0.o(listH, "primaryConstructor.valueParameters");
            U1(listH, dVarG.e0(), sb2);
        }
        H1(eVar, sb2);
        X1(listR, sb2);
    }

    public final boolean a2(boolean z10) {
        int i10 = b.f6779b[this.f6774l.K().ordinal()];
        if (i10 == 1) {
            return true;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new i0();
            }
        } else if (!z10) {
            return true;
        }
        return false;
    }

    @Override // gp.f
    public void b(boolean z10) {
        this.f6774l.b(z10);
    }

    public final d b0() {
        return (d) this.f6775m.getValue();
    }

    public final void b1(eo.e eVar, StringBuilder sb2) {
        sb2.append(m1(gp.c.f6761a.a(eVar)));
    }

    @Override // gp.f
    public boolean c() {
        return this.f6774l.c();
    }

    public boolean c0() {
        return this.f6774l.C();
    }

    @os.l
    public String c1(@os.l eo.h hVar) {
        l0.p(hVar, "klass");
        return vp.x.r(hVar) ? hVar.i().toString() : this.f6774l.y().a(hVar, this);
    }

    @Override // gp.f
    public void d(@os.l gp.b bVar) {
        l0.p(bVar, "<set-?>");
        this.f6774l.d(bVar);
    }

    public boolean d0() {
        gp.g gVar = this.f6774l;
        gVar.getClass();
        return gp.f.a.a(gVar);
    }

    public final void d1(eo.m mVar, StringBuilder sb2) {
        if (this.f6774l.P()) {
            if (this.f6774l.a0()) {
                sb2.append("companion object");
            }
            G1(sb2);
            eo.m mVarB = mVar.b();
            if (mVarB != null) {
                sb2.append("of ");
                dp.f name = mVarB.getName();
                l0.o(name, "containingDeclaration.name");
                sb2.append(x(name, false));
            }
        }
        if (this.f6774l.g0() || !l0.g(mVar.getName(), dp.h.f3827d)) {
            if (!this.f6774l.a0()) {
                G1(sb2);
            }
            dp.f name2 = mVar.getName();
            l0.o(name2, "descriptor.name");
            sb2.append(x(name2, true));
        }
    }

    @Override // gp.f
    public void e(boolean z10) {
        this.f6774l.e(z10);
    }

    public boolean e0() {
        gp.g gVar = this.f6774l;
        gVar.getClass();
        return gp.f.a.b(gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String e1(jp.g<?> gVar) {
        if (gVar instanceof jp.b) {
            return nm.h0.m3(((jp.b) gVar).b(), ", ", "{", "}", 0, null, new e(), 24, null);
        }
        if (gVar instanceof jp.a) {
            return jq.h0.a4(gp.c.u(this, (fo.c) ((jp.a) gVar).f8774a, null, 2, null), "@");
        }
        if (!(gVar instanceof q)) {
            return gVar.toString();
        }
        q.b bVar = (q.b) ((q) gVar).f8774a;
        if (bVar instanceof q.b.a) {
            return ((q.b.a) bVar).f8792a + "::class";
        }
        if (!(bVar instanceof q.b.C0228b)) {
            throw new i0();
        }
        q.b.C0228b c0228b = (q.b.C0228b) bVar;
        String strB = c0228b.f8793a.f8772a.b().b();
        l0.o(strB, "classValue.classId.asSingleFqName().asString()");
        int i10 = c0228b.f8793a.f8773b;
        int i11 = 0;
        while (i11 < i10) {
            i11++;
            strB = "kotlin.Array<" + strB + m0.f8868f;
        }
        return l0.C(strB, "::class");
    }

    @Override // gp.f
    public void f(boolean z10) {
        this.f6774l.f(z10);
    }

    public boolean f0() {
        return this.f6774l.F();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0037  */
    public final void f1(eo.l lVar, StringBuilder sb2) throws IOException {
        boolean z10;
        eo.d dVarG;
        Y0(this, sb2, lVar, null, 2, null);
        if (this.f6774l.U() || lVar.c0().s() != eo.e0.SEALED) {
            u visibility = lVar.getVisibility();
            l0.o(visibility, "constructor.visibility");
            if (W1(visibility, sb2)) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        n1(lVar, sb2);
        boolean z11 = this.f6774l.R() || !lVar.b0() || z10;
        if (z11) {
            sb2.append(m1("constructor"));
        }
        eo.i iVarB = lVar.b();
        l0.o(iVarB, "constructor.containingDeclaration");
        if (this.f6774l.Y()) {
            if (z11) {
                sb2.append(" ");
            }
            t1(iVarB, sb2, true);
            List<e1> typeParameters = lVar.getTypeParameters();
            l0.o(typeParameters, "constructor.typeParameters");
            Q1(typeParameters, sb2, false);
        }
        List<h1> listH = lVar.h();
        l0.o(listH, "constructor.valueParameters");
        U1(listH, lVar.e0(), sb2);
        if (this.f6774l.Q() && !lVar.b0() && (iVarB instanceof eo.e) && (dVarG = ((eo.e) iVarB).G()) != null) {
            List<h1> listH2 = dVarG.h();
            l0.o(listH2, "primaryConstructor.valueParameters");
            ArrayList arrayList = new ArrayList();
            for (Object obj : listH2) {
                h1 h1Var = (h1) obj;
                if (!h1Var.w0() && h1Var.s0() == null) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                sb2.append(" : ");
                sb2.append(m1("this"));
                sb2.append(nm.h0.m3(arrayList, ", ", "(", ")", 0, null, f.INSTANCE, 24, null));
            }
        }
        if (this.f6774l.Y()) {
            List<e1> typeParameters2 = lVar.getTypeParameters();
            l0.o(typeParameters2, "constructor.typeParameters");
            X1(typeParameters2, sb2);
        }
    }

    @Override // gp.f
    @os.l
    public Set<dp.c> g() {
        return this.f6774l.g();
    }

    public boolean g0() {
        return this.f6774l.G();
    }

    public final void g1(StringBuilder sb2, f0 f0Var) {
        Y0(this, sb2, f0Var, null, 2, null);
        vp.o oVar = f0Var instanceof vp.o ? (vp.o) f0Var : null;
        vp.n0 n0Var = oVar != null ? oVar.f17724b : null;
        if (vp.h0.a(f0Var)) {
            if ((f0Var instanceof m1) && this.f6774l.M()) {
                sb2.append(((m1) f0Var).f17722g);
            } else if (!(f0Var instanceof vp.w) || this.f6774l.G()) {
                sb2.append(f0Var.G0().toString());
            } else {
                sb2.append(((vp.w) f0Var).P0());
            }
            sb2.append(K1(f0Var.F0()));
        } else if (f0Var instanceof vp.u0) {
            sb2.append(((vp.u0) f0Var).f17681b.toString());
        } else if (n0Var instanceof vp.u0) {
            sb2.append(((vp.u0) n0Var).f17681b.toString());
        } else {
            N1(this, sb2, f0Var, null, 2, null);
        }
        if (f0Var.H0()) {
            sb2.append("?");
        }
        if (q0.c(f0Var)) {
            sb2.append(" & Any");
        }
    }

    @Override // gp.f
    public boolean h() {
        return this.f6774l.h();
    }

    @os.l
    public Set<gp.e> h0() {
        return this.f6774l.H();
    }

    public final String h1(String str) {
        int i10 = b.f6778a[this.f6774l.b0().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 == 2) {
            return n.a.a("<font color=red><b>", str, "</b></font>");
        }
        throw new i0();
    }

    @Override // gp.f
    @os.l
    public gp.a i() {
        return this.f6774l.i();
    }

    public boolean i0() {
        return this.f6774l.I();
    }

    public final String i1(List<dp.f> list) {
        return R(n.c(list));
    }

    @Override // gp.f
    public void j(@os.l gp.a aVar) {
        l0.p(aVar, "<set-?>");
        this.f6774l.j(aVar);
    }

    @os.l
    public final gp.g j0() {
        return this.f6774l;
    }

    public final void j1(y yVar, StringBuilder sb2) throws IOException {
        if (!this.f6774l.a0()) {
            if (!this.f6774l.Z()) {
                Y0(this, sb2, yVar, null, 2, null);
                u visibility = yVar.getVisibility();
                l0.o(visibility, "function.visibility");
                W1(visibility, sb2);
                r1(yVar, sb2);
                if (this.f6774l.C()) {
                    o1(yVar, sb2);
                }
                w1(yVar, sb2);
                if (this.f6774l.C()) {
                    V0(yVar, sb2);
                } else {
                    I1(yVar, sb2);
                }
                n1(yVar, sb2);
                if (this.f6774l.g0()) {
                    if (yVar.y0()) {
                        sb2.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (yVar.A0()) {
                        sb2.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb2.append(m1("fun"));
            sb2.append(" ");
            List<e1> typeParameters = yVar.getTypeParameters();
            l0.o(typeParameters, "function.typeParameters");
            Q1(typeParameters, sb2, true);
            D1(yVar, sb2);
        }
        t1(yVar, sb2, true);
        List<h1> listH = yVar.h();
        l0.o(listH, "function.valueParameters");
        U1(listH, yVar.e0(), sb2);
        E1(yVar, sb2);
        f0 returnType = yVar.getReturnType();
        if (!this.f6774l.j0() && (this.f6774l.e0() || returnType == null || !ao.h.A0(returnType))) {
            sb2.append(": ");
            sb2.append(returnType == null ? "[NULL]" : y(returnType));
        }
        List<e1> typeParameters2 = yVar.getTypeParameters();
        l0.o(typeParameters2, "function.typeParameters");
        X1(typeParameters2, sb2);
    }

    @Override // gp.f
    public void k(@os.l Set<dp.c> set) {
        l0.p(set, "<set-?>");
        this.f6774l.k(set);
    }

    @os.l
    public j k0() {
        return this.f6774l.J();
    }

    public final void k1(StringBuilder sb2, f0 f0Var) {
        dp.f fVarC;
        int length = sb2.length();
        Y0(b0(), sb2, f0Var, null, 2, null);
        boolean z10 = true;
        boolean z11 = sb2.length() != length;
        boolean zO = ao.g.o(f0Var);
        boolean zH0 = f0Var.H0();
        f0 f0VarH = ao.g.h(f0Var);
        boolean z12 = zH0 || (z11 && f0VarH != null);
        if (z12) {
            if (zO) {
                sb2.insert(length, '(');
            } else {
                if (z11) {
                    jq.d.r(j0.r7(sb2));
                    if (sb2.charAt(jq.h0.g3(sb2) - 1) != ')') {
                        sb2.insert(jq.h0.g3(sb2), "()");
                    }
                }
                sb2.append("(");
            }
        }
        s1(sb2, zO, "suspend");
        if (f0VarH != null) {
            if ((!Z1(f0VarH) || f0VarH.H0()) && !O0(f0VarH)) {
                z10 = false;
            }
            if (z10) {
                sb2.append("(");
            }
            u1(sb2, f0VarH);
            if (z10) {
                sb2.append(")");
            }
            sb2.append(".");
        }
        sb2.append("(");
        int i10 = 0;
        for (c1 c1Var : ao.g.j(f0Var)) {
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb2.append(", ");
            }
            if (this.f6774l.L()) {
                f0 type = c1Var.getType();
                l0.o(type, "typeProjection.type");
                fVarC = ao.g.c(type);
            } else {
                fVarC = null;
            }
            if (fVarC != null) {
                sb2.append(x(fVarC, false));
                sb2.append(": ");
            }
            sb2.append(z(c1Var));
            i10 = i11;
        }
        sb2.append(") ");
        sb2.append(P());
        sb2.append(" ");
        u1(sb2, ao.g.i(f0Var));
        if (z12) {
            sb2.append(")");
        }
        if (zH0) {
            sb2.append("?");
        }
    }

    @Override // gp.f
    public void l(@os.l Set<? extends gp.e> set) {
        l0.p(set, "<set-?>");
        this.f6774l.l(set);
    }

    @os.l
    public k l0() {
        return this.f6774l.K();
    }

    public final void l1(j1 j1Var, StringBuilder sb2) {
        jp.g<?> gVarM0;
        if (!this.f6774l.F() || (gVarM0 = j1Var.m0()) == null) {
            return;
        }
        sb2.append(" = ");
        sb2.append(R(e1(gVarM0)));
    }

    @Override // gp.f
    public void m(boolean z10) {
        this.f6774l.m(z10);
    }

    public boolean m0() {
        return this.f6774l.L();
    }

    public final String m1(String str) {
        int i10 = b.f6778a[this.f6774l.b0().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 == 2) {
            return this.f6774l.w() ? str : n.a.a("<b>", str, "</b>");
        }
        throw new i0();
    }

    @Override // gp.f
    public void n(@os.l m mVar) {
        l0.p(mVar, "<set-?>");
        this.f6774l.n(mVar);
    }

    public boolean n0() {
        return this.f6774l.M();
    }

    public final void n1(eo.b bVar, StringBuilder sb2) {
        if (this.f6774l.H().contains(gp.e.MEMBER_KIND) && this.f6774l.g0() && bVar.getKind() != eo.b.a.DECLARATION) {
            sb2.append("/*");
            sb2.append(cq.a.f(bVar.getKind().name()));
            sb2.append("*/ ");
        }
    }

    @Override // gp.f
    public void o(boolean z10) {
        this.f6774l.o(z10);
    }

    @os.l
    public l o0() {
        return this.f6774l.N();
    }

    public final void o1(eo.d0 d0Var, StringBuilder sb2) {
        s1(sb2, d0Var.isExternal(), "external");
        boolean z10 = false;
        s1(sb2, this.f6774l.H().contains(gp.e.EXPECT) && d0Var.i0(), "expect");
        if (this.f6774l.H().contains(gp.e.ACTUAL) && d0Var.Y()) {
            z10 = true;
        }
        s1(sb2, z10, "actual");
    }

    @Override // gp.f
    public void p(boolean z10) {
        this.f6774l.p(z10);
    }

    public boolean p0() {
        return this.f6774l.O();
    }

    @os.l
    public String p1(@os.l String str) {
        l0.p(str, "message");
        int i10 = b.f6778a[this.f6774l.b0().ordinal()];
        if (i10 == 1) {
            return str;
        }
        if (i10 == 2) {
            return n.a.a("<i>", str, "</i>");
        }
        throw new i0();
    }

    @Override // gp.f
    public void q(@os.l k kVar) {
        l0.p(kVar, "<set-?>");
        this.f6774l.q(kVar);
    }

    public boolean q0() {
        return this.f6774l.P();
    }

    public final void q1(eo.e0 e0Var, StringBuilder sb2, eo.e0 e0Var2) {
        if (this.f6774l.T() || e0Var != e0Var2) {
            s1(sb2, this.f6774l.H().contains(gp.e.MODALITY), cq.a.f(e0Var.name()));
        }
    }

    @Override // gp.f
    public void r(boolean z10) {
        this.f6774l.r(z10);
    }

    public boolean r0() {
        return this.f6774l.Q();
    }

    public final void r1(eo.b bVar, StringBuilder sb2) {
        if (hp.d.J(bVar) && bVar.s() == eo.e0.FINAL) {
            return;
        }
        if (this.f6774l.J() == j.RENDER_OVERRIDE && bVar.s() == eo.e0.OPEN && S0(bVar)) {
            return;
        }
        eo.e0 e0VarS = bVar.s();
        l0.o(e0VarS, "callable.modality");
        q1(e0VarS, sb2, P0(bVar));
    }

    @Override // gp.c
    @os.l
    public String s(@os.l eo.m mVar) {
        l0.p(mVar, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        mVar.A(new a(this), sb2);
        if (this.f6774l.h0()) {
            N(sb2, mVar);
        }
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean s0() {
        return this.f6774l.R();
    }

    public final void s1(StringBuilder sb2, boolean z10, String str) {
        if (z10) {
            sb2.append(m1(str));
            sb2.append(" ");
        }
    }

    @Override // gp.c
    @os.l
    public String t(@os.l fo.c cVar, @os.m fo.e eVar) throws IOException {
        l0.p(cVar, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (eVar != null) {
            sb2.append(l0.C(eVar.getRenderName(), ":"));
        }
        f0 type = cVar.getType();
        sb2.append(y(type));
        if (d0()) {
            List<String> listW0 = W0(cVar);
            if (e0() || !listW0.isEmpty()) {
                nm.h0.j3(listW0, sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : "(", (y5.a.f20716e0 & 8) == 0 ? ")" : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null);
            }
        }
        if (this.f6774l.g0() && (vp.h0.a(type) || (type.G0().d() instanceof eo.j0.b))) {
            sb2.append(" /* annotation class not found */");
        }
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean t0() {
        return this.f6774l.S();
    }

    public final void t1(eo.m mVar, StringBuilder sb2, boolean z10) {
        dp.f name = mVar.getName();
        l0.o(name, "descriptor.name");
        sb2.append(x(name, z10));
    }

    public boolean u0() {
        return this.f6774l.T();
    }

    public final void u1(StringBuilder sb2, f0 f0Var) {
        n1 n1VarJ0 = f0Var.J0();
        vp.a aVar = n1VarJ0 instanceof vp.a ? (vp.a) n1VarJ0 : null;
        if (aVar == null) {
            v1(sb2, f0Var);
            return;
        }
        if (this.f6774l.W()) {
            v1(sb2, aVar.f17659b);
            return;
        }
        v1(sb2, aVar.f17660c);
        if (this.f6774l.X()) {
            T0(sb2, aVar);
        }
    }

    @Override // gp.c
    @os.l
    public String v(@os.l String str, @os.l String str2, @os.l ao.h hVar) {
        l0.p(str, "lowerRendered");
        l0.p(str2, "upperRendered");
        l0.p(hVar, "builtIns");
        if (Q(str, str2)) {
            return jq.e0.s2(str2, "(", false, 2, null) ? n.a.a("(", str, ")!") : l0.C(str, "!");
        }
        gp.b bVarY = this.f6774l.y();
        eo.e eVarW = hVar.w();
        l0.o(eVarW, "builtIns.collection");
        String strV5 = jq.h0.v5(bVarY.a(eVarW, this), "Collection", null, 2, null);
        String strY1 = Y1(str, l0.C(strV5, "Mutable"), str2, strV5, j.a.a(strV5, "(Mutable)"));
        if (strY1 != null) {
            return strY1;
        }
        String strY2 = Y1(str, l0.C(strV5, "MutableMap.MutableEntry"), str2, l0.C(strV5, "Map.Entry"), l0.C(strV5, "(Mutable)Map.(Mutable)Entry"));
        if (strY2 != null) {
            return strY2;
        }
        gp.b bVarY2 = this.f6774l.y();
        eo.e eVarJ = hVar.j();
        l0.o(eVarJ, "builtIns.array");
        String strV6 = jq.h0.v5(bVarY2.a(eVarJ, this), "Array", null, 2, null);
        String strY3 = Y1(str, l0.C(strV6, R("Array<")), str2, l0.C(strV6, R("Array<out ")), l0.C(strV6, R("Array<(out) ")));
        if (strY3 != null) {
            return strY3;
        }
        return "(" + str + ".." + str2 + ')';
    }

    public boolean v0() {
        return this.f6774l.U();
    }

    public final void v1(StringBuilder sb2, f0 f0Var) {
        if ((f0Var instanceof vp.p1) && this.f6774l.h() && !((vp.p1) f0Var).L0()) {
            sb2.append("<Not computed yet>");
            return;
        }
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof vp.z) {
            sb2.append(((vp.z) n1VarJ0).Q0(this, this));
        } else if (n1VarJ0 instanceof vp.n0) {
            F1(sb2, (vp.n0) n1VarJ0);
        }
    }

    @Override // gp.c
    @os.l
    public String w(@os.l dp.d dVar) {
        l0.p(dVar, "fqName");
        List<dp.f> listH = dVar.h();
        l0.o(listH, "fqName.pathSegments()");
        return i1(listH);
    }

    public boolean w0() {
        return this.f6774l.V();
    }

    public final void w1(eo.b bVar, StringBuilder sb2) {
        if (this.f6774l.H().contains(gp.e.OVERRIDE) && S0(bVar) && this.f6774l.J() != j.RENDER_OPEN) {
            s1(sb2, true, "override");
            if (this.f6774l.g0()) {
                sb2.append("/*");
                sb2.append(bVar.d().size());
                sb2.append("*/ ");
            }
        }
    }

    @Override // gp.c
    @os.l
    public String x(@os.l dp.f fVar, boolean z10) {
        l0.p(fVar, "name");
        String strR = R(n.b(fVar));
        return (this.f6774l.w() && this.f6774l.b0() == m.HTML && z10) ? n.a.a("<b>", strR, "</b>") : strR;
    }

    public boolean x0() {
        return this.f6774l.W();
    }

    public final void x1(k0 k0Var, StringBuilder sb2) {
        y1(k0Var.e(), "package-fragment", sb2);
        if (this.f6774l.h()) {
            sb2.append(" in ");
            t1(k0Var.b(), sb2, false);
        }
    }

    @Override // gp.c
    @os.l
    public String y(@os.l f0 f0Var) {
        l0.p(f0Var, y0.a.f8215h);
        StringBuilder sb2 = new StringBuilder();
        u1(sb2, this.f6774l.c0().invoke(f0Var));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean y0() {
        return this.f6774l.X();
    }

    public final void y1(dp.c cVar, String str, StringBuilder sb2) {
        sb2.append(m1(str));
        dp.d dVarJ = cVar.j();
        l0.o(dVarJ, "fqName.toUnsafe()");
        String strW = w(dVarJ);
        if (strW.length() > 0) {
            sb2.append(" ");
            sb2.append(strW);
        }
    }

    @Override // gp.c
    @os.l
    public String z(@os.l c1 c1Var) throws IOException {
        l0.p(c1Var, "typeProjection");
        StringBuilder sb2 = new StringBuilder();
        O(sb2, x.k(c1Var));
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean z0() {
        return this.f6774l.Y();
    }

    public final void z1(p0 p0Var, StringBuilder sb2) {
        y1(p0Var.e(), "package", sb2);
        if (this.f6774l.h()) {
            sb2.append(" in context of ");
            t1(p0Var.x0(), sb2, false);
        }
    }
}
