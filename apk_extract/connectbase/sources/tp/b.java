package tp;

import java.util.Iterator;
import java.util.List;
import kn.g1;
import kn.l0;
import kn.l1;

/* JADX INFO: loaded from: classes3.dex */
public class b implements fo.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f15952b = {l1.f9319a.n(new g1(l1.d(b.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final up.i f15953a;

    public b(@os.l up.n nVar, @os.l jn.a<? extends List<? extends fo.c>> aVar) {
        l0.p(nVar, "storageManager");
        l0.p(aVar, "compute");
        this.f15953a = nVar.h(aVar);
    }

    private final List<fo.c> a() {
        return (List) up.m.a(this.f15953a, this, f15952b[0]);
    }

    @Override // fo.g
    @os.m
    public fo.c d(@os.l dp.c cVar) {
        return fo.g.b.a(this, cVar);
    }

    @Override // fo.g
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<fo.c> iterator() {
        return a().iterator();
    }

    @Override // fo.g
    public boolean p(@os.l dp.c cVar) {
        return fo.g.b.b(this, cVar);
    }
}
