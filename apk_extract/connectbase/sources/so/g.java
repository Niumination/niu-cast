package so;

import eo.e1;
import eo.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kn.l0;
import kn.w;
import lm.d0;
import lm.l2;
import lm.t0;
import nm.h0;
import nm.n1;
import nm.z;
import os.l;
import os.m;
import vp.b1;
import vp.c1;
import vp.f0;
import vp.h1;
import vp.n0;
import vp.o1;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final up.f f15190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final d0 f15191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final e f15192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final up.g<a, f0> f15193d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final e1 f15194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @l
        public final so.a f15196c;

        public a(@l e1 e1Var, boolean z10, @l so.a aVar) {
            l0.p(e1Var, "typeParameter");
            l0.p(aVar, "typeAttr");
            this.f15194a = e1Var;
            this.f15195b = z10;
            this.f15196c = aVar;
        }

        @l
        public final so.a a() {
            return this.f15196c;
        }

        @l
        public final e1 b() {
            return this.f15194a;
        }

        public final boolean c() {
            return this.f15195b;
        }

        public boolean equals(@m Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!l0.g(aVar.f15194a, this.f15194a) || aVar.f15195b != this.f15195b) {
                return false;
            }
            so.a aVar2 = aVar.f15196c;
            so.b bVar = aVar2.f15175b;
            so.a aVar3 = this.f15196c;
            return bVar == aVar3.f15175b && aVar2.f15174a == aVar3.f15174a && aVar2.f15176c == aVar3.f15176c && l0.g(aVar2.f15178e, aVar3.f15178e);
        }

        public int hashCode() {
            int iHashCode = this.f15194a.hashCode();
            int i10 = (iHashCode * 31) + (this.f15195b ? 1 : 0) + iHashCode;
            int iHashCode2 = this.f15196c.f15175b.hashCode() + (i10 * 31) + i10;
            int iHashCode3 = this.f15196c.f15174a.hashCode() + (iHashCode2 * 31) + iHashCode2;
            so.a aVar = this.f15196c;
            int i11 = (iHashCode3 * 31) + (aVar.f15176c ? 1 : 0) + iHashCode3;
            int i12 = i11 * 31;
            n0 n0Var = aVar.f15178e;
            return i12 + (n0Var == null ? 0 : n0Var.hashCode()) + i11;
        }

        @l
        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.f15194a + ", isRaw=" + this.f15195b + ", typeAttr=" + this.f15196c + ')';
        }
    }

    public static final class b extends kn.n0 implements jn.a<n0> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @l
        public final n0 invoke() {
            return x.j("Can't compute erased upper bound of type parameter `" + g.this + '`');
        }
    }

    public static final class c extends kn.n0 implements jn.l<a, f0> {
        public c() {
            super(1);
        }

        @Override // jn.l
        public final f0 invoke(a aVar) {
            return g.this.d(aVar.f15194a, aVar.f15195b, aVar.f15196c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final f0 b(so.a aVar) {
        n0 n0Var = aVar.f15178e;
        if (n0Var != null) {
            return zp.a.t(n0Var);
        }
        n0 n0VarE = e();
        l0.o(n0VarE, "erroneousErasedBound");
        return n0VarE;
    }

    public final f0 c(@l e1 e1Var, boolean z10, @l so.a aVar) {
        l0.p(e1Var, "typeParameter");
        l0.p(aVar, "typeAttr");
        return this.f15193d.invoke(new a(e1Var, z10, aVar));
    }

    public final f0 d(e1 e1Var, boolean z10, so.a aVar) {
        c1 c1VarJ;
        Set<e1> set = aVar.f15177d;
        if (set != null && set.contains(e1Var.a())) {
            return b(aVar);
        }
        n0 n0VarQ = e1Var.q();
        l0.o(n0VarQ, "typeParameter.defaultType");
        Set<e1> setF = zp.a.f(n0VarQ, set);
        int iJ = nm.c1.j(z.b0(setF, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (e1 e1Var2 : setF) {
            if (set == null || !set.contains(e1Var2)) {
                e eVar = this.f15192c;
                so.a aVarI = z10 ? aVar : aVar.i(so.b.INFLEXIBLE);
                f0 f0VarC = c(e1Var2, z10, aVar.j(e1Var));
                l0.o(f0VarC, "getErasedUpperBound(it, …Parameter(typeParameter))");
                c1VarJ = eVar.j(e1Var2, aVarI, f0VarC);
            } else {
                c1VarJ = d.b(e1Var2, aVar);
            }
            t0 t0Var = new t0(e1Var2.i(), c1VarJ);
            linkedHashMap.put(t0Var.getFirst(), t0Var.getSecond());
        }
        h1 h1VarG = h1.g(b1.a.e(b1.f17666c, linkedHashMap, false, 2, null));
        l0.o(h1VarG, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<f0> upperBounds = e1Var.getUpperBounds();
        l0.o(upperBounds, "typeParameter.upperBounds");
        f0 f0Var = (f0) h0.B2(upperBounds);
        if (f0Var.G0().d() instanceof eo.e) {
            l0.o(f0Var, "firstUpperBound");
            return zp.a.s(f0Var, h1VarG, linkedHashMap, o1.OUT_VARIANCE, aVar.f15177d);
        }
        Set<e1> setF2 = aVar.f15177d;
        if (setF2 == null) {
            setF2 = n1.f(this);
        }
        h hVarD = f0Var.G0().d();
        if (hVarD == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
        do {
            e1 e1Var3 = (e1) hVarD;
            if (setF2.contains(e1Var3)) {
                return b(aVar);
            }
            List<f0> upperBounds2 = e1Var3.getUpperBounds();
            l0.o(upperBounds2, "current.upperBounds");
            f0 f0Var2 = (f0) h0.B2(upperBounds2);
            if (f0Var2.G0().d() instanceof eo.e) {
                l0.o(f0Var2, "nextUpperBound");
                return zp.a.s(f0Var2, h1VarG, linkedHashMap, o1.OUT_VARIANCE, aVar.f15177d);
            }
            hVarD = f0Var2.G0().d();
        } while (hVarD != null);
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
    }

    public final n0 e() {
        return (n0) this.f15191b.getValue();
    }

    public g(@m e eVar) {
        up.f fVar = new up.f("Type parameter upper bound erasion results", (Runnable) null, (jn.l<InterruptedException, l2>) null);
        this.f15190a = fVar;
        this.f15191b = lm.f0.b(new b());
        this.f15192c = eVar == null ? new e(this) : eVar;
        up.g<a, f0> gVarA = fVar.a(new c());
        l0.o(gVarA, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.f15193d = gVarA;
    }

    public /* synthetic */ g(e eVar, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : eVar);
    }
}
