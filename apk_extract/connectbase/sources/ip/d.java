package ip;

import eo.e1;
import eo.h;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.n0;
import lm.t0;
import nm.r;
import nm.z;
import os.l;
import os.m;
import up.f;
import up.n;
import vp.c1;
import vp.d0;
import vp.f0;
import vp.f1;
import vp.i0;
import vp.o1;
import vp.p;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    public static final class a extends n0 implements jn.a<f0> {
        final /* synthetic */ c1 $this_createCapturedIfNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c1 c1Var) {
            super(0);
            this.$this_createCapturedIfNeeded = c1Var;
        }

        @Override // jn.a
        @l
        public final f0 invoke() {
            f0 type = this.$this_createCapturedIfNeeded.getType();
            l0.o(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    public static final class b extends p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f1 f8351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f8352e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f1 f1Var, boolean z10) {
            super(f1Var);
            this.f8351d = f1Var;
            this.f8352e = z10;
        }

        @Override // vp.p, vp.f1
        public boolean b() {
            return this.f8352e;
        }

        @Override // vp.p, vp.f1
        @m
        public c1 e(@l f0 f0Var) {
            l0.p(f0Var, cb.b.c.f1408o);
            c1 c1VarE = super.e(f0Var);
            if (c1VarE == null) {
                return null;
            }
            h hVarD = f0Var.G0().d();
            return d.b(c1VarE, hVarD instanceof e1 ? (e1) hVarD : null);
        }
    }

    public static final c1 b(c1 c1Var, e1 e1Var) {
        if (e1Var == null || c1Var.c() == o1.INVARIANT) {
            return c1Var;
        }
        if (e1Var.m() != c1Var.c()) {
            return new vp.e1(c(c1Var));
        }
        if (!c1Var.a()) {
            return new vp.e1(c1Var.getType());
        }
        n nVar = f.f16364e;
        l0.o(nVar, "NO_LOCKS");
        return new vp.e1(new i0(nVar, new a(c1Var)));
    }

    @l
    public static final f0 c(@l c1 c1Var) {
        l0.p(c1Var, "typeProjection");
        return new ip.a(c1Var, null, false, null, 14, null);
    }

    public static final boolean d(@l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return f0Var.G0() instanceof ip.b;
    }

    @l
    public static final f1 e(@l f1 f1Var, boolean z10) {
        l0.p(f1Var, "<this>");
        if (!(f1Var instanceof d0)) {
            return new b(f1Var, z10);
        }
        d0 d0Var = (d0) f1Var;
        e1[] e1VarArr = d0Var.f17670c;
        List<t0> listUA = r.uA(d0Var.f17671d, e1VarArr);
        ArrayList arrayList = new ArrayList(z.b0(listUA, 10));
        for (t0 t0Var : listUA) {
            arrayList.add(b((c1) t0Var.getFirst(), (e1) t0Var.getSecond()));
        }
        Object[] array = arrayList.toArray(new c1[0]);
        if (array != null) {
            return new d0(e1VarArr, (c1[]) array, z10);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static /* synthetic */ f1 f(f1 f1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return e(f1Var, z10);
    }
}
