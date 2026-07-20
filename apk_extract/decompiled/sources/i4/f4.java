package i4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class f4 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f5587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator f5588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b4 f5589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5590d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5591h;

    public f4(d dVar, Iterator it) {
        this.f5587a = dVar;
        this.f5588b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5590d > 0 || this.f5588b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.f5590d == 0) {
            b4 b4Var = (b4) this.f5588b.next();
            this.f5589c = b4Var;
            int count = b4Var.getCount();
            this.f5590d = count;
            this.e = count;
        }
        this.f5590d--;
        this.f5591h = true;
        b4 b4Var2 = this.f5589c;
        Objects.requireNonNull(b4Var2);
        return b4Var2.getElement();
    }

    @Override // java.util.Iterator
    public final void remove() {
        v8.n(this.f5591h, "no calls to next() since the last call to remove()");
        if (this.e == 1) {
            this.f5588b.remove();
        } else {
            b4 b4Var = this.f5589c;
            Objects.requireNonNull(b4Var);
            this.f5587a.remove(b4Var.getElement());
        }
        this.e--;
        this.f5591h = false;
    }
}
