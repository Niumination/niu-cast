package vp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b1 extends f1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f17666c = new a();

    public static final class a {

        /* JADX INFO: renamed from: vp.b1$a$a, reason: collision with other inner class name */
        public static final class C0462a extends b1 {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Map<a1, c1> f17667d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f17668e;

            /* JADX WARN: Multi-variable type inference failed */
            public C0462a(Map<a1, ? extends c1> map, boolean z10) {
                this.f17667d = map;
                this.f17668e = z10;
            }

            @Override // vp.f1
            public boolean a() {
                return this.f17668e;
            }

            @Override // vp.f1
            public boolean f() {
                return this.f17667d.isEmpty();
            }

            @Override // vp.b1
            @os.m
            public c1 k(@os.l a1 a1Var) {
                kn.l0.p(a1Var, cb.b.c.f1408o);
                return this.f17667d.get(a1Var);
            }
        }

        public a() {
        }

        public static /* synthetic */ b1 e(a aVar, Map map, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return aVar.d(map, z10);
        }

        @in.n
        @os.l
        public final f1 a(@os.l f0 f0Var) {
            kn.l0.p(f0Var, "kotlinType");
            return b(f0Var.G0(), f0Var.F0());
        }

        @in.n
        @os.l
        public final f1 b(@os.l a1 a1Var, @os.l List<? extends c1> list) {
            kn.l0.p(a1Var, "typeConstructor");
            kn.l0.p(list, "arguments");
            List<eo.e1> parameters = a1Var.getParameters();
            kn.l0.o(parameters, "typeConstructor.parameters");
            eo.e1 e1Var = (eo.e1) nm.h0.v3(parameters);
            if (e1Var == null || !e1Var.T()) {
                return new d0(parameters, list);
            }
            List<eo.e1> parameters2 = a1Var.getParameters();
            kn.l0.o(parameters2, "typeConstructor.parameters");
            List<eo.e1> list2 = parameters2;
            ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((eo.e1) it.next()).i());
            }
            return e(this, nm.d1.D0(nm.h0.i6(arrayList, list)), false, 2, null);
        }

        @in.j
        @in.n
        @os.l
        public final b1 c(@os.l Map<a1, ? extends c1> map) {
            kn.l0.p(map, "map");
            return e(this, map, false, 2, null);
        }

        @in.j
        @in.n
        @os.l
        public final b1 d(@os.l Map<a1, ? extends c1> map, boolean z10) {
            kn.l0.p(map, "map");
            return new C0462a(map, z10);
        }

        public a(kn.w wVar) {
        }
    }

    @in.n
    @os.l
    public static final f1 i(@os.l a1 a1Var, @os.l List<? extends c1> list) {
        return f17666c.b(a1Var, list);
    }

    @in.j
    @in.n
    @os.l
    public static final b1 j(@os.l Map<a1, ? extends c1> map) {
        return f17666c.c(map);
    }

    @Override // vp.f1
    @os.m
    public c1 e(@os.l f0 f0Var) {
        kn.l0.p(f0Var, cb.b.c.f1408o);
        return k(f0Var.G0());
    }

    @os.m
    public abstract c1 k(@os.l a1 a1Var);
}
