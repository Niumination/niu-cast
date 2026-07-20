package bo;

import ao.k;
import dp.f;
import eo.c1;
import eo.e0;
import eo.e1;
import eo.h;
import eo.h0;
import eo.k0;
import eo.t;
import eo.u;
import eo.z0;
import fo.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.w;
import lm.i0;
import lm.l2;
import nm.v0;
import nm.x;
import nm.y;
import nm.z;
import os.l;
import os.m;
import up.n;
import vp.a1;
import vp.f0;
import vp.g0;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends ho.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final n f990g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public final k0 f991i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @l
    public final c f992n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f993p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @l
    public final C0034b f994v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @l
    public final d f995w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @l
    public final List<e1> f996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @l
    public static final a f988y = new a();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @l
    public static final dp.b f989z = new dp.b(k.f565m, f.k("Function"));

    @l
    public static final dp.b H = new dp.b(k.f562j, f.k("KFunction"));

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX INFO: renamed from: bo.b$b, reason: collision with other inner class name */
    public final class C0034b extends vp.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f997d;

        /* JADX INFO: renamed from: bo.b$b$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f998a;

            static {
                int[] iArr = new int[c.values().length];
                iArr[c.Function.ordinal()] = 1;
                iArr[c.KFunction.ordinal()] = 2;
                iArr[c.SuspendFunction.ordinal()] = 3;
                iArr[c.KSuspendFunction.ordinal()] = 4;
                f998a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0034b(b bVar) {
            super(bVar.f990g);
            l0.p(bVar, "this$0");
            this.f997d = bVar;
        }

        @Override // vp.b, vp.m, vp.a1
        public h d() {
            return this.f997d;
        }

        @Override // vp.a1
        public boolean e() {
            return true;
        }

        @Override // vp.a1
        @l
        public List<e1> getParameters() {
            return this.f997d.f996x;
        }

        @Override // vp.h
        @l
        public Collection<f0> k() {
            List listK;
            int i10 = a.f998a[this.f997d.f992n.ordinal()];
            if (i10 == 1) {
                listK = x.k(b.f989z);
            } else if (i10 == 2) {
                listK = y.O(b.H, new dp.b(k.f565m, c.Function.numberedClassName(this.f997d.f993p)));
            } else if (i10 == 3) {
                listK = x.k(b.f989z);
            } else {
                if (i10 != 4) {
                    throw new i0();
                }
                listK = y.O(b.H, new dp.b(k.f557e, c.SuspendFunction.numberedClassName(this.f997d.f993p)));
            }
            h0 h0VarB = this.f997d.f991i.b();
            List<dp.b> list = listK;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            for (dp.b bVar : list) {
                eo.e eVarA = eo.x.a(h0VarB, bVar);
                if (eVarA == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List listK5 = nm.h0.K5(this.f997d.f996x, eVarA.i().getParameters().size());
                ArrayList arrayList2 = new ArrayList(z.b0(listK5, 10));
                Iterator it = listK5.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new vp.e1(((e1) it.next()).q()));
                }
                g.f6167h.getClass();
                arrayList.add(g0.g(g.a.f6169b, eVarA, arrayList2));
            }
            return nm.h0.V5(arrayList);
        }

        @Override // vp.h
        @l
        public c1 p() {
            return c1.a.f4596a;
        }

        @l
        public String toString() {
            return this.f997d.toString();
        }

        @Override // vp.b
        /* JADX INFO: renamed from: v */
        public eo.e d() {
            return this.f997d;
        }

        @l
        public b w() {
            return this.f997d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l n nVar, @l k0 k0Var, @l c cVar, int i10) {
        super(nVar, cVar.numberedClassName(i10));
        l0.p(nVar, "storageManager");
        l0.p(k0Var, "containingDeclaration");
        l0.p(cVar, "functionKind");
        this.f990g = nVar;
        this.f991i = k0Var;
        this.f992n = cVar;
        this.f993p = i10;
        this.f994v = new C0034b(this);
        this.f995w = new d(nVar, this);
        ArrayList arrayList = new ArrayList();
        tn.l lVar = new tn.l(1, i10, 1);
        ArrayList arrayList2 = new ArrayList(z.b0(lVar, 10));
        Iterator<Integer> it = lVar.iterator();
        while (it.hasNext()) {
            E0(arrayList, this, o1.IN_VARIANCE, l0.C("P", Integer.valueOf(((v0) it).nextInt())));
            arrayList2.add(l2.f10208a);
        }
        E0(arrayList, this, o1.OUT_VARIANCE, "R");
        this.f996x = nm.h0.V5(arrayList);
    }

    public static final void E0(ArrayList<e1> arrayList, b bVar, o1 o1Var, String str) {
        g.f6167h.getClass();
        arrayList.add(ho.k0.L0(bVar, g.a.f6169b, false, o1Var, f.k(str), arrayList.size(), bVar.f990g));
    }

    @Override // eo.e
    public eo.d G() {
        return null;
    }

    public final int K0() {
        return this.f993p;
    }

    @m
    public Void L0() {
        return null;
    }

    @l
    public List<eo.d> M0() {
        return nm.k0.INSTANCE;
    }

    @l
    public k0 N0() {
        return this.f991i;
    }

    @l
    public final c O0() {
        return this.f992n;
    }

    @l
    public List<eo.e> P0() {
        return nm.k0.INSTANCE;
    }

    @l
    public op.h.c Q0() {
        return op.h.c.f12406b;
    }

    @Override // ho.t
    @l
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public d Z(@l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        return this.f995w;
    }

    @m
    public Void S0() {
        return null;
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // eo.e
    public boolean a0() {
        return false;
    }

    @Override // eo.e, eo.n, eo.m
    public eo.m b() {
        return this.f991i;
    }

    @Override // eo.e
    public Collection g() {
        return nm.k0.INSTANCE;
    }

    @Override // fo.a
    @l
    public g getAnnotations() {
        g.f6167h.getClass();
        return g.a.f6169b;
    }

    @Override // eo.e
    @l
    public eo.f getKind() {
        return eo.f.INTERFACE;
    }

    @Override // eo.p
    @l
    public z0 getSource() {
        z0 z0Var = z0.f4654a;
        l0.o(z0Var, "NO_SOURCE");
        return z0Var;
    }

    @Override // eo.e, eo.q, eo.d0
    @l
    public u getVisibility() {
        u uVar = t.f4633e;
        l0.o(uVar, "PUBLIC");
        return uVar;
    }

    @Override // eo.h
    @l
    public a1 i() {
        return this.f994v;
    }

    @Override // eo.d0
    public boolean i0() {
        return false;
    }

    @Override // eo.d0
    public boolean isExternal() {
        return false;
    }

    @Override // eo.e
    public boolean isInline() {
        return false;
    }

    @Override // eo.e
    public Collection k() {
        return nm.k0.INSTANCE;
    }

    @Override // eo.e
    public op.h k0() {
        return op.h.c.f12406b;
    }

    @Override // eo.i
    public boolean l() {
        return false;
    }

    @Override // eo.e
    public eo.e l0() {
        return null;
    }

    @Override // eo.e, eo.i
    @l
    public List<e1> r() {
        return this.f996x;
    }

    @Override // eo.e, eo.d0
    @l
    public e0 s() {
        return e0.ABSTRACT;
    }

    @Override // eo.e
    public boolean t() {
        return false;
    }

    @l
    public String toString() {
        String strB = getName().b();
        l0.o(strB, "name.asString()");
        return strB;
    }

    @Override // eo.e
    public boolean u() {
        return false;
    }

    @Override // eo.e
    public boolean x() {
        return false;
    }

    @Override // eo.e
    @m
    public eo.z<n0> y() {
        return null;
    }
}
