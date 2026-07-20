package eo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Collection<k0> f4622a;

    public static final class a extends kn.n0 implements jn.l<k0, dp.c> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final dp.c invoke(@os.l k0 k0Var) {
            kn.l0.p(k0Var, "it");
            return k0Var.e();
        }
    }

    public static final class b extends kn.n0 implements jn.l<dp.c, Boolean> {
        final /* synthetic */ dp.c $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dp.c cVar) {
            super(1);
            this.$fqName = cVar;
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l dp.c cVar) {
            kn.l0.p(cVar, "it");
            return Boolean.valueOf(!cVar.d() && kn.l0.g(cVar.e(), this.$fqName));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0(@os.l Collection<? extends k0> collection) {
        kn.l0.p(collection, "packageFragments");
        this.f4622a = collection;
    }

    @Override // eo.l0
    @os.l
    public List<k0> a(@os.l dp.c cVar) {
        kn.l0.p(cVar, "fqName");
        Collection<k0> collection = this.f4622a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kn.l0.g(((k0) obj).e(), cVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // eo.o0
    public boolean b(@os.l dp.c cVar) {
        kn.l0.p(cVar, "fqName");
        Collection<k0> collection = this.f4622a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (kn.l0.g(((k0) it.next()).e(), cVar)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eo.o0
    public void c(@os.l dp.c cVar, @os.l Collection<k0> collection) {
        kn.l0.p(cVar, "fqName");
        kn.l0.p(collection, "packageFragments");
        for (Object obj : this.f4622a) {
            if (kn.l0.g(((k0) obj).e(), cVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // eo.l0
    @os.l
    public Collection<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        kn.l0.p(cVar, "fqName");
        kn.l0.p(lVar, "nameFilter");
        return gq.v.c3(gq.v.p0(gq.v.k1(nm.h0.A1(this.f4622a), a.INSTANCE), new b(cVar)));
    }
}
