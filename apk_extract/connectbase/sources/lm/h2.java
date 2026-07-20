package lm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@kn.r1({"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n62#1:87,3\n*E\n"})
@f1(version = "1.3")
@t
public final class h2 implements Collection<g2>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final short[] f10197a;

    public static final class a implements Iterator<g2>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final short[] f10198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10199b;

        public a(@os.l short[] sArr) {
            kn.l0.p(sArr, dc.d.f3685p);
            this.f10198a = sArr;
        }

        public short a() {
            int i10 = this.f10199b;
            short[] sArr = this.f10198a;
            if (i10 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10199b));
            }
            this.f10199b = i10 + 1;
            return g2.m(sArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10199b < this.f10198a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ g2 next() {
            return g2.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @z0
    public /* synthetic */ h2(short[] sArr) {
        this.f10197a = sArr;
    }

    public static final /* synthetic */ h2 c(short[] sArr) {
        return new h2(sArr);
    }

    @os.l
    public static short[] e(int i10) {
        short[] sArr = new short[i10];
        kn.l0.p(sArr, "storage");
        return sArr;
    }

    @z0
    @os.l
    public static short[] f(@os.l short[] sArr) {
        kn.l0.p(sArr, "storage");
        return sArr;
    }

    public static boolean i(short[] sArr, short s10) {
        return nm.r.t8(sArr, s10);
    }

    public static boolean j(short[] sArr, @os.l Collection<g2> collection) {
        kn.l0.p(collection, "elements");
        Collection<g2> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof g2) || !nm.r.t8(sArr, ((g2) obj).f10193a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(short[] sArr, Object obj) {
        return (obj instanceof h2) && kn.l0.g(sArr, ((h2) obj).f10197a);
    }

    public static final boolean m(short[] sArr, short[] sArr2) {
        return kn.l0.g(sArr, sArr2);
    }

    public static final short n(short[] sArr, int i10) {
        return g2.m(sArr[i10]);
    }

    public static int q(short[] sArr) {
        return sArr.length;
    }

    @z0
    public static /* synthetic */ void r() {
    }

    public static int s(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean t(short[] sArr) {
        return sArr.length == 0;
    }

    @os.l
    public static Iterator<g2> u(short[] sArr) {
        return new a(sArr);
    }

    public static final void v(short[] sArr, int i10, short s10) {
        sArr[i10] = s10;
    }

    public static String w(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public boolean a(short s10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(g2 g2Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends g2> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof g2)) {
            return false;
        }
        return nm.r.t8(this.f10197a, ((g2) obj).f10193a);
    }

    @Override // java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return j(this.f10197a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f10197a, obj);
    }

    public boolean g(short s10) {
        return nm.r.t8(this.f10197a, s10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return Arrays.hashCode(this.f10197a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f10197a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<g2> iterator() {
        return new a(this.f10197a);
    }

    public int o() {
        return this.f10197a.length;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public int size() {
        return this.f10197a.length;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kn.v.a(this);
    }

    public String toString() {
        return w(this.f10197a);
    }

    public final /* synthetic */ short[] x() {
        return this.f10197a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }
}
