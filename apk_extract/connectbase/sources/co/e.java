package co;

import ao.k;
import eo.e0;
import eo.h0;
import eo.k0;
import eo.m;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.w;
import nm.m0;
import nm.n1;
import nm.x;
import os.l;
import un.o;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements go.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final dp.f f1707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final dp.b f1708h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final h0 f1709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final jn.l<h0, m> f1710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final up.i f1711c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f1705e = {l1.f9319a.n(new g1(l1.d(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final b f1704d = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final dp.c f1706f = k.f565m;

    public static final class a extends n0 implements jn.l<h0, ao.b> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @l
        public final ao.b invoke(@l h0 h0Var) {
            l0.p(h0Var, "module");
            List<k0> listG0 = h0Var.o0(e.f1706f).g0();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listG0) {
                if (obj instanceof ao.b) {
                    arrayList.add(obj);
                }
            }
            return (ao.b) nm.h0.B2(arrayList);
        }
    }

    public static final class b {
        public b() {
        }

        @l
        public final dp.b a() {
            return e.f1708h;
        }

        public b(w wVar) {
        }
    }

    public static final class c extends n0 implements jn.a<ho.h> {
        final /* synthetic */ n $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(n nVar) {
            super(0);
            this.$storageManager = nVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final ho.h invoke() {
            ho.h hVar = new ho.h((m) e.this.f1710b.invoke(e.this.f1709a), e.f1707g, e0.ABSTRACT, eo.f.INTERFACE, x.k(e.this.f1709a.n().i()), z0.f4654a, false, this.$storageManager);
            hVar.E0(new co.a(this.$storageManager, hVar), m0.INSTANCE, null);
            return hVar;
        }
    }

    static {
        dp.d dVar = k.a.f577d;
        dp.f fVarI = dVar.i();
        l0.o(fVarI, "cloneable.shortName()");
        f1707g = fVarI;
        dp.b bVarM = dp.b.m(dVar.l());
        l0.o(bVarM, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f1708h = bVarM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@l n nVar, @l h0 h0Var, @l jn.l<? super h0, ? extends m> lVar) {
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "moduleDescriptor");
        l0.p(lVar, "computeContainingDeclaration");
        this.f1709a = h0Var;
        this.f1710b = lVar;
        this.f1711c = nVar.h(new c(nVar));
    }

    @Override // go.b
    @l
    public Collection<eo.e> a(@l dp.c cVar) {
        l0.p(cVar, "packageFqName");
        return l0.g(cVar, f1706f) ? n1.f(i()) : m0.INSTANCE;
    }

    @Override // go.b
    @os.m
    public eo.e b(@l dp.b bVar) {
        l0.p(bVar, "classId");
        if (l0.g(bVar, f1708h)) {
            return i();
        }
        return null;
    }

    @Override // go.b
    public boolean c(@l dp.c cVar, @l dp.f fVar) {
        l0.p(cVar, "packageFqName");
        l0.p(fVar, "name");
        return l0.g(fVar, f1707g) && l0.g(cVar, f1706f);
    }

    public final ho.h i() {
        return (ho.h) up.m.a(this.f1711c, this, f1705e[0]);
    }

    public /* synthetic */ e(n nVar, h0 h0Var, jn.l lVar, int i10, w wVar) {
        this(nVar, h0Var, (i10 & 4) != 0 ? a.INSTANCE : lVar);
    }
}
