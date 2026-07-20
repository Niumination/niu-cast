package lm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@kn.r1({"SMAP\nUIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n*L\n62#1:87,3\n*E\n"})
@f1(version = "1.3")
@t
public final class x1 implements Collection<w1>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final int[] f10228a;

    public static final class a implements Iterator<w1>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final int[] f10229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10230b;

        public a(@os.l int[] iArr) {
            kn.l0.p(iArr, dc.d.f3685p);
            this.f10229a = iArr;
        }

        public int a() {
            int i10 = this.f10230b;
            int[] iArr = this.f10229a;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10230b));
            }
            this.f10230b = i10 + 1;
            return w1.m(iArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10230b < this.f10229a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ w1 next() {
            return w1.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @z0
    public /* synthetic */ x1(int[] iArr) {
        this.f10228a = iArr;
    }

    public static final /* synthetic */ x1 c(int[] iArr) {
        return new x1(iArr);
    }

    @os.l
    public static int[] e(int i10) {
        int[] iArr = new int[i10];
        kn.l0.p(iArr, "storage");
        return iArr;
    }

    @z0
    @os.l
    public static int[] f(@os.l int[] iArr) {
        kn.l0.p(iArr, "storage");
        return iArr;
    }

    public static boolean i(int[] iArr, int i10) {
        return nm.r.q8(iArr, i10);
    }

    public static boolean j(int[] iArr, @os.l Collection<w1> collection) {
        kn.l0.p(collection, "elements");
        Collection<w1> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof w1) || !nm.r.q8(iArr, ((w1) obj).f10227a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(int[] iArr, Object obj) {
        return (obj instanceof x1) && kn.l0.g(iArr, ((x1) obj).f10228a);
    }

    public static final boolean m(int[] iArr, int[] iArr2) {
        return kn.l0.g(iArr, iArr2);
    }

    public static final int n(int[] iArr, int i10) {
        return w1.m(iArr[i10]);
    }

    public static int q(int[] iArr) {
        return iArr.length;
    }

    @z0
    public static /* synthetic */ void r() {
    }

    public static int s(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean t(int[] iArr) {
        return iArr.length == 0;
    }

    @os.l
    public static Iterator<w1> u(int[] iArr) {
        return new a(iArr);
    }

    public static final void v(int[] iArr, int i10, int i11) {
        iArr[i10] = i11;
    }

    public static String w(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public boolean a(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(w1 w1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends w1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof w1)) {
            return false;
        }
        return nm.r.q8(this.f10228a, ((w1) obj).f10227a);
    }

    @Override // java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return j(this.f10228a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f10228a, obj);
    }

    public boolean g(int i10) {
        return nm.r.q8(this.f10228a, i10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return Arrays.hashCode(this.f10228a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f10228a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<w1> iterator() {
        return new a(this.f10228a);
    }

    public int o() {
        return this.f10228a.length;
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
        return this.f10228a.length;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kn.v.a(this);
    }

    public String toString() {
        return w(this.f10228a);
    }

    public final /* synthetic */ int[] x() {
        return this.f10228a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }
}
