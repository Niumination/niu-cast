package ik;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<g> f8101b;

    public static final class a extends kn.n0 implements jn.l<String, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l String str) {
            kn.l0.p(str, "it");
            return Boolean.valueOf(kn.l0.g(str, i1.Bytes.getUnitToken()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k1(@os.l String str, @os.l List<? extends g> list) {
        kn.l0.p(str, "unit");
        kn.l0.p(list, "ranges");
        this.f8100a = str;
        this.f8101b = list;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("It should be at least one range");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k1 d(k1 k1Var, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = k1Var.f8100a;
        }
        if ((i10 & 2) != 0) {
            list = k1Var.f8101b;
        }
        return k1Var.c(str, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(k1 k1Var, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = a.INSTANCE;
        }
        return k1Var.g(lVar);
    }

    public static /* synthetic */ List k(k1 k1Var, long j10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 50;
        }
        return k1Var.j(j10, i10);
    }

    @os.l
    public final String a() {
        return this.f8100a;
    }

    @os.l
    public final List<g> b() {
        return this.f8101b;
    }

    @os.l
    public final k1 c(@os.l String str, @os.l List<? extends g> list) {
        kn.l0.p(str, "unit");
        kn.l0.p(list, "ranges");
        return new k1(str, list);
    }

    @os.l
    public final List<g> e() {
        return this.f8101b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return kn.l0.g(this.f8100a, k1Var.f8100a) && kn.l0.g(this.f8101b, k1Var.f8101b);
    }

    @os.l
    public final String f() {
        return this.f8100a;
    }

    public final boolean g(@os.l jn.l<? super String, Boolean> lVar) {
        kn.l0.p(lVar, "rangeUnitPredicate");
        if (lVar.invoke(this.f8100a).booleanValue()) {
            List<g> list = this.f8101b;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (g gVar : list) {
                    if (gVar instanceof g.a) {
                        g.a aVar = (g.a) gVar;
                        long j10 = aVar.f7975a;
                        if (j10 < 0 || aVar.f7976b < j10) {
                        }
                    } else if (!(gVar instanceof g.c)) {
                        if (!(gVar instanceof g.b)) {
                            throw new lm.i0();
                        }
                        if (((g.b) gVar).f7977a < 0) {
                        }
                    } else if (((g.c) gVar).f7978a < 0) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f8101b.hashCode() + (this.f8100a.hashCode() * 31);
    }

    @os.l
    public final List<tn.o> i(long j10) {
        return j1.a(j1.c(this.f8101b, j10));
    }

    @os.l
    public final List<tn.o> j(long j10, int i10) {
        return this.f8101b.size() > i10 ? m(l(j10)) : i(j10);
    }

    @os.m
    public final tn.o l(long j10) {
        Object next;
        List<tn.o> listC = j1.c(this.f8101b, j10);
        Object next2 = null;
        if (listC.isEmpty()) {
            return null;
        }
        List<tn.o> list = listC;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long j11 = ((tn.o) next).f15921a;
                do {
                    Object next3 = it.next();
                    long j12 = ((tn.o) next3).f15921a;
                    if (j11 > j12) {
                        next = next3;
                        j11 = j12;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        kn.l0.m(next);
        long j13 = ((tn.o) next).f15921a;
        Iterator<T> it2 = list.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                long j14 = ((tn.o) next2).f15922b;
                do {
                    Object next4 = it2.next();
                    long j15 = ((tn.o) next4).f15922b;
                    if (j14 < j15) {
                        next2 = next4;
                        j14 = j15;
                    }
                } while (it2.hasNext());
            }
        }
        kn.l0.m(next2);
        return new tn.o(j13, tn.u.C(((tn.o) next2).f15922b, j10 - 1));
    }

    public final <T> List<T> m(T t10) {
        return t10 == null ? nm.k0.INSTANCE : nm.x.k(t10);
    }

    @os.l
    public String toString() {
        return nm.h0.m3(this.f8101b, ks.g.f9491d, kn.l0.C(this.f8100a, "="), null, 0, null, null, 60, null);
    }

    public /* synthetic */ k1(String str, List list, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? i1.Bytes.getUnitToken() : str, (List<? extends g>) list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k1(@os.l i1 i1Var, @os.l List<? extends g> list) {
        this(i1Var.getUnitToken(), list);
        kn.l0.p(i1Var, "unit");
        kn.l0.p(list, "ranges");
    }
}
