package gq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kn.l0;
import lm.c1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class n<T> extends o<T> implements Iterator<T>, um.d<l2>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public T f6865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public Iterator<? extends T> f6866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public um.d<? super l2> f6867d;

    @Override // gq.o
    @os.m
    public Object a(T t10, @os.l um.d<? super l2> dVar) {
        this.f6865b = t10;
        this.f6864a = 3;
        this.f6867d = dVar;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        xm.h.c(dVar);
        return aVar;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return um.i.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.f6864a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw m();
                }
                Iterator<? extends T> it = this.f6866c;
                l0.m(it);
                if (it.hasNext()) {
                    this.f6864a = 2;
                    return true;
                }
                this.f6866c = null;
            }
            this.f6864a = 5;
            um.d<? super l2> dVar = this.f6867d;
            l0.m(dVar);
            this.f6867d = null;
            c1.a aVar = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(l2.f10208a));
        }
    }

    @Override // gq.o
    @os.m
    public Object i(@os.l Iterator<? extends T> it, @os.l um.d<? super l2> dVar) {
        if (!it.hasNext()) {
            return l2.f10208a;
        }
        this.f6866c = it;
        this.f6864a = 2;
        this.f6867d = dVar;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        xm.h.c(dVar);
        return aVar;
    }

    public final Throwable m() {
        int i10 = this.f6864a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f6864a);
    }

    @os.m
    public final um.d<l2> n() {
        return this.f6867d;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i10 = this.f6864a;
        if (i10 == 0 || i10 == 1) {
            return o();
        }
        if (i10 == 2) {
            this.f6864a = 1;
            Iterator<? extends T> it = this.f6866c;
            l0.m(it);
            return it.next();
        }
        if (i10 != 3) {
            throw m();
        }
        this.f6864a = 0;
        T t10 = this.f6865b;
        this.f6865b = null;
        return t10;
    }

    public final T o() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void q(@os.m um.d<? super l2> dVar) {
        this.f6867d = dVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        d1.n(obj);
        this.f6864a = 4;
    }
}
