package lm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@kn.r1({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n62#1:87,3\n*E\n"})
@f1(version = "1.3")
@t
public final class t1 implements Collection<s1>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final byte[] f10219a;

    public static final class a implements Iterator<s1>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final byte[] f10220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10221b;

        public a(@os.l byte[] bArr) {
            kn.l0.p(bArr, dc.d.f3685p);
            this.f10220a = bArr;
        }

        public byte a() {
            int i10 = this.f10221b;
            byte[] bArr = this.f10220a;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f10221b));
            }
            this.f10221b = i10 + 1;
            return s1.m(bArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10221b < this.f10220a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ s1 next() {
            return s1.b(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @z0
    public /* synthetic */ t1(byte[] bArr) {
        this.f10219a = bArr;
    }

    public static final /* synthetic */ t1 c(byte[] bArr) {
        return new t1(bArr);
    }

    @os.l
    public static byte[] e(int i10) {
        byte[] bArr = new byte[i10];
        kn.l0.p(bArr, "storage");
        return bArr;
    }

    @z0
    @os.l
    public static byte[] f(@os.l byte[] bArr) {
        kn.l0.p(bArr, "storage");
        return bArr;
    }

    public static boolean i(byte[] bArr, byte b10) {
        return nm.r.m8(bArr, b10);
    }

    public static boolean j(byte[] bArr, @os.l Collection<s1> collection) {
        kn.l0.p(collection, "elements");
        Collection<s1> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof s1) || !nm.r.m8(bArr, ((s1) obj).f10218a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(byte[] bArr, Object obj) {
        return (obj instanceof t1) && kn.l0.g(bArr, ((t1) obj).f10219a);
    }

    public static final boolean m(byte[] bArr, byte[] bArr2) {
        return kn.l0.g(bArr, bArr2);
    }

    public static final byte n(byte[] bArr, int i10) {
        return s1.m(bArr[i10]);
    }

    public static int q(byte[] bArr) {
        return bArr.length;
    }

    @z0
    public static /* synthetic */ void r() {
    }

    public static int s(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean t(byte[] bArr) {
        return bArr.length == 0;
    }

    @os.l
    public static Iterator<s1> u(byte[] bArr) {
        return new a(bArr);
    }

    public static final void v(byte[] bArr, int i10, byte b10) {
        bArr[i10] = b10;
    }

    public static String w(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public boolean a(byte b10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(s1 s1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends s1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof s1)) {
            return false;
        }
        return nm.r.m8(this.f10219a, ((s1) obj).f10218a);
    }

    @Override // java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return j(this.f10219a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f10219a, obj);
    }

    public boolean g(byte b10) {
        return nm.r.m8(this.f10219a, b10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return Arrays.hashCode(this.f10219a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f10219a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<s1> iterator() {
        return new a(this.f10219a);
    }

    public int o() {
        return this.f10219a.length;
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
        return this.f10219a.length;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kn.v.a(this);
    }

    public String toString() {
        return w(this.f10219a);
    }

    public final /* synthetic */ byte[] x() {
        return this.f10219a;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }
}
