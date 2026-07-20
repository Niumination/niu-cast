package fo;

import gq.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import nm.h0;
import nm.r;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<g> f6175a;

    public static final class a extends n0 implements jn.l<g, c> {
        final /* synthetic */ dp.c $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dp.c cVar) {
            super(1);
            this.$fqName = cVar;
        }

        @Override // jn.l
        @os.m
        public final c invoke(@os.l g gVar) {
            l0.p(gVar, "it");
            return gVar.d(this.$fqName);
        }
    }

    public static final class b extends n0 implements jn.l<g, gq.m<? extends c>> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final gq.m<c> invoke(@os.l g gVar) {
            l0.p(gVar, "it");
            return h0.A1(gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@os.l List<? extends g> list) {
        l0.p(list, "delegates");
        this.f6175a = list;
    }

    @Override // fo.g
    @os.m
    public c d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return (c) v.F0(v.p1(h0.A1(this.f6175a), new a(cVar)));
    }

    @Override // fo.g
    public boolean isEmpty() {
        List<g> list = this.f6175a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<c> iterator() {
        return v.H0(h0.A1(this.f6175a), b.INSTANCE).iterator();
    }

    @Override // fo.g
    public boolean p(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        Iterator it = h0.A1(this.f6175a).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).p(cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@os.l g... gVarArr) {
        this((List<? extends g>) r.Ky(gVarArr));
        l0.p(gVarArr, "delegates");
    }
}
