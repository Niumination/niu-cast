package jp;

import eo.h0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn.l0;
import lm.d0;
import lm.i0;
import nm.k0;
import vp.a1;
import vp.e1;
import vp.f0;
import vp.g0;
import vp.g1;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements a1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final a f8780f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h0 f8782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Set<f0> f8783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final n0 f8784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final d0 f8785e;

    public static final class a {

        /* JADX INFO: renamed from: jp.n$a$a, reason: collision with other inner class name */
        public enum EnumC0227a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f8787a;

            static {
                int[] iArr = new int[EnumC0227a.values().length];
                iArr[EnumC0227a.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[EnumC0227a.INTERSECTION_TYPE.ordinal()] = 2;
                f8787a = iArr;
            }
        }

        public a() {
        }

        public final n0 a(Collection<? extends n0> collection, EnumC0227a enumC0227a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                n0 n0Var = (n0) it.next();
                next = n.f8780f.e((n0) next, n0Var, enumC0227a);
            }
            return (n0) next;
        }

        @os.m
        public final n0 b(@os.l Collection<? extends n0> collection) {
            l0.p(collection, "types");
            return a(collection, EnumC0227a.INTERSECTION_TYPE);
        }

        public final n0 c(n nVar, n nVar2, EnumC0227a enumC0227a) {
            Set setI3;
            int i10 = b.f8787a[enumC0227a.ordinal()];
            if (i10 == 1) {
                setI3 = nm.h0.i3(nVar.f8783c, nVar2.f8783c);
            } else {
                if (i10 != 2) {
                    throw new i0();
                }
                setI3 = nm.h0.c6(nVar.f8783c, nVar2.f8783c);
            }
            n nVar3 = new n(nVar.f8781a, nVar.f8782b, setI3);
            fo.g.f6167h.getClass();
            return g0.e(fo.g.a.f6169b, nVar3, false);
        }

        public final n0 d(n nVar, n0 n0Var) {
            if (nVar.f8783c.contains(n0Var)) {
                return n0Var;
            }
            return null;
        }

        public final n0 e(n0 n0Var, n0 n0Var2, EnumC0227a enumC0227a) {
            if (n0Var == null || n0Var2 == null) {
                return null;
            }
            a1 a1VarG0 = n0Var.G0();
            a1 a1VarG1 = n0Var2.G0();
            boolean z10 = a1VarG0 instanceof n;
            if (z10 && (a1VarG1 instanceof n)) {
                return c((n) a1VarG0, (n) a1VarG1, enumC0227a);
            }
            if (z10) {
                return d((n) a1VarG0, n0Var2);
            }
            if (a1VarG1 instanceof n) {
                return d((n) a1VarG1, n0Var);
            }
            return null;
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends kn.n0 implements jn.a<List<n0>> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<n0> invoke() {
            n0 n0VarQ = n.this.f8782b.n().x().q();
            l0.o(n0VarQ, "builtIns.comparable.defaultType");
            List<n0> listS = nm.y.S(g1.f(n0VarQ, nm.x.k(new e1(o1.IN_VARIANCE, n.this.f8784d)), null, 2, null));
            if (!n.this.l()) {
                listS.add(n.this.f8782b.n().L());
            }
            return listS;
        }
    }

    public static final class c extends kn.n0 implements jn.l<f0, CharSequence> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l f0 f0Var) {
            l0.p(f0Var, "it");
            return f0Var.toString();
        }
    }

    public /* synthetic */ n(long j10, h0 h0Var, Set set, kn.w wVar) {
        this(j10, h0Var, set);
    }

    private final List<f0> k() {
        return (List) this.f8785e.getValue();
    }

    @Override // vp.a1
    @os.l
    public Collection<f0> a() {
        return k();
    }

    @Override // vp.a1
    @os.l
    public a1 b(@os.l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.a1
    @os.m
    public eo.h d() {
        return null;
    }

    @Override // vp.a1
    public boolean e() {
        return false;
    }

    @Override // vp.a1
    @os.l
    public List<eo.e1> getParameters() {
        return k0.INSTANCE;
    }

    @os.l
    public final Set<f0> j() {
        return this.f8783c;
    }

    public final boolean l() {
        Collection<f0> collectionA = t.a(this.f8782b);
        if ((collectionA instanceof Collection) && collectionA.isEmpty()) {
            return true;
        }
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            if (this.f8783c.contains((f0) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final String m() {
        return l.a.a(new StringBuilder("["), nm.h0.m3(this.f8783c, ks.g.f9491d, null, null, 0, null, c.INSTANCE, 30, null), ']');
    }

    @Override // vp.a1
    @os.l
    public ao.h n() {
        return this.f8782b.n();
    }

    @os.l
    public String toString() {
        return l0.C("IntegerLiteralType", m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(long j10, h0 h0Var, Set<? extends f0> set) {
        fo.g.f6167h.getClass();
        this.f8784d = g0.e(fo.g.a.f6169b, this, false);
        this.f8785e = lm.f0.b(new b());
        this.f8781a = j10;
        this.f8782b = h0Var;
        this.f8783c = set;
    }
}
