package om;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kn.l0;
import kn.r1;
import kn.w;
import nm.p;
import nm.x;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
public final class b<E> extends nm.f<E> implements List<E>, RandomAccess, Serializable, ln.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f12305a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final b f12306b;

    @l
    private E[] array;

    @m
    private final b<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @m
    private final b<E> root;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX INFO: renamed from: om.b$b, reason: collision with other inner class name */
    @r1({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
    public static final class C0312b<E> implements ListIterator<E>, ln.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final b<E> f12307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12310d;

        public C0312b(@l b<E> bVar, int i10) {
            l0.p(bVar, "list");
            this.f12307a = bVar;
            this.f12308b = i10;
            this.f12309c = -1;
            this.f12310d = ((AbstractList) bVar).modCount;
        }

        private final void a() {
            if (((AbstractList) this.f12307a).modCount != this.f12310d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            a();
            b<E> bVar = this.f12307a;
            int i10 = this.f12308b;
            this.f12308b = i10 + 1;
            bVar.add(i10, e10);
            this.f12309c = -1;
            this.f12310d = ((AbstractList) this.f12307a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f12308b < ((b) this.f12307a).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f12308b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            a();
            if (this.f12308b >= ((b) this.f12307a).length) {
                throw new NoSuchElementException();
            }
            int i10 = this.f12308b;
            this.f12308b = i10 + 1;
            this.f12309c = i10;
            return (E) ((b) this.f12307a).array[((b) this.f12307a).offset + this.f12309c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f12308b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            a();
            int i10 = this.f12308b;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f12308b = i11;
            this.f12309c = i11;
            return (E) ((b) this.f12307a).array[((b) this.f12307a).offset + this.f12309c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f12308b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i10 = this.f12309c;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.f12307a.remove(i10);
            this.f12308b = this.f12309c;
            this.f12309c = -1;
            this.f12310d = ((AbstractList) this.f12307a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            a();
            int i10 = this.f12309c;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f12307a.set(i10, e10);
        }
    }

    static {
        b bVar = new b(0);
        bVar.isReadOnly = true;
        f12306b = bVar;
    }

    public b(E[] eArr, int i10, int i11, boolean z10, b<E> bVar, b<E> bVar2) {
        this.array = eArr;
        this.offset = i10;
        this.length = i11;
        this.isReadOnly = z10;
        this.backing = bVar;
        this.root = bVar2;
        if (bVar != null) {
            ((AbstractList) this).modCount = ((AbstractList) bVar).modCount;
        }
    }

    private final Object writeReplace() throws NotSerializableException {
        if (m()) {
            return new h(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    public final void a(int i10, Collection<? extends E> collection, int i11) {
        n();
        b<E> bVar = this.backing;
        if (bVar != null) {
            bVar.a(i10, collection, i11);
            this.array = this.backing.array;
            this.length += i11;
        } else {
            l(i10, i11);
            Iterator<? extends E> it = collection.iterator();
            for (int i12 = 0; i12 < i11; i12++) {
                this.array[i10 + i12] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        f();
        e();
        c(this.offset + this.length, e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@l Collection<? extends E> collection) {
        l0.p(collection, "elements");
        f();
        e();
        int size = collection.size();
        a(this.offset + this.length, collection, size);
        return size > 0;
    }

    @l
    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        f();
        this.isReadOnly = true;
        return this.length > 0 ? this : f12306b;
    }

    public final void c(int i10, E e10) {
        n();
        b<E> bVar = this.backing;
        if (bVar == null) {
            l(i10, 1);
            this.array[i10] = e10;
        } else {
            bVar.c(i10, e10);
            this.array = this.backing.array;
            this.length++;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        f();
        e();
        q(this.offset, this.length);
    }

    public final void e() {
        b<E> bVar = this.root;
        if (bVar != null && ((AbstractList) bVar).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@m Object obj) {
        e();
        return obj == this || ((obj instanceof List) && g((List) obj));
    }

    public final void f() {
        if (m()) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean g(List<?> list) {
        return c.h(this.array, this.offset, this.length, list);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        e();
        nm.c.Companion.b(i10, this.length);
        return this.array[this.offset + i10];
    }

    @Override // nm.f
    public int getSize() {
        e();
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        e();
        return c.i(this.array, this.offset, this.length);
    }

    public final void i(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.array;
        if (i10 > eArr.length) {
            this.array = (E[]) c.e(this.array, nm.c.Companion.e(eArr.length, i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        e();
        for (int i10 = 0; i10 < this.length; i10++) {
            if (l0.g(this.array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        e();
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @l
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    public final void j(int i10) {
        i(this.length + i10);
    }

    public final void l(int i10, int i11) {
        j(i11);
        E[] eArr = this.array;
        p.B0(eArr, eArr, i10 + i11, i10, this.offset + this.length);
        this.length += i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        e();
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (l0.g(this.array[this.offset + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @l
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public final boolean m() {
        b<E> bVar;
        return this.isReadOnly || ((bVar = this.root) != null && bVar.isReadOnly);
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    public final E o(int i10) {
        n();
        b<E> bVar = this.backing;
        if (bVar != null) {
            E eO = bVar.o(i10);
            this.length--;
            return eO;
        }
        E[] eArr = this.array;
        E e10 = eArr[i10];
        p.B0(eArr, eArr, i10, i10 + 1, this.offset + this.length);
        c.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e10;
    }

    public final void q(int i10, int i11) {
        if (i11 > 0) {
            n();
        }
        b<E> bVar = this.backing;
        if (bVar != null) {
            bVar.q(i10, i11);
        } else {
            E[] eArr = this.array;
            p.B0(eArr, eArr, i10, i10 + i11, this.length);
            E[] eArr2 = this.array;
            int i12 = this.length;
            c.g(eArr2, i12 - i11, i12);
        }
        this.length -= i11;
    }

    public final int r(int i10, int i11, Collection<? extends E> collection, boolean z10) {
        int iR;
        b<E> bVar = this.backing;
        if (bVar != null) {
            iR = bVar.r(i10, i11, collection, z10);
        } else {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i11) {
                int i14 = i10 + i12;
                if (collection.contains(this.array[i14]) == z10) {
                    E[] eArr = this.array;
                    i12++;
                    eArr[i13 + i10] = eArr[i14];
                    i13++;
                } else {
                    i12++;
                }
            }
            int i15 = i11 - i13;
            E[] eArr2 = this.array;
            p.B0(eArr2, eArr2, i10 + i13, i11 + i10, this.length);
            E[] eArr3 = this.array;
            int i16 = this.length;
            c.g(eArr3, i16 - i15, i16);
            iR = i15;
        }
        if (iR > 0) {
            n();
        }
        this.length -= iR;
        return iR;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        f();
        e();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        f();
        e();
        return r(this.offset, this.length, collection, false) > 0;
    }

    @Override // nm.f
    public E removeAt(int i10) {
        f();
        e();
        nm.c.Companion.b(i10, this.length);
        return o(this.offset + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        f();
        e();
        return r(this.offset, this.length, collection, true) > 0;
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        f();
        e();
        nm.c.Companion.b(i10, this.length);
        E[] eArr = this.array;
        int i11 = this.offset;
        E e11 = eArr[i11 + i10];
        eArr[i11 + i10] = e10;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    @l
    public List<E> subList(int i10, int i11) {
        nm.c.Companion.d(i10, i11, this.length);
        E[] eArr = this.array;
        int i12 = this.offset + i10;
        int i13 = i11 - i10;
        boolean z10 = this.isReadOnly;
        b<E> bVar = this.root;
        return new b(eArr, i12, i13, z10, this, bVar == null ? this : bVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @l
    public <T> T[] toArray(@l T[] tArr) {
        l0.p(tArr, RtspHeaders.Values.DESTINATION);
        e();
        int length = tArr.length;
        int i10 = this.length;
        if (length >= i10) {
            E[] eArr = this.array;
            int i11 = this.offset;
            p.B0(eArr, tArr, 0, i11, i10 + i11);
            return (T[]) x.n(this.length, tArr);
        }
        E[] eArr2 = this.array;
        int i12 = this.offset;
        T[] tArr2 = (T[]) Arrays.copyOfRange(eArr2, i12, i10 + i12, tArr.getClass());
        l0.o(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    @Override // java.util.AbstractCollection
    @l
    public String toString() {
        e();
        return c.j(this.array, this.offset, this.length, this);
    }

    @Override // java.util.AbstractList, java.util.List
    @l
    public ListIterator<E> listIterator(int i10) {
        e();
        nm.c.Companion.c(i10, this.length);
        return new C0312b(this, i10);
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        f();
        e();
        nm.c.Companion.c(i10, this.length);
        c(this.offset + i10, e10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @l Collection<? extends E> collection) {
        l0.p(collection, "elements");
        f();
        e();
        nm.c.Companion.c(i10, this.length);
        int size = collection.size();
        a(this.offset + i10, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @l
    public Object[] toArray() {
        e();
        E[] eArr = this.array;
        int i10 = this.offset;
        return p.l1(eArr, i10, this.length + i10);
    }

    public b() {
        this(10);
    }

    public b(int i10) {
        this(c.d(i10), 0, 0, false, null, null);
    }
}
