package kk;

import java.util.Iterator;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f6982d;
    public static final int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f6984b;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        f6981c = iIntValue;
        Unsafe unsafe = s.f6994a;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            e = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            e = iIntValue + 3;
        }
        f6982d = unsafe.arrayBaseOffset(Object[].class) + (32 << (e - iIntValue));
    }

    public a(int i8) {
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i8 - 1));
        this.f6983a = iNumberOfLeadingZeros - 1;
        this.f6984b = new Object[(iNumberOfLeadingZeros << f6981c) + 64];
    }

    public static Object e(Object[] objArr, long j8) {
        return s.f6994a.getObject(objArr, j8);
    }

    public static Object f(Object[] objArr, long j8) {
        return s.f6994a.getObjectVolatile(objArr, j8);
    }

    public static void g(Object[] objArr, long j8, Object obj) {
        s.f6994a.putOrderedObject(objArr, j8, obj);
    }

    public static void h(Object[] objArr, long j8, Object obj) {
        s.f6994a.putObject(objArr, j8, obj);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
