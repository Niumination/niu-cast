package i4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5672c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f5673d;

    public p(q qVar) {
        this.f5673d = qVar;
        this.f5670a = qVar.f5678c;
        this.f5671b = qVar.firstEntryIndex();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5671b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        q qVar = this.f5673d;
        if (qVar.f5678c != this.f5670a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f5671b;
        this.f5672c = i8;
        Object objAccess$100 = q.access$100(qVar, i8);
        this.f5671b = qVar.getSuccessor(this.f5671b);
        return objAccess$100;
    }

    @Override // java.util.Iterator
    public final void remove() {
        q qVar = this.f5673d;
        if (qVar.f5678c != this.f5670a) {
            throw new ConcurrentModificationException();
        }
        v8.n(this.f5672c >= 0, "no calls to next() since the last call to remove()");
        this.f5670a += 32;
        qVar.remove(q.access$100(qVar, this.f5672c));
        this.f5671b = qVar.adjustAfterRemove(this.f5671b, this.f5672c);
        this.f5672c = -1;
    }
}
