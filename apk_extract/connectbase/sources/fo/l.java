package fo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final g f6176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<dp.c, Boolean> f6178c;

    /* JADX WARN: Multi-variable type inference failed */
    public l(@os.l g gVar, boolean z10, @os.l jn.l<? super dp.c, Boolean> lVar) {
        l0.p(gVar, "delegate");
        l0.p(lVar, "fqNameFilter");
        this.f6176a = gVar;
        this.f6177b = z10;
        this.f6178c = lVar;
    }

    public final boolean a(c cVar) {
        dp.c cVarE = cVar.e();
        return cVarE != null && this.f6178c.invoke(cVarE).booleanValue();
    }

    @Override // fo.g
    @os.m
    public c d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        if (this.f6178c.invoke(cVar).booleanValue()) {
            return this.f6176a.d(cVar);
        }
        return null;
    }

    @Override // fo.g
    public boolean isEmpty() {
        boolean z10;
        g gVar = this.f6176a;
        if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                if (a(it.next())) {
                    z10 = true;
                    break;
                }
            }
        } else {
            z10 = false;
            break;
        }
        if (this.f6177b) {
            return !z10;
        }
        return z10;
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<c> iterator() {
        g gVar = this.f6176a;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (a(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    @Override // fo.g
    public boolean p(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        if (this.f6178c.invoke(cVar).booleanValue()) {
            return this.f6176a.p(cVar);
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(@os.l g gVar, @os.l jn.l<? super dp.c, Boolean> lVar) {
        this(gVar, false, lVar);
        l0.p(gVar, "delegate");
        l0.p(lVar, "fqNameFilter");
    }
}
