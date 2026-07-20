package vo;

import java.util.Iterator;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements fo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dp.c f17604a;

    public b(@os.l dp.c cVar) {
        l0.p(cVar, "fqNameToMatch");
        this.f17604a = cVar;
    }

    @Override // fo.g
    @os.m
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        if (l0.g(cVar, this.f17604a)) {
            return a.f17603a;
        }
        return null;
    }

    @Override // fo.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<fo.c> iterator() {
        return k0.INSTANCE.iterator();
    }

    @Override // fo.g
    public boolean p(@os.l dp.c cVar) {
        return fo.g.b.b(this, cVar);
    }
}
