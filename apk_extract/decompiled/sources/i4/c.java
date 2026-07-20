package i4;

import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5570d;
    public final /* synthetic */ Serializable e;

    public c(d dVar) {
        this.f5567a = 0;
        this.e = dVar;
        k4 k4Var = dVar.backingMap;
        this.f5568b = k4Var.f5624c == 0 ? -1 : 0;
        this.f5569c = -1;
        this.f5570d = k4Var.f5625d;
    }

    public abstract Object a(int i8);

    public abstract Object b(int i8);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5567a) {
            case 0:
                if (((d) this.e).backingMap.f5625d == this.f5570d) {
                    return this.f5568b >= 0;
                }
                throw new ConcurrentModificationException();
            default:
                return this.f5569c >= 0;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5567a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object objB = b(this.f5568b);
                int i8 = this.f5568b;
                this.f5569c = i8;
                int i9 = i8 + 1;
                if (i9 >= ((d) this.e).backingMap.f5624c) {
                    i9 = -1;
                }
                this.f5568b = i9;
                return objB;
            default:
                o oVar = (o) this.e;
                if (oVar.f5661b != this.f5568b) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i10 = this.f5569c;
                this.f5570d = i10;
                Object objA = a(i10);
                this.f5569c = oVar.getSuccessor(this.f5569c);
                return objA;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5567a) {
            case 0:
                d dVar = (d) this.e;
                if (dVar.backingMap.f5625d != this.f5570d) {
                    throw new ConcurrentModificationException();
                }
                v8.n(this.f5569c != -1, "no calls to next() since the last call to remove()");
                dVar.size -= (long) dVar.backingMap.h(this.f5569c);
                k4 k4Var = dVar.backingMap;
                int i8 = this.f5568b;
                k4Var.getClass();
                this.f5568b = i8 - 1;
                this.f5569c = -1;
                this.f5570d = dVar.backingMap.f5625d;
                return;
            default:
                o oVar = (o) this.e;
                if (oVar.f5661b != this.f5568b) {
                    throw new ConcurrentModificationException();
                }
                v8.n(this.f5570d >= 0, "no calls to next() since the last call to remove()");
                this.f5568b += 32;
                oVar.remove(o.access$100(oVar, this.f5570d));
                this.f5569c = oVar.adjustAfterRemove(this.f5569c, this.f5570d);
                this.f5570d = -1;
                return;
        }
    }

    public c(o oVar) {
        this.f5567a = 1;
        this.e = oVar;
        this.f5568b = oVar.f5661b;
        this.f5569c = oVar.firstEntryIndex();
        this.f5570d = -1;
    }
}
