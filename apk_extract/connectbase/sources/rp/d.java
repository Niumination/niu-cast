package rp;

import eo.h0;
import eo.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.k0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements c<fo.c, jp.g<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final qp.a f14700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final e f14701b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14702a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.PROPERTY.ordinal()] = 1;
            iArr[b.PROPERTY_GETTER.ordinal()] = 2;
            iArr[b.PROPERTY_SETTER.ordinal()] = 3;
            f14702a = iArr;
        }
    }

    public d(@os.l h0 h0Var, @os.l j0 j0Var, @os.l qp.a aVar) {
        l0.p(h0Var, "module");
        l0.p(j0Var, "notFoundClasses");
        l0.p(aVar, "protocol");
        this.f14700a = aVar;
        this.f14701b = new e(h0Var, j0Var);
    }

    @Override // rp.c
    @os.l
    public List<fo.c> a(@os.l z zVar, @os.l yo.a.g gVar) {
        l0.p(zVar, "container");
        l0.p(gVar, "proto");
        Iterable iterable = (List) gVar.getExtension(this.f14700a.f14108i);
        if (iterable == null) {
            iterable = k0.INSTANCE;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14701b.a((yo.a.b) it.next(), zVar.f14779a));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> b(@os.l z zVar, @os.l fp.q qVar, @os.l b bVar) {
        l0.p(zVar, "container");
        l0.p(qVar, "proto");
        l0.p(bVar, "kind");
        return k0.INSTANCE;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> c(@os.l z zVar, @os.l yo.a.n nVar) {
        l0.p(zVar, "container");
        l0.p(nVar, "proto");
        return k0.INSTANCE;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> d(@os.l z zVar, @os.l fp.q qVar, @os.l b bVar, int i10, @os.l yo.a.u uVar) {
        l0.p(zVar, "container");
        l0.p(qVar, "callableProto");
        l0.p(bVar, "kind");
        l0.p(uVar, "proto");
        Iterable iterable = (List) uVar.getExtension(this.f14700a.f14110k);
        if (iterable == null) {
            iterable = k0.INSTANCE;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14701b.a((yo.a.b) it.next(), zVar.f14779a));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> e(@os.l yo.a.q qVar, @os.l ap.c cVar) {
        l0.p(qVar, "proto");
        l0.p(cVar, "nameResolver");
        Iterable iterable = (List) qVar.getExtension(this.f14700a.f14111l);
        if (iterable == null) {
            iterable = k0.INSTANCE;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14701b.a((yo.a.b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> f(@os.l z zVar, @os.l fp.q qVar, @os.l b bVar) {
        List list;
        l0.p(zVar, "container");
        l0.p(qVar, "proto");
        l0.p(bVar, "kind");
        if (qVar instanceof yo.a.d) {
            list = (List) ((yo.a.d) qVar).getExtension(this.f14700a.f14102c);
        } else if (qVar instanceof yo.a.i) {
            list = (List) ((yo.a.i) qVar).getExtension(this.f14700a.f14104e);
        } else {
            if (!(qVar instanceof yo.a.n)) {
                throw new IllegalStateException(l0.C("Unknown message: ", qVar).toString());
            }
            int i10 = a.f14702a[bVar.ordinal()];
            if (i10 == 1) {
                list = (List) ((yo.a.n) qVar).getExtension(this.f14700a.f14105f);
            } else if (i10 == 2) {
                list = (List) ((yo.a.n) qVar).getExtension(this.f14700a.f14106g);
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                list = (List) ((yo.a.n) qVar).getExtension(this.f14700a.f14107h);
            }
        }
        if (list == null) {
            list = k0.INSTANCE;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14701b.a((yo.a.b) it.next(), zVar.f14779a));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> g(@os.l z.a aVar) {
        l0.p(aVar, "container");
        Iterable iterable = (List) aVar.f14782d.getExtension(this.f14700a.f14103d);
        if (iterable == null) {
            iterable = k0.INSTANCE;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14701b.a((yo.a.b) it.next(), aVar.f14779a));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> h(@os.l z zVar, @os.l yo.a.n nVar) {
        l0.p(zVar, "container");
        l0.p(nVar, "proto");
        return k0.INSTANCE;
    }

    @Override // rp.c
    @os.l
    public List<fo.c> j(@os.l yo.a.s sVar, @os.l ap.c cVar) {
        l0.p(sVar, "proto");
        l0.p(cVar, "nameResolver");
        Iterable iterable = (List) sVar.getExtension(this.f14700a.f14112m);
        if (iterable == null) {
            iterable = k0.INSTANCE;
        }
        Iterable iterable2 = iterable;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable2, 10));
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f14701b.a((yo.a.b) it.next(), cVar));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.m
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public jp.g<?> i(@os.l z zVar, @os.l yo.a.n nVar, @os.l f0 f0Var) {
        l0.p(zVar, "container");
        l0.p(nVar, "proto");
        l0.p(f0Var, "expectedType");
        yo.a.b.C0559b.c cVar = (yo.a.b.C0559b.c) ap.e.a(nVar, this.f14700a.f14109j);
        if (cVar == null) {
            return null;
        }
        return this.f14701b.f(f0Var, cVar, zVar.f14779a);
    }
}
