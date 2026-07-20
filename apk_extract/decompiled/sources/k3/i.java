package k3;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6487a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f6488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f6489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6490d;

    public i(k kVar, Iterator it) {
        this.f6490d = kVar;
        this.f6488b = it;
    }

    public void a() {
        m mVar = (m) this.f6490d;
        mVar.f();
        if (mVar.f6531b != ((Collection) this.f6489c)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f6487a) {
            case 0:
                break;
            case 1:
                break;
            default:
                a();
                break;
        }
        return this.f6488b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f6487a) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f6488b.next();
                this.f6489c = (Collection) entry.getValue();
                Object key = entry.getKey();
                return new a0(key, ((j) this.f6490d).f6501d.zzd(key, (Collection) entry.getValue()));
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f6488b.next();
                this.f6489c = entry2;
                return entry2.getKey();
            default:
                a();
                return this.f6488b.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f6487a) {
            case 0:
                na.c("no calls to next() since the last call to remove()", ((Collection) this.f6489c) != null);
                this.f6488b.remove();
                ((j) this.f6490d).f6501d.e -= ((Collection) this.f6489c).size();
                ((Collection) this.f6489c).clear();
                this.f6489c = null;
                break;
            case 1:
                na.c("no calls to next() since the last call to remove()", ((Map.Entry) this.f6489c) != null);
                Collection collection = (Collection) ((Map.Entry) this.f6489c).getValue();
                this.f6488b.remove();
                ((k) this.f6490d).f6511c.e -= collection.size();
                collection.clear();
                this.f6489c = null;
                break;
            default:
                this.f6488b.remove();
                m mVar = (m) this.f6490d;
                mVar.e.e--;
                mVar.g();
                break;
        }
    }

    public i(o oVar, ListIterator listIterator) {
        this.f6490d = oVar;
        this.f6489c = oVar.f6531b;
        this.f6488b = listIterator;
    }

    public i(j jVar) {
        this.f6490d = jVar;
        this.f6488b = jVar.f6500c.entrySet().iterator();
    }

    public i(m mVar) {
        Iterator it;
        this.f6490d = mVar;
        Collection collection = mVar.f6531b;
        this.f6489c = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.f6488b = it;
    }
}
