package vp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements a1, yp.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public f0 f17674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final LinkedHashSet<f0> f17675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17676c;

    public static final class a extends kn.n0 implements jn.l<wp.g, n0> {
        public a() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final n0 invoke(@os.l wp.g gVar) {
            kn.l0.p(gVar, "kotlinTypeRefiner");
            return e0.this.b(gVar).g();
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.l f17677a;

        public b(jn.l lVar) {
            this.f17677a = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            f0 f0Var = (f0) t10;
            jn.l lVar = this.f17677a;
            kn.l0.o(f0Var, "it");
            String string = lVar.invoke(f0Var).toString();
            f0 f0Var2 = (f0) t11;
            jn.l lVar2 = this.f17677a;
            kn.l0.o(f0Var2, "it");
            return rm.g.l(string, lVar2.invoke(f0Var2).toString());
        }
    }

    public static final class c extends kn.n0 implements jn.l<f0, String> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l f0 f0Var) {
            kn.l0.p(f0Var, "it");
            return f0Var.toString();
        }
    }

    public static final class d extends kn.n0 implements jn.l<f0, CharSequence> {
        final /* synthetic */ jn.l<f0, Object> $getProperTypeRelatedToStringify;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(jn.l<? super f0, ? extends Object> lVar) {
            super(1);
            this.$getProperTypeRelatedToStringify = lVar;
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(f0 f0Var) {
            jn.l<f0, Object> lVar = this.$getProperTypeRelatedToStringify;
            kn.l0.o(f0Var, "it");
            return lVar.invoke(f0Var).toString();
        }
    }

    public e0(@os.l Collection<? extends f0> collection) {
        kn.l0.p(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<f0> linkedHashSet = new LinkedHashSet<>(collection);
        this.f17675b = linkedHashSet;
        this.f17676c = linkedHashSet.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String j(e0 e0Var, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = c.INSTANCE;
        }
        return e0Var.i(lVar);
    }

    @Override // vp.a1
    @os.l
    public Collection<f0> a() {
        return this.f17675b;
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

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            return kn.l0.g(this.f17675b, ((e0) obj).f17675b);
        }
        return false;
    }

    @os.l
    public final op.h f() {
        return op.n.f12414d.a("member scope for intersection type", this.f17675b);
    }

    @os.l
    public final n0 g() {
        fo.g.f6167h.getClass();
        return g0.m(fo.g.a.f6169b, this, nm.k0.INSTANCE, false, f(), new a());
    }

    @Override // vp.a1
    @os.l
    public List<eo.e1> getParameters() {
        return nm.k0.INSTANCE;
    }

    @os.m
    public final f0 h() {
        return this.f17674a;
    }

    public int hashCode() {
        return this.f17676c;
    }

    @os.l
    public final String i(@os.l jn.l<? super f0, ? extends Object> lVar) {
        kn.l0.p(lVar, "getProperTypeRelatedToStringify");
        return nm.h0.m3(nm.h0.u5(this.f17675b, new b(lVar)), " & ", "{", "}", 0, null, new d(lVar), 24, null);
    }

    @Override // vp.a1
    @os.l
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public e0 b(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        LinkedHashSet<f0> linkedHashSet = this.f17675b;
        ArrayList arrayList = new ArrayList(nm.z.b0(linkedHashSet, 10));
        Iterator<T> it = linkedHashSet.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            arrayList.add(((f0) it.next()).Q0(gVar));
            z10 = true;
        }
        e0 e0VarL = null;
        if (z10) {
            f0 f0Var = this.f17674a;
            e0VarL = new e0(arrayList).l(f0Var != null ? f0Var.Q0(gVar) : null);
        }
        return e0VarL == null ? this : e0VarL;
    }

    @os.l
    public final e0 l(@os.m f0 f0Var) {
        return new e0(this.f17675b, f0Var);
    }

    @Override // vp.a1
    @os.l
    public ao.h n() {
        ao.h hVarN = this.f17675b.iterator().next().G0().n();
        kn.l0.o(hVarN, "intersectedTypes.iterato…xt().constructor.builtIns");
        return hVarN;
    }

    @os.l
    public String toString() {
        return j(this, null, 1, null);
    }

    public e0(Collection<? extends f0> collection, f0 f0Var) {
        this(collection);
        this.f17674a = f0Var;
    }
}
