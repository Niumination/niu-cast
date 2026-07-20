package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class f<E> extends i<E> implements Serializable {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;
    transient j5<E> backingMap;
    transient long size;

    public class a extends f<E>.c<E> {
        public a() {
            super();
        }

        @Override // f1.f.c
        @m5
        public E b(int entryIndex) {
            return f.this.backingMap.j(entryIndex);
        }
    }

    public class b extends f<E>.c<b5.a<E>> {
        public b() {
            super();
        }

        @Override // f1.f.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b5.a<E> b(int entryIndex) {
            return f.this.backingMap.h(entryIndex);
        }
    }

    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4861b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4862c;

        public c() {
            this.f4860a = f.this.backingMap.f();
            this.f4862c = f.this.backingMap.f4990d;
        }

        public final void a() {
            if (f.this.backingMap.f4990d != this.f4862c) {
                throw new ConcurrentModificationException();
            }
        }

        @m5
        public abstract T b(int entryIndex);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f4860a >= 0;
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tB = b(this.f4860a);
            int i10 = this.f4860a;
            this.f4861b = i10;
            this.f4860a = f.this.backingMap.t(i10);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            b0.e(this.f4861b != -1);
            f fVar = f.this;
            fVar.size -= (long) fVar.backingMap.y(this.f4861b);
            this.f4860a = f.this.backingMap.u(this.f4860a, this.f4861b);
            this.f4861b = -1;
            this.f4862c = f.this.backingMap.f4990d;
        }
    }

    public f(int distinctElements) {
        this.backingMap = newBackingMap(distinctElements);
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        int i10 = stream.readInt();
        this.backingMap = newBackingMap(3);
        i6.g(this, stream, i10);
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        i6.k(this, stream);
    }

    @Override // f1.i, f1.b5
    @t1.a
    public final int add(@m5 E element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        c1.h0.k(occurrences > 0, "occurrences cannot be negative: %s", occurrences);
        int iN = this.backingMap.n(element);
        if (iN == -1) {
            this.backingMap.v(element, occurrences);
            this.size += (long) occurrences;
            return 0;
        }
        int iL = this.backingMap.l(iN);
        long j10 = occurrences;
        long j11 = ((long) iL) + j10;
        c1.h0.p(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.backingMap.C(iN, (int) j11);
        this.size += j10;
        return iL;
    }

    public void addTo(b5<? super E> b5Var) {
        b5Var.getClass();
        int iF = this.backingMap.f();
        while (iF >= 0) {
            b5Var.add(this.backingMap.j(iF), this.backingMap.l(iF));
            iF = this.backingMap.t(iF);
        }
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // f1.b5
    public final int count(@gm.a Object element) {
        return this.backingMap.g(element);
    }

    @Override // f1.i
    public final int distinctElements() {
        return this.backingMap.D();
    }

    @Override // f1.i
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // f1.i
    public final Iterator<b5.a<E>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
    public final Iterator<E> iterator() {
        return c5.n(this);
    }

    public abstract j5<E> newBackingMap(int distinctElements);

    @Override // f1.i, f1.b5
    @t1.a
    public final int remove(@gm.a Object element, int occurrences) {
        if (occurrences == 0) {
            return count(element);
        }
        c1.h0.k(occurrences > 0, "occurrences cannot be negative: %s", occurrences);
        int iN = this.backingMap.n(element);
        if (iN == -1) {
            return 0;
        }
        int iL = this.backingMap.l(iN);
        if (iL > occurrences) {
            this.backingMap.C(iN, iL - occurrences);
        } else {
            this.backingMap.y(iN);
            occurrences = iL;
        }
        this.size -= (long) occurrences;
        return iL;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public final int setCount(@m5 E element, int count) {
        b0.b(count, "count");
        j5<E> j5Var = this.backingMap;
        int iW = count == 0 ? j5Var.w(element) : j5Var.v(element, count);
        this.size += (long) (count - iW);
        return iW;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public final int size() {
        return o1.l.z(this.size);
    }

    @Override // f1.i, f1.b5
    public final boolean setCount(@m5 E element, int oldCount, int newCount) {
        b0.b(oldCount, "oldCount");
        b0.b(newCount, "newCount");
        int iN = this.backingMap.n(element);
        if (iN == -1) {
            if (oldCount != 0) {
                return false;
            }
            if (newCount > 0) {
                this.backingMap.v(element, newCount);
                this.size += (long) newCount;
            }
            return true;
        }
        if (this.backingMap.l(iN) != oldCount) {
            return false;
        }
        if (newCount == 0) {
            this.backingMap.y(iN);
            this.size -= (long) oldCount;
        } else {
            this.backingMap.C(iN, newCount);
            this.size += (long) (newCount - oldCount);
        }
        return true;
    }
}
