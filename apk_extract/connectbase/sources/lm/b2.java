package lm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@kn.r1({"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n62#1:87,3\n*E\n"})
@f1(version = "1.3")
@t
public final class b2 implements Collection<a2>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final long[] f10181a;

    public static final class a implements Iterator<a2>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final long[] f10182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10183b;

        public a(@os.l long[] jArr) {
            kn.l0.p(jArr, dc.d.f3685p);
            this.f10182a = jArr;
        }

        public long a() {
            int i10 = this.f10183b;
            long[] jArr = this.f10182a;
            if (i10 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10183b));
            }
            this.f10183b = i10 + 1;
            return a2.m(jArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10183b < this.f10182a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ a2 next() {
            return a2.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @z0
    public /* synthetic */ b2(long[] jArr) {
        this.f10181a = jArr;
    }

    public static final /* synthetic */ b2 c(long[] jArr) {
        return new b2(jArr);
    }

    @os.l
    public static long[] e(int i10) {
        long[] jArr = new long[i10];
        kn.l0.p(jArr, "storage");
        return jArr;
    }

    @z0
    @os.l
    public static long[] f(@os.l long[] jArr) {
        kn.l0.p(jArr, "storage");
        return jArr;
    }

    public static boolean i(long[] jArr, long j10) {
        return nm.r.r8(jArr, j10);
    }

    public static boolean j(long[] jArr, @os.l Collection<a2> collection) {
        kn.l0.p(collection, "elements");
        Collection<a2> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof a2) || !nm.r.r8(jArr, ((a2) obj).f10177a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(long[] jArr, Object obj) {
        return (obj instanceof b2) && kn.l0.g(jArr, ((b2) obj).f10181a);
    }

    public static final boolean m(long[] jArr, long[] jArr2) {
        return kn.l0.g(jArr, jArr2);
    }

    public static final long n(long[] jArr, int i10) {
        return a2.m(jArr[i10]);
    }

    public static int q(long[] jArr) {
        return jArr.length;
    }

    @z0
    public static /* synthetic */ void r() {
    }

    public static int s(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean t(long[] jArr) {
        return jArr.length == 0;
    }

    @os.l
    public static Iterator<a2> u(long[] jArr) {
        return new a(jArr);
    }

    public static final void v(long[] jArr, int i10, long j10) {
        jArr[i10] = j10;
    }

    public static String w(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public boolean a(long j10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(a2 a2Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends a2> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof a2)) {
            return false;
        }
        return nm.r.r8(this.f10181a, ((a2) obj).f10177a);
    }

    @Override // java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return j(this.f10181a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f10181a, obj);
    }

    public boolean g(long j10) {
        return nm.r.r8(this.f10181a, j10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return Arrays.hashCode(this.f10181a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f10181a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<a2> iterator() {
        return new a(this.f10181a);
    }

    public int o() {
        return this.f10181a.length;
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
        return this.f10181a.length;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kn.v.a(this);
    }

    public String toString() {
        return w(this.f10181a);
    }

    public final /* synthetic */ long[] x() {
        return this.f10181a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }
}
