package xn;

import eo.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.v1;
import lm.l2;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements un.t, i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f20432d = {l1.f9319a.n(new g1(l1.d(w.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e1 f20433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a0.a f20434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final x f20435c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20436a;

        static {
            int[] iArr = new int[o1.values().length];
            iArr[o1.INVARIANT.ordinal()] = 1;
            iArr[o1.IN_VARIANCE.ordinal()] = 2;
            iArr[o1.OUT_VARIANCE.ordinal()] = 3;
            f20436a = iArr;
        }
    }

    public static final class b extends n0 implements jn.a<List<? extends v>> {
        public b() {
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // jn.a
        public final List<? extends v> invoke() {
            List<vp.f0> upperBounds = w.this.f20433a.getUpperBounds();
            l0.o(upperBounds, "descriptor.upperBounds");
            List<vp.f0> list = upperBounds;
            ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new v((vp.f0) it.next(), null, 2, 0 == true ? 1 : 0));
            }
            return arrayList;
        }
    }

    public w(@os.m x xVar, @os.l e1 e1Var) {
        h<?> hVarI;
        Object objA;
        l0.p(e1Var, "descriptor");
        this.f20433a = e1Var;
        this.f20434b = a0.d(new b());
        if (xVar == null) {
            eo.m mVarB = e1Var.b();
            l0.o(mVarB, "descriptor.containingDeclaration");
            if (mVarB instanceof eo.e) {
                objA = i((eo.e) mVarB);
            } else {
                if (!(mVarB instanceof eo.b)) {
                    throw new y(l0.C("Unknown type parameter container: ", mVarB));
                }
                eo.m mVarB2 = ((eo.b) mVarB).b();
                l0.o(mVarB2, "declaration.containingDeclaration");
                if (mVarB2 instanceof eo.e) {
                    hVarI = i((eo.e) mVarB2);
                } else {
                    tp.h hVar = mVarB instanceof tp.h ? (tp.h) mVarB : null;
                    if (hVar == null) {
                        throw new y(l0.C("Non-class callable descriptor must be deserialized: ", mVarB));
                    }
                    hVarI = (h) in.b.i(b(hVar));
                }
                objA = mVarB.A(new xn.a(hVarI), l2.f10208a);
            }
            l0.o(objA, "when (val declaration = … $declaration\")\n        }");
            xVar = (x) objA;
        }
        this.f20435c = xVar;
    }

    public final Class<?> b(tp.h hVar) {
        tp.g gVarL = hVar.L();
        if (!(gVarL instanceof wo.j)) {
            gVarL = null;
        }
        wo.j jVar = (wo.j) gVarL;
        wo.p pVar = jVar == null ? null : jVar.f19799g;
        jo.f fVar = (jo.f) (pVar instanceof jo.f ? pVar : null);
        if (fVar != null) {
            return fVar.f8759a;
        }
        throw new y(l0.C("Container of deserialized member is not resolved: ", hVar));
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (l0.g(this.f20435c, wVar.f20435c) && l0.g(getName(), wVar.getName())) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public e1 f() {
        return this.f20433a;
    }

    @Override // un.t
    @os.l
    public String getName() {
        String strB = this.f20433a.getName().b();
        l0.o(strB, "descriptor.name.asString()");
        return strB;
    }

    @Override // un.t
    @os.l
    public List<un.s> getUpperBounds() {
        a0.a aVar = this.f20434b;
        un.o<Object> oVar = f20432d[0];
        Object objInvoke = aVar.invoke();
        l0.o(objInvoke, "<get-upperBounds>(...)");
        return (List) objInvoke;
    }

    public int hashCode() {
        return getName().hashCode() + (this.f20435c.hashCode() * 31);
    }

    public final h<?> i(eo.e eVar) {
        Class<?> clsP = h0.p(eVar);
        h<?> hVar = (h) (clsP == null ? null : in.b.i(clsP));
        if (hVar != null) {
            return hVar;
        }
        throw new y(l0.C("Type parameter container is not resolved: ", eVar.b()));
    }

    @Override // un.t
    public boolean j() {
        return this.f20433a.j();
    }

    @Override // un.t
    @os.l
    public un.v m() {
        int i10 = a.f20436a[this.f20433a.m().ordinal()];
        if (i10 == 1) {
            return un.v.INVARIANT;
        }
        if (i10 == 2) {
            return un.v.IN;
        }
        if (i10 == 3) {
            return un.v.OUT;
        }
        throw new lm.i0();
    }

    @os.l
    public String toString() {
        return v1.f9367f.a(this);
    }

    @Override // xn.i
    public eo.h y() {
        return this.f20433a;
    }
}
